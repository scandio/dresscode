package de.scandio.dresscode;

import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO: description
 *
 * @author Georg Schmidl <georg.schmidl@scandio.de>
 */
public class FormProxy implements InvocationHandler {

    Map<String, Object> fieldMap;


    public FormProxy() {
        this.fieldMap = new HashMap<String, Object>();
    }


    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        if(method.getName().startsWith("get")) {
            return handleGetter(method);
        }
        return null;
    }

    protected Object handleGetter(Method method) throws Exception{
        if(fieldMap.get(method.getName()) == null) {
            fieldMap.put(method.getName(), createField(method));
        }
        return fieldMap.get(method.getName());
    }

    protected Object createField(Method method) throws Exception {
        ParameterizedType genericReturnType = (ParameterizedType) method.getGenericReturnType();
        Class inputClass = (Class) genericReturnType.getActualTypeArguments()[0];
        Class fieldClass = method.getReturnType();

        Constructor constructor =  fieldClass.getConstructor(Input.class);
        return constructor.newInstance(inputClass.newInstance());
    }
}
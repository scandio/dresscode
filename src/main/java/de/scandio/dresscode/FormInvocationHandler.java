package de.scandio.dresscode;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO: description
 *
 * @author Georg Schmidl <georg.schmidl@scandio.de>
 */
public class FormInvocationHandler implements InvocationHandler {

    private Map<String, Object> fieldMap;

    private Class<?> formClass;

    public FormInvocationHandler(Class<?> formClass) {
        this.fieldMap = new HashMap<String, Object>();
        this.formClass = formClass;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        if(method.getName().startsWith("get")) {
            return handleGetter(method);
        } else if (method.getName().equals("isValid")) {
            return isValid();
        }
        return null;
    }

    protected boolean isValid() throws Exception {
        for (Method fieldMethod: formClass.getDeclaredMethods()) {
            if (fieldMethod.getName().startsWith("get")) {
                Object field = handleGetter(fieldMethod);
                if (!((BaseField<?>) field).isValid()) {
                    return false;
                }
            }
        }
        return true;
    }

    protected Object handleGetter(Method method) throws Exception{
        if(fieldMap.get(method.getName()) == null) {
            fieldMap.put(method.getName(), createField(method));
        }
        return fieldMap.get(method.getName());
    }

    protected Object createField(Method method) throws Exception {
        ParameterizedType genericReturnType = (ParameterizedType) method.getGenericReturnType();
        Class validatorClass = (Class<?>) genericReturnType.getActualTypeArguments()[1];
        Class fieldClass = method.getReturnType();

        Validator<?> validator = (Validator<?>) validatorClass.newInstance();
        validator.setAnnotations(method.getAnnotations());

        Constructor constructor =  fieldClass.getConstructor(Validator.class);
        return constructor.newInstance(validator);
    }
}
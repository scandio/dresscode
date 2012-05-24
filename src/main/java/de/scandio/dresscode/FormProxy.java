package de.scandio.dresscode;

import java.lang.reflect.*;

/**
 * TODO: description
 *
 * @author Georg Schmidl <georg.schmidl@scandio.de>
 */
public class FormProxy implements InvocationHandler {

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        ParameterizedType genericReturnType = (ParameterizedType) method.getGenericReturnType();
        Class inputClass = (Class) genericReturnType.getActualTypeArguments()[0];

        Constructor constructor =  method.getReturnType().getConstructor(Input.class);
        return constructor.newInstance(inputClass.newInstance());
    }
}
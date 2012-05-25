package de.scandio.dresscode;

import javax.servlet.ServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * TODO: description
 *
 * @author Georg Schmidl <georg.schmidl@scandio.de>
 */
public class Dresscode {

    public static <T extends Form> T create(Class<T> formClass) {
        return (T) Proxy.newProxyInstance(formClass.getClassLoader(), new Class[]{formClass}, new FormInvocationHandler(formClass));
    }

    public static <T extends Form> T fromRequest(Class<T> formClass, ServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();

        T form = create(formClass);

        for (Method method: formClass.getDeclaredMethods()) {
            if (method.getName().startsWith("get")) {
                String parameterName = getParameterName(method.getName());

                if (parameterMap.containsKey(parameterName)) {
                    try {
                        Object field = method.invoke(form);
                        if (field instanceof Field) {
                            ((Field) field).setRaw(parameterMap.get(parameterName)[0]);
                        }
                    } catch (Exception e) {
                        continue;
                    }
                }
            }
        }

        return form;
    }

    private static String getParameterName(String methodName) {
        methodName = methodName.substring(3);
        return methodName.substring(0, 1).toLowerCase() + methodName.substring(1);
    }
}

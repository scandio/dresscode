package de.scandio.dresscode;

import java.lang.reflect.Proxy;

/**
 * TODO: description
 *
 * @author Georg Schmidl <georg.schmidl@scandio.de>
 */
public class Dresscode {

    public static <T extends Form> T create(Class<T> formClass) {
        return (T) Proxy.newProxyInstance(formClass.getClassLoader(), new Class[]{formClass}, new FormProxy());
    }
}

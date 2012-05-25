package de.scandio.dresscode.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * TODO: description
 *
 * @author Georg Schmidl <georg.schmidl@scandio.de>
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Required {
    int value() default 1;
}

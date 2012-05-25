package de.scandio.dresscode.validators;

import de.scandio.dresscode.Validator;
import de.scandio.dresscode.annotations.Required;

import java.util.Arrays;
import java.util.List;

/**
 * TODO: description
 *
 * @author Georg Schmidl <georg.schmidl@scandio.de>
 */
public class TextValidator extends Validator<String> {

    @Override
    protected String convert(String string) {
        return string;
    }

    @Override
    protected List<String> convertArray(String[] strings) {
        return Arrays.asList(strings);
    }

    @Override
    protected void validate() {
        if (getAnnotation(Required.class) != null) {
            Required required = (Required) getAnnotation(Required.class);
            if (required.value() > 0 && (getValue() == null || getValue().isEmpty())) {
                addError("required");
            }
        }
    }

    @Override
    protected void validateArray() {
        if (getAnnotation(Required.class) != null) {
            Required required = (Required) getAnnotation(Required.class);
            if (required.value() > 0 && (getValues() == null || getValues().size() < required.value())) {
                addError("required");
            }
        }
    }
}

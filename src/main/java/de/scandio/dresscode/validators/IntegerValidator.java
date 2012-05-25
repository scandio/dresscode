package de.scandio.dresscode.validators;

import de.scandio.dresscode.Validator;
import de.scandio.dresscode.annotations.Required;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: description
 *
 * @author Georg Schmidl <georg.schmidl@scandio.de>
 */
public class IntegerValidator extends Validator<Integer> {

    @Override
    protected Integer convert(String string) {
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException e) {
            addError("convert");
        }
        return null;
    }

    @Override
    protected List<Integer> convertArray(String[] strings) {
        List<Integer> list = new ArrayList<Integer>();
        for (String string: strings) {
            Integer integer = convert(string);
            if(integer != null) {
                list.add(integer);
            }
        }
        return list;
    }

    @Override
    protected void validate() {
        if (getAnnotation(Required.class) != null) {
            Required required = (Required) getAnnotation(Required.class);
            if (required.value() > 0 && getValue() == null) {
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

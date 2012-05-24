package de.scandio.dresscode.validators;

import de.scandio.dresscode.Validator;

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
}

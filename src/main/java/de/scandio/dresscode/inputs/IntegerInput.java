package de.scandio.dresscode.inputs;

import de.scandio.dresscode.Input;

/**
 * TODO: description
 *
 * @author Georg Schmidl <georg.schmidl@scandio.de>
 */
public class IntegerInput extends Input<Integer> {
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
}

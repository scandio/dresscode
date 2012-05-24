package de.scandio.dresscode.inputs;

import de.scandio.dresscode.Input;

/**
 * TODO: description
 *
 * @author Georg Schmidl <georg.schmidl@scandio.de>
 */
public class TextInput extends Input<String> {

    @Override
    protected String convert(String string) {
        return string;
    }
}

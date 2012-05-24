package de.scandio.dresscode;

import de.scandio.dresscode.inputs.IntegerInput;
import de.scandio.dresscode.inputs.TextInput;

/**
 * TODO: description
 *
 * @author Georg Schmidl <georg.schmidl@scandio.de>
 */
public interface ArticleForm extends Form {

    Field<TextInput> getTitle();

    Field<IntegerInput> getNumber();
}

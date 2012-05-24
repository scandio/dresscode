package de.scandio.dresscode;

import de.scandio.dresscode.inputs.IntegerInput;
import org.junit.Test;


/**
 * TODO: description
 *
 * @author Georg Schmidl <georg.schmidl@scandio.de>
 */
public class FormTest {

    @Test
    public void testCreateForm() throws Exception {
        ArticleForm form = Dresscode.create(ArticleForm.class);
    }

    @Test
    public void testGetValue() throws Exception {
        ArticleForm form = Dresscode.create(ArticleForm.class);
        Field<IntegerInput> numberField = form.getNumber();
        numberField.setRaw("42");
        Integer number = numberField.getInput().getValue();
    }
}

package de.scandio.dresscode;

import de.scandio.dresscode.inputs.IntegerInput;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;


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

    @Test
    public void testConvert() throws Exception {
        ArticleForm form = Dresscode.create(ArticleForm.class);
        Field<IntegerInput> numberField = form.getNumber();
        numberField.setRaw("42");
        Integer number = numberField.getInput().getValue();
        assertEquals(new Integer(42), number);
    }

    @Test
    public void testIsValid() throws Exception {
        ArticleForm form = Dresscode.create(ArticleForm.class);
        Field<IntegerInput> numberField = form.getNumber();

        numberField.setRaw("42");
        assertTrue(numberField.isValid());

        numberField.setRaw("foo");
        assertFalse(numberField.isValid());
    }
}

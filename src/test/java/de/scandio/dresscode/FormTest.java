package de.scandio.dresscode;

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
        Field<Integer> numberField = form.getNumber();
        numberField.setRaw("42");
        Integer number = numberField.getValue();
    }
}

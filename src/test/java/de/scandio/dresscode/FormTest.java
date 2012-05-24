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
}

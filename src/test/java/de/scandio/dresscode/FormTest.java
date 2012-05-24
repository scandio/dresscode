package de.scandio.dresscode;

import de.scandio.dresscode.inputs.IntegerInput;
import org.junit.Test;

import javax.servlet.ServletRequest;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


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

    @Test
    public void testFromRequest() throws Exception{
        Map<String, String[]> params = new HashMap<String, String[]>();
        params.put("title", new String[] {"Test Title"});
        params.put("number", new String[] {"42"});

        ServletRequest request = mock(ServletRequest.class);
        when(request.getParameterMap()).thenReturn(params);

        ArticleForm form = Dresscode.fromRequest(ArticleForm.class, request);

        assertEquals(true, form.isValid());
        assertEquals("Test Title", form.getTitle().getInput().getValue());
        assertEquals(new Integer(42), form.getNumber().getInput().getValue());
    }
}

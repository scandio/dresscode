package de.scandio.dresscode;

import de.scandio.dresscode.validators.IntegerValidator;
import org.junit.Test;

import javax.servlet.ServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.*;
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
        Field<Integer, IntegerValidator> numberField = form.getNumber();
        numberField.setRaw("42");
        Integer number = numberField.getValue();
    }

    @Test
    public void testConvert() throws Exception {
        ArticleForm form = Dresscode.create(ArticleForm.class);
        Field<Integer, IntegerValidator> numberField = form.getNumber();
        numberField.setRaw("42");
        Integer number = numberField.getValue();
        assertEquals(new Integer(42), number);
    }

    @Test
    public void testIsValid() throws Exception {
        ArticleForm form = Dresscode.create(ArticleForm.class);
        Field<Integer, IntegerValidator> numberField = form.getNumber();

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
        assertEquals("Test Title", form.getTitle().getValue());
        assertEquals(new Integer(42), form.getNumber().getValue());
    }

    @Test
    public void testGetValueList() throws Exception {
        ArticleForm form = Dresscode.create(ArticleForm.class);
        ListField<Integer, IntegerValidator> numbersField = form.getNumbers();
        numbersField.setRaw(new String[] {"42", "0", "1"});
        List<Integer> number = numbersField.getValues();
    }

    @Test
    public void testConvertList() throws Exception {
        ArticleForm form = Dresscode.create(ArticleForm.class);
        ListField<Integer, IntegerValidator> numbersField = form.getNumbers();
        numbersField.setRaw(new String[] {"42", "0", "1"});
        List<Integer> numbers = numbersField.getValues();

        List<Integer> expected = new ArrayList<Integer>();
        expected.add(42);
        expected.add(0);
        expected.add(1);

        assertEquals(expected, numbers);
    }

    @Test
    public void testIsValidList() throws Exception {
        ArticleForm form = Dresscode.create(ArticleForm.class);
        ListField<Integer, IntegerValidator> numbersField = form.getNumbers();
        form.getTitle().setRaw("required");

        numbersField.setRaw(new String[] {"42", "0", "1"});
        assertEquals(true, form.isValid());

        numbersField.setRaw(new String[] {"no number", "0", "1"});
        assertEquals(false, form.isValid());
    }

    @Test
    public void testRequired() throws Exception {
        Map<String, String[]> params = new HashMap<String, String[]>();
        params.put("number", new String[] {"42"});

        ServletRequest request = mock(ServletRequest.class);
        when(request.getParameterMap()).thenReturn(params);

        ArticleForm form = Dresscode.fromRequest(ArticleForm.class, request);

        assertEquals(false, form.isValid());

        params.put("title", new String[] {"Test"});
        form = Dresscode.fromRequest(ArticleForm.class, request);

        assertEquals(true, form.isValid());
    }
}

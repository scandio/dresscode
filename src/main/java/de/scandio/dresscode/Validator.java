package de.scandio.dresscode;

import de.scandio.dresscode.annotations.Required;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * TODO: description
 *
 * @author Georg Schmidl <georg.schmidl@scandio.de>
 */
public abstract class Validator<T> {

    private List<T> values;

    private Map<Class<?>, Annotation> annotations;

    private Set<String> errors;

    private boolean valueSet;

    protected Validator() {
        this.annotations = new HashMap<Class<?>, Annotation>();
        this.errors = new HashSet<String>();
    }

    protected T getValue() {
        if (this.values != null && !this.values.isEmpty()) {
            return this.values.get(0);
        }
        return null;
    }

    protected void setValue(T value) {
        if (this.values == null) {
            this.values = new ArrayList<T>();
        }
        this.values.add(value);
    }

    protected void setAnnotations(Annotation[] annotations) {
        if (annotations != null) {
            for (Annotation annotation: annotations) {
                this.annotations.put(annotation.annotationType(), annotation);
            }
        }
    }

    public Annotation getAnnotation(Class<?> annotationClass) {
        return this.annotations.get(annotationClass);
    }

    protected List<T> getValues() {
        return this.values;
    }

    protected void setValues(List<T> values) {
        this.values = values;
    }

    protected void addError(String error) {
        this.errors.add(error);
    }

    protected Set<String> getErrors() {
        return errors;
    }

    protected boolean isValid() {
        if(!this.valueSet) {
            if (getAnnotation(Required.class) != null) {
                Required required = (Required) getAnnotation(Required.class);
                if (required.value() > 0) {
                    addError("required");
                }
            }
        }
        return this.errors.isEmpty();
    }

    protected void put(String string) {
        setValue(convert(string));
        validate();
        this.valueSet =  true;
    }

    protected void putArray(String[] strings) {
        setValues(convertArray(strings));
        validateArray();
        this.valueSet = true;
    }

    protected abstract T convert(String string);

    protected abstract List<T> convertArray(String[] strings);

    protected abstract void validate();

    protected abstract void validateArray();
}

package de.scandio.dresscode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TODO: description
 *
 * @author Georg Schmidl <georg.schmidl@scandio.de>
 */
public abstract class Validator<T> {

    private List<T> values;

    private Set<String> errors;

    protected Validator() {
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

    protected List<T> getValues() {
        return this.values;
    }

    protected void setValues(List<T> values) {
        this.values = values;
    }

    protected void addError(String error) {
        this.errors.add(error);
    }

    protected boolean isValid() {
        return this.errors.isEmpty();
    }

    protected void put(String string) {
        setValue(convert(string));
    }

    protected void putArray(String[] strings) {
        setValues(convertArray(strings));
    }

    protected abstract T convert(String string);

    protected abstract List<T> convertArray(String[] strings);
}

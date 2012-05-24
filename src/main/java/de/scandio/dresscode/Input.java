package de.scandio.dresscode;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO: description
 *
 * @author Georg Schmidl <georg.schmidl@scandio.de>
 */
public abstract class Input<T> {

    private T value;

    private Set<String> errors;

    protected Input() {
        this.errors = new HashSet<String>();
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    protected void addError(String error) {
        this.errors.add(error);
    }

    public boolean isValid() {
        return this.errors.isEmpty();
    }

    public void put(String string) {
        setValue(convert(string));
    }

    protected abstract T convert(String string);
}

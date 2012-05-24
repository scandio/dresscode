package de.scandio.dresscode;

/**
 * TODO: description
 *
 * @author Georg Schmidl <georg.schmidl@scandio.de>
 */
public abstract class Input<T> {

    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void put(String string) {
        setValue(convert(string));
    }

    protected abstract T convert(String string);
}

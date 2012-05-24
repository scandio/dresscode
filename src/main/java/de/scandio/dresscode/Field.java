package de.scandio.dresscode;

/**
 * TODO: description
 *
 * @author Georg Schmidl <georg.schmidl@scandio.de>
 */
public class Field<T extends Input> {

    T input;
    String raw;

    public Field(T input) {
        this.input = input;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public T getInput() {
        return input;
    }
}

package de.scandio.dresscode;

/**
 * TODO: description
 *
 * @author Georg Schmidl <georg.schmidl@scandio.de>
 */
public class Field<S, T extends Validator<S>> extends BaseField<T> {

    private String raw;

    public Field(T validator) {
        super(validator);
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.validator.put(raw);
        this.raw = raw;
    }

    public S getValue() {
        return this.validator.getValue();
    }
}

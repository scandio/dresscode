package de.scandio.dresscode;

import java.util.List;

/**
 * TODO: description
 *
 * @author Georg Schmidl <georg.schmidl@scandio.de>
 */
public class ListField<S, T extends Validator<S>> extends BaseField<S, T> {

    private String[] raw;

    public ListField(T validator) {
        super(validator);
    }

    public String[] getRaw() {
        return raw;
    }

    public void setRaw(String[] raw) {
        this.validator.putArray(raw);
        this.raw = raw;
    }

    public List<S> getValues() {
        return this.validator.getValues();
    }
}

package de.scandio.dresscode;

/**
 * TODO: description
 *
 * @author Georg Schmidl <georg.schmidl@scandio.de>
 */
public class BaseField<T extends Validator> {

    protected T validator;

    public BaseField(T validator) {
        this.validator = validator;
    }

    public boolean isValid() {
        return this.validator.isValid();
    }
}

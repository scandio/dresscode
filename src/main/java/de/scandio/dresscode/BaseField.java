package de.scandio.dresscode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * TODO: description
 *
 * @author Georg Schmidl <georg.schmidl@scandio.de>
 */
public class BaseField<S, T extends Validator<?>> {

    protected T validator;

    private Map<String, S> options;

    public BaseField(T validator) {
        this.validator = validator;
    }

    public boolean isValid() {
        return this.validator.isValid();
    }

    public Set<String> getErrors() {
        return this.validator.getErrors();
    }

    public Map<String, S> getOptions() {
        return options;
    }

    public void setOptions(Map<String, S> options) {
        this.options = options;
    }

    public void addOption(String key, S value) {
        if (this.options == null) {
            this.options = new LinkedHashMap<String, S>();
        }
        this.options.put(key, value);
    }
}

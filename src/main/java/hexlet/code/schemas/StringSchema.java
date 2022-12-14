package hexlet.code.schemas;

import org.apache.commons.lang3.StringUtils;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        put("required", value -> value != null && !value.isEmpty());
        return this;
    }

    public StringSchema contains(final String needle) {
        put("contains",
                value -> StringUtils.contains(value, needle));
        return this;
    }

    public StringSchema minLength(final int length) {
        put("minLength", value -> value != null && value.length() >= length);
        return this;
    }
}

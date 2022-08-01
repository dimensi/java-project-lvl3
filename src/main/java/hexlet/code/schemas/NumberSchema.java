package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema required() {
        put("required", Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        put("positive", value -> value == null || value >= 0);
        return this;
    }

    public NumberSchema range(final int min, final int max) {
        put("range", value -> value != null && value >= min && value <= max);
        return this;
    }
}

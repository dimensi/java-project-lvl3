package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Object> {
    public NumberSchema required() {
        put("required", value -> value instanceof Integer);
        return this;
    }

    public NumberSchema positive() {
        put("positive", value -> value == null || (int) value >= 0);
        return this;
    }

    public NumberSchema range(final int min, final int max) {
        put("range", value -> value != null && (int) value >= min
                && (int) value <= max);
        return this;
    }
}

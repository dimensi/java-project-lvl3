package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Object> {
    private boolean isInteger(final Object value) {
        return value instanceof Integer;
    }
    public NumberSchema required() {
        put("required", this::isInteger);
        return this;
    }

    public NumberSchema positive() {
        put("positive", value -> {
            if (value == null) {
                return true;
            }
            if (!isInteger(value)) {
                return false;
            }
            return (int) value >= 0;
        });
        return this;
    }

    public NumberSchema range(final int min, final int max) {
        put("range", value -> {
            if (!isInteger(value)) {
                return false;
            }
            return (int) value >= min
                    && (int) value <= max;
        });
        return this;
    }
}

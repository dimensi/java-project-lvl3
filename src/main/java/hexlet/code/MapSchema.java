package hexlet.code;

import java.util.Map;
import java.util.Objects;

public final class MapSchema extends BaseSchema<Map> {
    public MapSchema required() {
        put("required", Objects::nonNull);
        return this;
    }

    public MapSchema sizeof(final int size) {
        put("sizeof", value -> value.size() == size);
        return this;
    }
}

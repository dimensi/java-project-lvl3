package hexlet.code.schemas;

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

    public MapSchema shape(final Map<String, BaseSchema> schemaMap) {
        put("shape", value -> {
            for (var entry : schemaMap.entrySet()) {
                var valueItem = value.get(entry.getKey());
                if (!entry.getValue().isValid(valueItem)) {
                    return false;
                }
            }
            return true;
        });
        return this;
    }
}

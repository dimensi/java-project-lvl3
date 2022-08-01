package hexlet.code;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public final class StringSchema {
    private final Map<String, Predicate<String>> predicateMap = new HashMap<>();

    public boolean isValid(final String value) {
        if (predicateMap.isEmpty()) {
            return true;
        }

        for (var predicate : predicateMap.values()) {
            if (!predicate.test(value)) {
                return false;
            }
        }

        return true;
    }

    public StringSchema required() {
        predicateMap.put("required", value -> !value.isEmpty());
        return this;
    }

    public StringSchema contains(final String needle) {
        predicateMap.put("contains",
                value -> StringUtils.contains(value, needle));
        return this;
    }

    public StringSchema minLength(final int length) {
        predicateMap.put("minLength", value -> value.length() >= length);
        return this;
    }
}

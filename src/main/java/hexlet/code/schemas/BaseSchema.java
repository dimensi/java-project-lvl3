package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema<T> {
    private final Map<String, Predicate<T>>
            predicateMap = new HashMap<>();


    /**
     * Put some predicate
     * @param name
     * @param predicate
     */
    void put(final String name, final Predicate<T> predicate) {
        predicateMap.put(name, predicate);
    }
    /**
     * Put value and return boolean
     * @param value
     * @return
     */
    public boolean isValid(final T value) {
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
}

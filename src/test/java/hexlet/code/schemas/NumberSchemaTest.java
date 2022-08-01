package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberSchemaTest {
    @Test
    void isValid() {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        assertThat(schema.isValid(null)).isTrue(); // true

        schema.required();

        assertThat(schema.isValid(null)).isFalse(); // false
        assertThat(schema.isValid(10)).isTrue(); // true

        assertThat(schema.positive().isValid(10)).isTrue(); // true
        assertThat(schema.isValid(-10)).isFalse(); // false

        schema.range(5, 10);

        assertThat(schema.isValid(5)).isTrue(); // true
        assertThat(schema.isValid(10)).isTrue(); // true
        assertThat(schema.isValid(4)).isFalse(); // false
        assertThat(schema.isValid(11)).isFalse(); // false
    }
}

package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringSchemaTest {

    @Test
    void isValid() {
        Validator v = new Validator();
        var schema = v.string();

        schema.required().contains("world");

        assertThat(schema.isValid("hello world")).isTrue();

        schema.contains("new");
        assertThat(schema.isValid("hello world")).isFalse();
        assertThat(schema.isValid("new world")).isTrue();

        schema = new StringSchema();

        schema.required();

        assertThat(schema.isValid("")).isFalse();

        schema.minLength(5);

        assertThat(schema.isValid("hell")).isFalse();
        assertThat(schema.isValid("hello")).isTrue();

        schema.minLength(10);
        assertThat(schema.isValid("hello")).isFalse();
    }
}

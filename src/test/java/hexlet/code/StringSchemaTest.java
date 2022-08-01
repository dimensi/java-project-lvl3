package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringSchemaTest {

    @Test
    void isValid() {
        var schema = new StringSchema();

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

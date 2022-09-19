package ru.marshenina;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class TxtFileTest {

    @Test
    void txtFileTest() throws IOException {
        String result;
        try (InputStream stream = getClass().getClassLoader()
                .getResourceAsStream("testTXT.txt")) {
            result = new String(stream.readAllBytes(), "UTF-8");
        }
        assertThat(result).contains("Today is very cold.");
    }
}

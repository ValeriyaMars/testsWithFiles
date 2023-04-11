package ru.marshenina.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class JsonParsingTest {
    private ClassLoader cl = JsonParsingTest.class.getClassLoader();

    @Test
    void jsonParsingTest() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> testUser = new HashMap<>();
        {
            testUser.put("userName", "Autotest123");
            testUser.put("userId", "123");
        }

        try (InputStream is = cl.getResourceAsStream("addPackage.json");
             InputStreamReader isr = new InputStreamReader(is)) {
            Package jsonPackage = mapper.readValue(isr, Package.class);

            assertEquals("New package", jsonPackage.getPackageName());
            assertEquals("2023-04-10", jsonPackage.getActiveDate());
            assertEquals(1, jsonPackage.getPeriod());
            assertEquals(8, jsonPackage.getPackageId());
            Assertions.assertTrue(!jsonPackage.isHaveActivePackage());
            assertEquals(List.of(1, 2, 3), jsonPackage.getOptions());
            assertEquals(testUser, jsonPackage.getUser());

        }

    }
}

package ru.marshenina;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class PdfTest {

    @Test
    void pdfFileTest() throws Exception {
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("testPDF.pdf")) {
            PDF parsed = new PDF(stream);
            assertThat(parsed.text).contains("ЭТМ");
        }
    }
}
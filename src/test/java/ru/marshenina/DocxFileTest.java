package ru.marshenina;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class DocxFileTest {

    @Test
    void textInFileCheck() throws Exception {
        try (InputStream docxStream = getClass().getClassLoader().getResourceAsStream("IntelIijIdea.docx")) {
            XWPFDocument docxFile = new XWPFDocument(OPCPackage.open(docxStream));
            XWPFWordExtractor extractor = new XWPFWordExtractor(docxFile);
            assertThat(extractor.getText()).contains("Ссылка на страницу скачивания IntelliJ IDEA");
        }
    }
}

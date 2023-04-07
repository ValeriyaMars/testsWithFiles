package ru.marshenina.tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.InvalidArgumentException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class TestsWithZipFile {

    private final ClassLoader cl = TestsWithZipFile.class.getClassLoader();

    private ZipInputStream getStreamFromArchive(String filename) throws IOException {
        ZipEntry entry;
        ZipInputStream zis;
        InputStream is = cl.getResourceAsStream("ezyzip.zip");
        assert is != null;
        zis = new ZipInputStream(is);
        while ((entry = zis.getNextEntry()) != null) {
            if (entry.getName().endsWith(filename)) return zis;
        }
        is.close();
        zis.close();
        throw new InvalidArgumentException("ERROR: File " + filename + " was not found in the archive" + "files.zip" + "\n");
    }


    @Test
    void pdfCheckProducerTest() throws Exception {
        try (InputStream inputStream = getStreamFromArchive(".pdf")) {
            PDF pdf = new PDF(inputStream);
            Assertions.assertEquals(pdf.producer, "www.ilovepdf.com");
        }
    }

    @Test
    void xlsCheckTotalSumTest() throws Exception {
        try (InputStream inputStream = getStreamFromArchive(".xls")) {
            XLS xls = new XLS(inputStream);
            Assertions.assertEquals(xls.excel.getSheetAt(0).getRow(42).getCell(0)
                    .getStringCellValue(), "ИТОГО: 33600 руб.");
        }
    }

    @Test
    void csvCheckFirstContentTest() throws Exception {
        try (InputStream inputStream = getStreamFromArchive(".csv")) {
            CSVReader csvReader = new CSVReader(new InputStreamReader(inputStream));
            List<String[]> content = csvReader.readAll();
            Assertions.assertArrayEquals(new String[]{"January;30000"}, content.get(0));
        }
    }
}
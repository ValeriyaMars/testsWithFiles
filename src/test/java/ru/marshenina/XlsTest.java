package ru.marshenina;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class XlsTest {

    @Test
    void xlsFileCheck() throws IOException {
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("testXLS.xls")) {
            XLS xlsParsed = new XLS(stream);
            System.out.println();
            assertThat(xlsParsed.excel.getSheetAt(1).getRow(1).getCell(2).getStringCellValue())
                    .isEqualTo("директор");
        }
    }
}

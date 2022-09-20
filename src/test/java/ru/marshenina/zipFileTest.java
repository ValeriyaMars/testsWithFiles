package ru.marshenina;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipParameters;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class zipFileTest {

    @Test
    void printZipFilesHeaders() throws Exception {
        List<FileHeader> fileHeaders = new ZipFile("C:/Users/Admin/testWithFiles/src/test/resources/zipWithPass.zip", "12345".toCharArray())
                .getFileHeaders();
        fileHeaders.stream().forEach(fileHeader -> System.out.println(fileHeader.getFileName()));
    }
}

package pl.edu.agh.dataExtraction;



import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileListerTest {

    private static final String file = "jsonData";

    private static void wrongArgumentExecutable() throws IOException {
        FileLister.listFiles(file, ".txt");
    }

    @Test
    void listFilesTest() throws IOException {
        assertThrows(IllegalArgumentException.class, FileListerTest::wrongArgumentExecutable,
                "W folderze " + file + " nie ma plików kończących się na: .txt");
        File[] files = {
                new File("jsonData/judgments-348.json"),
                new File("jsonData/judgments-356.json"),
                new File("jsonData/judgments-520.json"),
                new File("jsonData/judgments-924.json"),
                new File("jsonData/judgments-995.json"),
                new File("jsonData/judgments-1117.json"),
                new File("jsonData/judgments-1287.json"),
                new File("jsonData/judgments-1324.json"),
                new File("jsonData/judgments-1338.json"),
                new File("jsonData/judgments-1912.json")
        };
        List<File> fileList = Arrays.asList(files);
        var filesRead = Arrays.asList(FileLister.listFiles(file, ".json"));
        assertTrue(fileList.containsAll(filesRead));
    }

    @Test
    void foo() throws IOException {
       String[] tab = {"afs", "saff"} ;
        for (var s : ArrayUtils.addAll(tab, "asf", "asff")) {
            System.out.println(s);
        }
    }
}

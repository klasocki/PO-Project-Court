package pl.edu.agh.dataExtraction;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileListerTest {

    private static final String file ="jsonData";

    private static void wrongArgumentExecutable() throws IOException {
        FileLister.listFiles(file, ".txt");
    }

    @Test
    void listFiles() throws IOException {
        assertThrows(IllegalArgumentException.class, FileListerTest::wrongArgumentExecutable,
                "No files in directory " + file + " end with: .txt");
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
    void foo() {
        for(var s : "af asfoijf   ofisjj\nf".split("\\s+"))
        System.out.println(s);
        System.out.println("af asfoijf   ofisjj\nf".split("\\s+").length);
        var f = Paths.get("/dev/null");
        var s = new ArrayList<String>();
        s.add("asfasa");
        try {
            Files.write(f, s, Charset.forName("utf-8"));
        } catch (IOException e) {
            System.out.println("problem");
        }

    }
}
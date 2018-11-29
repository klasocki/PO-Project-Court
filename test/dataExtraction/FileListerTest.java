package dataExtraction;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileListerTest {

    private static final File file = new File("jsonData");
    private static void wrongArgumentExecute() {
        FileLister.listFiles(file, ".txt");
    }

    @Test
    void listFiles() {
        assertThrows(IllegalArgumentException.class, FileListerTest::wrongArgumentExecute, "No files in directory " + file.getPath() + " end with: .txt");
        List<String> list = new ArrayList<>();
        list.add("judgments-348.json");
        list.add("judgments-356.json");
        list.add("judgments-520.json");
        list.add("judgments-924.json");
        list.add("judgments-995.json");
        list.add("judgments-1117.json");
        list.add("judgments-1287.json");
        list.add("judgments-1324.json");
        list.add("judgments-1338.json");
        list.add("judgments-1912.json");
        assertTrue(list.containsAll(FileLister.listFiles(file, ".json")));

    }
}
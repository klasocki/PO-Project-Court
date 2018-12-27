package pl.edu.agh;

import pl.edu.agh.dataExtraction.JudgmentReaderJSON;
import pl.edu.agh.model.Judgment;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class TestFileReader {
    public static Map<String, Judgment> read() throws IOException {
        File testFile = new File("test/pl/edu/agh/dataExtraction/testJudgement.json");
        return read(testFile);
    }

    private static Map<String, Judgment> read(File testFile) throws IOException {
        var reader = new JudgmentReaderJSON();
        return reader.readAll(testFile);
    }


}

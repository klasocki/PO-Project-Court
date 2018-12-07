package pl.edu.agh;

import pl.edu.agh.dataExtraction.JudgmentReader;
import pl.edu.agh.model.Judgement;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestFileReader {
    public static Map<String, Judgement> read() throws IOException {
        File testFile = new File("test/pl/edu/agh/dataExtraction/testJudgement.json");
        return read(testFile);
    }

    public static Map<String, Judgement> read(File testFile) throws IOException {
        var reader = new JudgmentReader();
        return reader.readAll(testFile);
    }


}

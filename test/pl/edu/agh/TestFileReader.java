package pl.edu.agh;

import pl.edu.agh.dataExtraction.JudgementReader;
import pl.edu.agh.model.Judgement;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class TestFileReader {
    public static Map<String, Judgement> read() throws IOException {
        File testFile = new File("test/pl/edu/agh/dataExtraction/testJudgement.json");
        var reader = new JudgementReader();
        return reader.readAll(testFile);
    }
}

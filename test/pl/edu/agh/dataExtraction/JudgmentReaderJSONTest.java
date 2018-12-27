package pl.edu.agh.dataExtraction;

import pl.edu.agh.model.JSON.*;
import org.junit.jupiter.api.Test;
import pl.edu.agh.model.Judgment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JudgmentReaderJSONTest {
    private final File testFile = new File("test/pl/edu/agh/dataExtraction/testJudgement.json");

    @Test
    void readSingleTest() throws IOException {
        var judgementReader = new JudgmentReaderJSON();
        var judgement = judgementReader.readSingle(testFile, 0);
        assertEquals(judgement.getTextContent().substring(0, 36), "Orzeczenie z dnia 16 czerwca 1986 r.");
        assertNotEquals(new ArrayList<JudgeJSON>(), judgement.getJudges());
        assertEquals(judgement.getJudgmentDate().getMonthValue(), 6);
    }

    @Test
    void readExcTest() {
        JudgmentReaderJSON judgmentReaderJSON = new JudgmentReaderJSON();
        assertThrows(IndexOutOfBoundsException.class, () ->
                judgmentReaderJSON.readSingle(testFile, 1));
        assertThrows(FileNotFoundException.class, () ->
                judgmentReaderJSON.readSingle(new File("filefilehey.json"), 0));

        assertThrows(IllegalArgumentException.class,
                () -> judgmentReaderJSON.readAll(new File("test/pl/edu/agh/dataExtraction/empty.json")),
                "W pliku /home/kariok/IdeaProjects/PO-Project-Court/test/pl/edu/agh/dataExtraction/empty.json" +
                        " nie ma orzeczeń w formacie json");
    }

    @Test
    void readAllTest() throws IOException {
        File[] files = {testFile};
        var judgementReader = new JudgmentReaderJSON();
        var judgement = judgementReader.readSingle(testFile, 0);
        Map<String, Judgment> judgementsAllFiles = judgementReader.readAll(files);
        Map<String, Judgment> judgementsOneFile = judgementReader.readAll(testFile);
        assertTrue(judgementsAllFiles.keySet().containsAll(judgementsOneFile.keySet()));
        assertTrue(judgementsAllFiles.containsKey(judgement.getKey()) && judgementsOneFile.containsKey(judgement.getKey()));
    }
}

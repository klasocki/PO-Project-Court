package pl.edu.agh.commands;

import org.junit.jupiter.api.Test;
import pl.edu.agh.TestFileReader;
import pl.edu.agh.dataExtraction.FileLister;
import pl.edu.agh.dataExtraction.JudgmentReaderJSON;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JudgesPerJudgmentTest {

    @Test
    void getStats() throws IOException {
        var judgments = TestFileReader.read();
        var command = new JudgesPerJudgment(new String[]{} ,judgments, "");
        var expected = "Liczba orzeczeń wydanych przez skład z określoną liczbą sędziów\n" +
                "3: 1\n";
        assertEquals(expected, command.getStats());


        var reader = new JudgmentReaderJSON();
        judgments = reader.readAll(FileLister.listFiles("jsonData", ".json"));
        command = new JudgesPerJudgment(new String[]{} ,judgments, "");
        expected = "Liczba orzeczeń wydanych przez skład z określoną liczbą sędziów\n" +
                "3: 443\n" +
                "1: 436\n" +
                "0: 85\n" +
                "2: 10\n" +
                "5: 7\n" +
                "7: 2\n" +
                "13: 1\n" +
                "15: 1\n";
        assertEquals(command.getStats(), expected);
    }
}
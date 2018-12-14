package pl.edu.agh.commands;

import org.junit.jupiter.api.Test;
import pl.edu.agh.TestFileReader;
import pl.edu.agh.dataExtraction.FileLister;
import pl.edu.agh.dataExtraction.JudgmentReader;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JudgesPerJudgmentTest {

    @Test
    void getStats() throws IOException {
        var judgments = TestFileReader.read();
        var command = new JudgesPerJudgment(judgments);
        var expected = "Liczba orzeczeń wydanych przez skład z określoną liczbą sędziów\n" +
                "3: 1\n";
        assertEquals(expected, command.getStats());


        var reader = new JudgmentReader();
        judgments = reader.readAll(FileLister.listFiles(new File("jsonData"), ".json"));
        command = new JudgesPerJudgment(judgments);
        System.out.println(command.getStats());
    }
}
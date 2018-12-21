package pl.edu.agh.commands;

import org.junit.jupiter.api.Test;
import pl.edu.agh.TestFileReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JudgeJSONNoOfJudgmentsTest {
    @Test
    public void judgeJudgementsTest() throws IOException {
        var judgements = TestFileReader.read();
        JudgeNoOfJudgments jnoCommand = new JudgeNoOfJudgments(judgements);
        assertEquals(1, jnoCommand.getNumber("Kazimierz Buchała"));
        assertEquals(0, jnoCommand.getNumber("faopijfef09"));
    }

}
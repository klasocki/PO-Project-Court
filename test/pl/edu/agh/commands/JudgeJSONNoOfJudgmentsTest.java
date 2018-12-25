package pl.edu.agh.commands;

import org.junit.jupiter.api.Test;
import pl.edu.agh.TestFileReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JudgeJSONNoOfJudgmentsTest {
    @Test
    public void judgeJudgementsTest() throws IOException {
        var judgments = TestFileReader.read();
        JudgeNoOfJudgments jnoCommand = new JudgeNoOfJudgments(new String[]{} ,judgments, "");
        assertEquals(1, jnoCommand.getNumber("Kazimierz Buchała"));
        assertThrows(IllegalArgumentException.class, () -> jnoCommand.getNumber("faopijfef09"),
                "Sędzia faopijfef09 nie wydał żadnego orzeczenia przechowywanego w podanych plikach");
    }

}
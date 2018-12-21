package pl.edu.agh.commands;

import org.junit.jupiter.api.Test;
import pl.edu.agh.TestFileReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TopTenJudgesTest {

    @Test
    void getTopTen() throws IOException {
        var judgment = TestFileReader.read();
        var command = new TopTenJudges(judgment);
        var expected = "Sędziowie z największą liczbą wydanych orzeczeń\n" +
                "Andrzej Kabat - 1\n" +
                "Kazimierz Buchała - 1\n" +
                "Stanisław Pawela - 1\n";
        assertEquals(expected, command.getTopTen());
    }
}
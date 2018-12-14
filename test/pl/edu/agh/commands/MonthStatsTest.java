package pl.edu.agh.commands;

import org.junit.jupiter.api.Test;
import pl.edu.agh.TestFileReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MonthStatsTest {
    @Test
    public void getStatsTest() throws IOException {
        var judgements = TestFileReader.read();
        var command = new MonthStats(judgements);
        var expected = "Liczba orzeczeń w poszczególnych miesiacach (z uwzględnieniem wszystkich lat) \n" +
                "1: 0\n" +
                "2: 0\n" +
                "3: 0\n" +
                "4: 0\n" +
                "5: 0\n" +
                "6: 1\n" +
                "7: 0\n" +
                "8: 0\n" +
                "9: 0\n" +
                "10: 0\n" +
                "11: 0\n" +
                "12: 0\n";
        assertEquals(expected, command.getStats());
    }
}
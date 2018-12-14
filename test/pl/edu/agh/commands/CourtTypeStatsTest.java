package pl.edu.agh.commands;

import org.junit.jupiter.api.Test;
import pl.edu.agh.TestFileReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CourtTypeStatsTest {
    @Test
    public void getStatsTest() throws IOException {
        var judgment = TestFileReader.read();
        var expected = "Liczba orzeczeń danego typu sądu\n" +
                "Sąd powszechny: 0\n" +
                "Sąd Najwyższy: 0\n" +
                "Sąd Administracyjny: 0\n" +
                "Trybunał Konstytucyjny: 1\n" +
                "Krajowa Izba Odwoławcza: 0\n";
        var command = new CourtTypeStats(judgment);
        assertEquals(expected, command.getStats());
    }

}
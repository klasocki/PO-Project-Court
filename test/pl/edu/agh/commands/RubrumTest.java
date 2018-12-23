package pl.edu.agh.commands;

import org.junit.jupiter.api.Test;
import pl.edu.agh.TestFileReader;
import pl.edu.agh.model.JSON.CourtType;
import pl.edu.agh.model.JSON.JudgeJSON;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RubrumTest {
    @Test
    void getRubrumTest() throws IOException {
        var judgments = TestFileReader.read();
        String rubrum = "Sygnatura: U 3/86\n" +
                "Data: " + judgments.get("U 3/86").getJudgmentDate().toString()
                +"\nRodzaj sądu: " + CourtType.CONSTITUTIONAL_TRIBUNAL.toString()
                +"\nSędziowie: " +
                "\nAndrzej Kabat - " + JudgeJSON.SpecialRole.REPORTING_JUDGE.toString() +
                "\nKazimierz Buchała - " + JudgeJSON.SpecialRole.PRESIDING_JUDGE.toString() +
                "\nStanisław Pawela - ";
        var rubrumCommand = new Rubrum(new String[]{} ,judgments, "");
        assertEquals(rubrum, rubrumCommand.getRubrum("U 3/86"));
        var keys = new String[]{"U 3/86"};
        assertEquals(rubrum, rubrumCommand.getRubrum(keys));
        assertThrows(IllegalArgumentException.class, () -> rubrumCommand.getRubrum("adfs"),
                "Nie znaleziono orzeczenia o sygnaturze adfs");
        var wrongKeys = new String[]{"asd"};
        assertThrows(IllegalArgumentException.class, () -> rubrumCommand.getRubrum(wrongKeys),
                "Nie znaleziono orzeczenia o sygnaturze asd");
    }

}
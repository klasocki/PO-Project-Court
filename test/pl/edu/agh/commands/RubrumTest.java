package pl.edu.agh.commands;

import org.junit.jupiter.api.Test;
import pl.edu.agh.TestFileReader;
import pl.edu.agh.dataExtraction.JudgementReader;
import pl.edu.agh.model.CourtType;
import pl.edu.agh.model.Judge;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RubrumTest {
    @Test
    void getRubrumTest() throws IOException {
        var judgements = TestFileReader.read();
        String rubrum = "Sygnatura: U 3/86\n" +
                "Data: " + judgements.get("U 3/86").getJudgmentDate().toString()
                +"\nRodzaj sądu: " + CourtType.CONSTITUTIONAL_TRIBUNAL.toString()
                +"\nSędziowie: " +
                "\nAndrzej Kabat - " + Judge.SpecialRole.REPORTING_JUDGE.toString() +
                "\nKazimierz Buchała - " + Judge.SpecialRole.PRESIDING_JUDGE.toString() +
                "\nStanisław Pawela - ";
        var rubrumCommand = new Rubrum(judgements);
        assertEquals(rubrum, rubrumCommand.getRubrum("U 3/86"));
    }

}
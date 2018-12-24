package pl.edu.agh.model.HTML;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class JudgmentHTMLBuilderTest {
    @Test
    void buildJudgment() throws IOException {
        final String htmlContent = new String(Files.readAllBytes(Paths.get(
                "test/pl/edu/agh/model/HTML/8DCDF61AFF.html")),
                StandardCharsets.UTF_8);
        var builder = new JudgmentHTMLBuilder();
        var judgment = builder.buildJudgment(htmlContent);
        assertEquals("SA/Sz 360/02", judgment.getKey());
        assertEquals(3, judgment.getJudgmentDate().getMonthValue());
        assertEquals("Wojewódzki Sąd Administracyjny", judgment.getCourtType());
        assertEquals("sprawozdawca", judgment.getJudges().get(2).getSpecialRoles().get(1));
        assertEquals("Stefan Kłosowski", judgment.getJudges().get(2).getName());
        assertEquals("Ustawa z dnia 30 sierpnia 2002 r. Prawo o postępowaniu przed sądami administracyjnymi.",
                judgment.getReferencedRegulations().get(0).getJournalTitle());
        assertEquals("Decyzją z dnia", judgment.getTextContent().substring(0,14));
    }
}
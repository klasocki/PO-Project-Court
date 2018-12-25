package pl.edu.agh.dataExtraction;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JudgmentReaderHTMLTest {

    @Test
    void readJudgment() throws IOException {
        var reader = new JudgmentReaderHTML();
        var judgment = reader.readJudgment(new File("test/pl/edu/agh/model/HTML/8DCDF61AFF.html"));
        assertEquals(judgment.getKey(), "SA/Sz 360/02");
        assertThrows(IllegalArgumentException.class,
                () -> reader.readJudgment(new File("test/pl/edu/agh/dataExtraction/empty.html")),
                "W pliku /home/kariok/IdeaProjects/PO-Project-Court/test/pl/edu/agh/dataExtraction/empty.html" +
                        " nie ma orzeczeń w formacie html");
    }

}
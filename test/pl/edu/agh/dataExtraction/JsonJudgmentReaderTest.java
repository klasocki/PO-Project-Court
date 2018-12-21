package pl.edu.agh.dataExtraction;

import pl.edu.agh.model.JSON.*;
import org.junit.jupiter.api.Test;
import pl.edu.agh.model.Judgment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class JsonJudgmentReaderTest {
    private final File testFile = new File("test/pl/edu/agh/dataExtraction/testJudgement.json");

    @Test
    void readSingleTest() throws IOException {
        var judgementReader = new JsonJudgmentReader();
        var judgement = judgementReader.readSingle(testFile, 0);
        assertEquals(judgement.getTextContent(), "Orzeczenie\nz dnia 16 czerwca 1986 r.\n/U 3/86 r./\n\n\nTrybunał Konstytucyjny w składzie: \n\nPrzewodniczący: \tSędzia TK Kazimierz Buchała \n\nSędziowie TK: \tAndrzej Kabat (sprawozdawca) \nStanisław Pawela \n\nProtokolant: \tJerzy Adam Porowski \n\n\npo rozpatrzeniu w dniu 16 czerwca 1986 r. na rozprawie, z udziałem uczestników postępowania umocowanych przedstawicieli: Rady Ministrów, Ministra Handlu Wewnętrznego i Usług oraz Prokuratora Generalnego PRL, sprawy z wniosku Komitetu Wykonawczego Rady Krajowej Patriotycznego Ruchu Odrodzenia Narodowego o wydanie orzeczenia stwierdzającego niezgodność: \n\n1) przepisu § 2 ust. 2 rozporządzenia Rady Ministrów z dnia 28 października 1983 r. ...");
        assertNotEquals(new ArrayList<JudgeJSON>(), judgement.getJudges());
        assertEquals(judgement.getJudgmentDate().getMonthValue(), 6);
    }

    @Test
    void readExcTest() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            JsonJudgmentReader jsonJudgmentReader = new JsonJudgmentReader();
            jsonJudgmentReader.readSingle(testFile, 1);
        });
        assertThrows(FileNotFoundException.class, () -> {
            JsonJudgmentReader jsonJudgmentReader = new JsonJudgmentReader();
            jsonJudgmentReader.readSingle(new File("filefilehey.json"), 0);
        });
    }

    @Test
    void readAllTest() throws IOException{
        File[] files = {testFile};
        var judgementReader = new JsonJudgmentReader();
        var judgement = judgementReader.readSingle(testFile, 0);
        Map<String, Judgment> judgementsAllFiles = judgementReader.readAll(files);
        Map<String, Judgment> judgementsOneFile = judgementReader.readAll(testFile);
        assertTrue(judgementsAllFiles.keySet().containsAll(judgementsOneFile.keySet()));
        assertTrue(judgementsAllFiles.containsKey(judgement.getKey()) && judgementsOneFile.containsKey(judgement.getKey()));
    }
}

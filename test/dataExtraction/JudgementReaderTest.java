package dataExtraction;

import dataExtraction.JudgementReader;
import court.CourtCase;
import court.DissentingOpinion;
import court.Judge;
import court.Judgement;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JudgementReaderTest {
    private final File testFile = new File("test/dataExtraction/testJudgement.json");

    @Test
    void readSingleTest() throws IOException {
        var judgementReader = new JudgementReader();
        var judgement = judgementReader.readSingle(testFile, 0);
        assertEquals(judgement.getTextContent(), "Orzeczenie\nz dnia 16 czerwca 1986 r.\n/U 3/86 r./\n\n\nTrybunał Konstytucyjny w składzie: \n\nPrzewodniczący: \tSędzia TK Kazimierz Buchała \n\nSędziowie TK: \tAndrzej Kabat (sprawozdawca) \nStanisław Pawela \n\nProtokolant: \tJerzy Adam Porowski \n\n\npo rozpatrzeniu w dniu 16 czerwca 1986 r. na rozprawie, z udziałem uczestników postępowania umocowanych przedstawicieli: Rady Ministrów, Ministra Handlu Wewnętrznego i Usług oraz Prokuratora Generalnego PRL, sprawy z wniosku Komitetu Wykonawczego Rady Krajowej Patriotycznego Ruchu Odrodzenia Narodowego o wydanie orzeczenia stwierdzającego niezgodność: \n\n1) przepisu § 2 ust. 2 rozporządzenia Rady Ministrów z dnia 28 października 1983 r. ...");
        assertEquals(judgement.getDissentingOpinions(), new ArrayList<DissentingOpinion>());
        var courtCases = new ArrayList<CourtCase>();
        courtCases.add(new CourtCase("U 3/86"));
        assertEquals(judgement.getCourtCases(), courtCases);
        assertNotEquals(new ArrayList<Judge>(), judgement.getJudges());
    }

    @Test
    void readExcTest() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            JudgementReader judgementReader = new JudgementReader();
            Judgement judgement = judgementReader.readSingle(testFile, 1);
        });
        assertThrows(FileNotFoundException.class, () -> {
            JudgementReader judgementReader = new JudgementReader();
            Judgement judgement = judgementReader.readSingle(new File("filefilehey.json"), 0);
        });
    }

    @Test
    void readAllTest() throws IOException{
        File[] files = {testFile};
        var judgementReader = new JudgementReader();
        var judgement = judgementReader.readSingle(testFile, 0);
        var judgementsAllFiles = judgementReader.readAll(files);
        var judgementsOneFile = judgementReader.readAll(testFile);
        assertEquals(judgementsAllFiles, judgementsOneFile);
        assertTrue(judgementsAllFiles.containsValue(judgement) && judgementsOneFile.containsValue(judgement));
        assertTrue(judgementsAllFiles.containsKey(judgement.getKey()) && judgementsOneFile.containsKey(judgement.getKey()));
    }
}

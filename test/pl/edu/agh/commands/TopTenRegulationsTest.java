package pl.edu.agh.commands;

import org.junit.jupiter.api.Test;
import pl.edu.agh.dataExtraction.FileLister;
import pl.edu.agh.dataExtraction.JudgmentReaderJSON;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TopTenRegulationsTest {

    @Test
    void getTopTen() throws IOException {
        var reader = new JudgmentReaderJSON();
        var judgments = reader.readAll(FileLister.listFiles("jsonData", ".json"));
        var command = new TopTenRegulations(new String[]{} ,judgments, "");
        var expected = "Najczęściej przywoływane ustawy\n" +
                "Ustawa z dnia 17 listopada 1964 r. - Kodeks postępowania cywilnego - 628\n" +
                "Ustawa z dnia 23 kwietnia 1964 r. - Kodeks cywilny - 398\n" +
                "Konstytucja Rzeczypospolitej Polskiej z dnia 2 kwietnia 1997 r. - 136\n" +
                "Ustawa z dnia 6 czerwca 1997 r. - Kodeks karny - 135\n" +
                "Ustawa z dnia 6 czerwca 1997 r. - Kodeks postępowania karnego - 131\n" +
                "Rozporządzenie Prezesa Rady Ministrów z dnia 15 marca 2010 r. w sprawie wysokości i sposobu pobierania wpisu od odwołania oraz rodzajów kosztów w postępowaniu odwoławczym i sposobu ich rozliczania - 100\n" +
                "Obwieszczenie Marszałka Sejmu Rzeczypospolitej Polskiej z dnia 8 czerwca 2010 r. w sprawie ogłoszenia jednolitego tekstu ustawy - Prawo zamówień publicznych - 90\n" +
                "Rozporządzenie Ministra Sprawiedliwości z dnia 28 września 2002 r. w sprawie opłat za czynności adwokackie oraz ponoszenia przez Skarb Państwa kosztów nieopłaconej pomocy prawnej udzielonej z urzędu - 87\n" +
                "Ustawa z dnia 17 grudnia 1998 r. o emeryturach i rentach z Funduszu Ubezpieczeń Społecznych - 82\n" +
                "Rozporządzenie Ministra Sprawiedliwości z dnia 28 września 2002 r. w sprawie opłat za czynności radców prawnych oraz ponoszenia przez Skarb Państwa kosztów pomocy prawnej udzielonej przez radcę prawnego ustanowionego z urzędu - 75\n";
        assertEquals(expected, command.getTopTen());
    }

}
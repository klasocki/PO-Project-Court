package pl.edu.agh.commands;

import org.junit.jupiter.api.Test;
import pl.edu.agh.dataExtraction.FileLister;
import pl.edu.agh.dataExtraction.JudgmentReader;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TopTenRegulationsTest {

    @Test
    void getTopTen() throws IOException {
        var reader = new JudgmentReader();
        var judgments = reader.readAll(FileLister.listFiles("jsonData", ".json"));
        var command = new TopTenRegulations(judgments);
        System.out.println(command.getTopTen());
    }

}
package pl.edu.agh.commands;

import org.junit.jupiter.api.Test;
import pl.edu.agh.dataExtraction.FileLister;
import pl.edu.agh.dataExtraction.JsonJudgmentReader;

import java.io.IOException;

class TopTenRegulationsTest {

    @Test
    void getTopTen() throws IOException {
        var reader = new JsonJudgmentReader();
        var judgments = reader.readAll(FileLister.listFiles("jsonData", ".json"));
        var command = new TopTenRegulations(new String[]{} ,judgments, "");
        System.out.println(command.getTopTen());
    }

}
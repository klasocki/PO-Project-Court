package pl.edu.agh.dataExtraction;

import pl.edu.agh.console.Arguments;
import pl.edu.agh.model.Judgment;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public interface JudgmentReader {
    Map<String, Judgment> readAll(File[] files) throws IOException;

    static Map<String, Judgment> getJudgments(Arguments arguments) throws IOException, IllegalArgumentException {
        File[] filesJSON;
        File[] filesHTML;
        filesJSON = FileLister.listFiles(arguments.jsonFolder, ".json");
        filesHTML = FileLister.listFiles(arguments.htmlFolder, ".html");
        var readerJSON = new JudgmentReaderJSON();
        var readerHTML = new JudgmentReaderHTML();
        var judgments = readerJSON.readAll(filesJSON);
        judgments.putAll(readerHTML.readAll(filesHTML));
        if(judgments.isEmpty())
            throw new IllegalArgumentException("W podanych plikach nie znaleziono żadnych orzeczeń");
        return judgments;
    }
}

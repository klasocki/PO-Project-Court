package pl.edu.agh.dataExtraction;

import pl.edu.agh.model.HTML.JudgmentHTMLBuilder;
import pl.edu.agh.model.Judgment;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class JudgmentReaderHTML implements JudgmentReader{

    Judgment readJudgment(File file) throws IOException {
        String html = new String(Files.readAllBytes(Paths.get(file.getPath())), StandardCharsets.UTF_8);
        var builder = new JudgmentHTMLBuilder();
        return builder.buildJudgment(html);
    }

    @Override
    public Map<String, Judgment> readAll(File[] files) throws IOException {
        var result = new HashMap<String, Judgment>();
        for (var file : files) {
            var judgment = readJudgment(file);
            result.put(judgment.getKey(), judgment);
        }
        return result;
    }
}

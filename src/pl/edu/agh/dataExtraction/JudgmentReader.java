package pl.edu.agh.dataExtraction;

import pl.edu.agh.model.Judgment;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public interface JudgmentReader {
    Map<String, Judgment> readAll(File[] files) throws IOException;
}

package pl.edu.agh.dataExtraction;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import pl.edu.agh.model.JSON.JudgmentJSON;
import pl.edu.agh.model.Judgment;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class JudgmentReaderJSON implements JudgmentReader {
    public Map<String, Judgment> readAll(File file) throws IOException, IllegalArgumentException{
        var gson = new Gson();
        var jsonArray = readJsonArray(file);
        var result = new LinkedHashMap<String, Judgment>();
        for (var jsonElement : jsonArray) {
            var judgment = gson.fromJson(jsonElement, JudgmentJSON.class);
            result.put(judgment.getKey(), judgment);
        }
        return result;
    }

    public Map<String, Judgment> readAll(File[] files) throws IOException, IllegalArgumentException {
        var result = new LinkedHashMap<String, Judgment>();
        for (var file : files) {
            result.putAll(readAll(file));
        }
        return result;
    }

    private JsonArray readJsonArray(File file) throws IOException, IllegalArgumentException {
        try (FileReader reader = new FileReader(file)) {
            var gson = new Gson();
            var jsonObject = gson.fromJson(reader, JsonObject.class);
            if (jsonObject == null || jsonObject.isJsonNull())
                throw new IllegalArgumentException("W pliku " + file.getPath() + " nie ma orzeczeń w formacie json");
            JsonArray jsonArray = gson.fromJson(jsonObject.getAsJsonArray("items"), JsonArray.class);
            if (jsonArray == null || jsonArray.isJsonNull() || jsonArray.size() == 0) {
                throw new IllegalArgumentException("W pliku " + file.getPath() + " nie ma orzeczeń w formacie json");
            }
            return jsonArray;
        }
    }

    Judgment readSingle(File file, int index)
            throws IOException, IndexOutOfBoundsException, IllegalArgumentException{
        var gson = new Gson();
        var jsonArray = readJsonArray(file);
        return gson.fromJson(jsonArray.get(index), JudgmentJSON.class);
    }
}

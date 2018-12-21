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

public class JsonJudgmentReader {
    public Judgment readSingle(File file, int index) throws IOException, IndexOutOfBoundsException{
        var gson = new Gson();
        var jsonArray = readJsonArray(file);
        return gson.fromJson(jsonArray.get(index), JudgmentJSON.class);
}

    public Map<String, Judgment> readAll(File file) throws IOException{
        var gson = new Gson();
        var jsonArray = readJsonArray(file);
        var result = new LinkedHashMap<String, Judgment>();
        for (var jsonElement : jsonArray) {
            var judgment = gson.fromJson(jsonElement, JudgmentJSON.class);
            result.put(judgment.getKey(), judgment);
        }
        return result;
    }

    public Map<String, Judgment> readAll(File[] files) throws IOException {
        var result = new LinkedHashMap<String, Judgment>();
        for (var file : files) {
            result.putAll(readAll(file));
        }
        return result;
    }

    private JsonArray readJsonArray(File file) throws IOException {
        try (FileReader reader = new FileReader(file)) {
            var gson = new Gson();
            var jsonObject = gson.fromJson(reader, JsonObject.class);
            return gson.fromJson(jsonObject.getAsJsonArray("items"), JsonArray.class);
        }
    }
}

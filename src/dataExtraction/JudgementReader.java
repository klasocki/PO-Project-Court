package dataExtraction;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import court.Judgement;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JudgementReader {
    public Judgement readSingle(File file, int index) throws IOException, IndexOutOfBoundsException{
        var gson = new Gson();
        var jsonArray = readJsonArray(file);
        return gson.fromJson(jsonArray.get(index), Judgement.class);
}

    public Map<String, Judgement> readAll(File file) throws IOException{
        var gson = new Gson();
        var jsonArray = readJsonArray(file);
        var result = new LinkedHashMap<String, Judgement>();
        for (var jsonElement : jsonArray) {
            var judgement = gson.fromJson(jsonElement, Judgement.class);
            result.put(judgement.getKey(), judgement);
        }
        return result;
    }

    public Map<String, Judgement> readAll(File[] files) throws IOException {
        var result = new LinkedHashMap<String, Judgement>();
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

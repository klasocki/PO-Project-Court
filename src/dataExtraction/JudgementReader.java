package dataExtraction;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import court.Judgement;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JudgementReader {
    public Judgement readSingle(String filePath, int index) throws IOException, IndexOutOfBoundsException{
        var gson = new Gson();
        var jsonArray = readJsonArray(filePath);
        Judgement result = gson.fromJson(jsonArray.get(index), Judgement.class);
        return result;
}

    public Map<Integer, Judgement> readAll(String filePath) throws IOException{
        var gson = new Gson();
        var jsonArray = readJsonArray(filePath);
        var result = new LinkedHashMap<Integer, Judgement>();
        for (var jsonElement : jsonArray) {
            var judgement = gson.fromJson(jsonElement, Judgement.class);
            result.put(judgement.getId(), judgement);
        }
        return result;
    }

    public Map<Integer, Judgement> readAll(List<String> files) throws IOException {
        var result = new LinkedHashMap<Integer, Judgement>();
        for (String filePath : files) {
            result.putAll(readAll(filePath));
        }
        return result;
    }

    private JsonArray readJsonArray(String filePath) throws IOException {
        try (FileReader reader = new FileReader(filePath)) {
            var gson = new Gson();
            var jsonObject = gson.fromJson(reader, JsonObject.class);
            var jsonArray = gson.fromJson(jsonObject.getAsJsonArray("items"), JsonArray.class);
            return jsonArray;
        }
    }
}

package dataManipulation;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import court.Judgement;

import java.io.FileReader;
import java.io.IOException;

public class JudgementReader {
    public Judgement readSingle(String filePath, int index) throws IOException, IndexOutOfBoundsException{
        try (FileReader reader = new FileReader(filePath)) {
            var gson = new Gson();
            var jsonObject = gson.fromJson(reader, JsonObject.class);
            var jsonArray = gson.fromJson(jsonObject.getAsJsonArray("items"), JsonArray.class);
            Judgement result = gson.fromJson(jsonArray.get(index), Judgement.class);
            return result;
        }
    }
}

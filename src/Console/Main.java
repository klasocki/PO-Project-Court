package Console;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import court.CourtRuling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filename = "jsonData/judgments-348.json";

        try (FileReader reader = new FileReader(filename)) {
            Gson gson = new Gson();
            var jsonObject = gson.fromJson(reader, JsonObject.class);
            JsonArray jsonArray = gson.fromJson(jsonObject.getAsJsonArray("items"), JsonArray.class);
            CourtRuling ruling = gson.fromJson(jsonArray.get(0), CourtRuling.class);
            System.out.println(ruling.getCourtType());
        } catch (FileNotFoundException e) {
            System.out.println("Plik: " + filename + " nie istnieje");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Problem z otwarciem pliku: " + filename );
            System.out.println(e.getMessage());
        }
    }

}

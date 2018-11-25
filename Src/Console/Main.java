package Console;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filename = "jsonData/judgments-348.json";
        try (FileReader reader = new FileReader(filename)) {
            JsonReader jsonReader = Json.createReader(reader);
            JsonObject object = jsonReader.readObject();
            System.out.println("Hello world");
            System.out.println(object.toString());
            jsonReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Plik: " + filename + " nie istnieje");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Problem z otwarciem pliku: " + filename );
            System.out.println(e.getMessage());
        }

    }

}

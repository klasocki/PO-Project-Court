package pl.edu.agh.console;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.ZonedDateTime;

public class Arguments {
    private final static String DEV_NULL_PATH = "/dev/null";
    public final String jsonFolder;
    public final String htmlFolder;
    public final String outputFile;

    public Arguments(String jsonFolder, String htmlFolder, String outputFile) {
        this.jsonFolder = jsonFolder;
        this.htmlFolder = htmlFolder;
        this.outputFile = outputFile;
    }

    public static Arguments getArgs(String[] args) {
        if (args.length < 2 || 3 < args.length) {
            throw new IllegalArgumentException("Wymagane co najmniej 2 i conajwyżej 3 atrybuty\n" +
                    " podaj ścieżkę do folderu z orzeczeniami w formacie json\n" +
                    "ścieżkę do folderu z orzeczeniami w formacie html\n" +
                    " i opcjonalnie ścieżkę do pliku txt w którym mają być zapisywane wyniki komend");
        }
        final String jsonFolder = args[0];
        final String htmlFolder = args[1];
        if (!new File(jsonFolder).isDirectory() || !new File(htmlFolder).isDirectory()) {
            throw new IllegalArgumentException("Jeden z podanych argumentów: " + args[0] + ", " + args[1] +
                    " nie jest ścieżką do folderu");
        }
        String outputFile = (3 == args.length) ? args[2] : DEV_NULL_PATH;
        try {
            var initLog = "Sesja programu orzeczenia " + ZonedDateTime.now() + "\n";
            Files.write(Paths.get(outputFile), initLog.getBytes());
        } catch (IOException e) {
            throw new IllegalArgumentException("Problem z zapisem do pliku " + outputFile +
                    ", upewnij się że plik nie jest folderem i że masz do niego prawa zapisu");
        }
        return new Arguments(jsonFolder, htmlFolder, outputFile);
    }

}

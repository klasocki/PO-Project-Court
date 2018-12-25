package pl.edu.agh.console;

import pl.edu.agh.commands.CommandList;
import pl.edu.agh.dataExtraction.FileLister;
import pl.edu.agh.dataExtraction.JudgmentReader;
import pl.edu.agh.dataExtraction.JudgmentReaderHTML;
import pl.edu.agh.dataExtraction.JudgmentReaderJSON;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.ZonedDateTime;


public class Main {

    private final static String DEV_NULL_PATH = "/dev/null";

    public static void main(String[] args) {

        if (args.length < 2 || 3 < args.length) {
            System.out.println("Wymagane co najmniej 2 i conajwyżej 3 atrybuty\n" +
                    " podaj ścieżkę do folderu z orzeczeniami w formacie json\n" +
                    "ścieżkę do folderu z orzeczeniami w formacie html\n" +
                    " i opcjonalnie ścieżkę do pliku txt w którym mają być zapisywane wyniki komend");
            return;
        }
        final String jsonFolder = args[0];
        final String htmlFolder = args[1];
        if (!new File(jsonFolder).isDirectory() || !new File(htmlFolder).isDirectory()) {
            System.out.println("Jeden z podanych argumentów: " + args[0] + ", " + args[1] +
                    " nie jest ścieżką do folderu");
            return;
        }
        String outputFile = (3 == args.length) ? args[2] : DEV_NULL_PATH;
            try {
                var initLog = "Sesja programu orzeczenia " + ZonedDateTime.now() + "\n";
                Files.write(Paths.get(outputFile), initLog.getBytes());
        } catch (IOException e) {
            System.out.println("Problem z zapisem do pliku " + outputFile +
                    ", upewnij się że plik nie jest folderem i że masz do niego prawa zapisu");
            return;
        }
        File[] filesJSON;
        File[] filesHTML;
        try {
            System.out.println("Wczytywanie danych...");
            filesJSON = FileLister.listFiles(jsonFolder, ".json");
            filesHTML = FileLister.listFiles(htmlFolder, ".html");
            var readerJSON = new JudgmentReaderJSON();
            var readerHTML = new JudgmentReaderHTML();
            var judgments = readerJSON.readAll(filesJSON);
            judgments.putAll(readerHTML.readAll(filesHTML));

            var commandList = new CommandList(judgments, outputFile);
            var shell = new Shell(commandList);
            shell.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

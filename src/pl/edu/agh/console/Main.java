package pl.edu.agh.console;

import pl.edu.agh.commands.CommandList;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;


public class Main {

    private final static String DEV_NULL_PATH = "/dev/null";

    public static void main(String[] args) {

        if (args.length < 2 || 3 < args.length) {
            System.out.println("Wymagane co najmniej 2 i conajwyżej 3 atrybuty," +
                    " podaj ścieżkę do folderu z orzeczeniami w formacie json," +
                    "ścieżkę do folderu z orzeczeniami w formacie html" +
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
            FileUtils.writeToFile(outputFile, "Sesja programu orzeczenia " + LocalDate.now());
        } catch (IOException e) {
            System.out.println("Problem z zapisem do pliku " + outputFile +
                    ", upewnij się że plik nie jest folderem i że masz do niego prawa zapisu");
        }

/*
        var commandList = new CommandList(judgments, outputFile)
        var shell = new Shell(commandList);
        shell.run();
*/
    }

}

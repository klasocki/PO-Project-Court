package pl.edu.agh.console;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Wymagany 1 atrybut, podaj ścieżkę do folderu z orzeczeniami w formacie json");
            return;
        }
        final File folder = new File(args[0]);
        if (!folder.isDirectory()) {
            System.out.println("Podany argument: " + args[0] + " nie jest ścieżką do folderu" );
            return;
        }

        var shell = new Shell();
        shell.run();
        System.out.println("hello");
    }

}

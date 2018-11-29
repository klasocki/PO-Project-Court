package console;

import dataExtraction.FileLister;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Wymagany 1 atrybut, podaj ścieżkę do folderu z orzeczeniami w formacie json");
            return;
        }
        final File folder = new File(args[0]);
        if (!folder.isDirectory()) {
            System.out.println("Podany argument: " + args[0] + " nie jest ścieżką do folderu" );
        }

        try {
            Terminal terminal = TerminalBuilder.terminal();
            LineReader lineReader = LineReaderBuilder.builder()
                    .terminal(terminal)
                    .build();
            System.out.println(lineReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

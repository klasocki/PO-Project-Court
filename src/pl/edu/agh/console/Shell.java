package pl.edu.agh.console;

import java.util.LinkedList;

import org.jline.reader.*;
import org.jline.reader.impl.completer.*;
import org.jline.utils.*;


 class Shell {
     private String[] commandsList;

     public Shell(String[] commandsList) {
         this.commandsList = commandsList;
     }

    void run() {
        printWelcomeMessage();
        LineReader reader = prepareLineReader();

        String line;
        while ((line = readLine(reader, "orzeczenia")) != null) {
            var words = line.split("\\s+");
            switch (words[0]) {
                case "help":
                    printHelp();
                    break;
                case "exit":
                    System.out.println("Wychodzę z aplikacji...");
                    return;
                default:
                    break;
            }
        }

    }

     private LineReader prepareLineReader() {
         LineReaderBuilder readerBuilder = LineReaderBuilder.builder();
         var completers = new LinkedList<Completer>();
         completers.add(new StringsCompleter(commandsList));
         readerBuilder.completer(new ArgumentCompleter(completers));
         return readerBuilder.build();
     }

     private void printWelcomeMessage() {
        System.out.println("Witaj w programie orzeczenia. W celu uzyskania pomocy wćiśnij TAB lub wpisz \"help\" i wciśnij ENTER.");
    }

    private void printHelp() {
        System.out.println("help		- Pokaż pomoc");
        System.out.println("action1		- Execute action1");
        System.out.println("action2		- Execute action2");
        System.out.println("exit        - Exit the app");

    }

    private String readLine(LineReader reader, String promtMessage) {
        try {
            String line = reader.readLine(promtMessage + " > ");
            return line.trim();
        }
        catch (UserInterruptException e) {
            // e.g. ^C
            System.out.println("Przerwano wykonanie");
            return null;
        }
        catch (EndOfFileException e) {
            // e.g. ^D
            System.err.println("Reading line interrupted");
            return null;
        }
    }

}

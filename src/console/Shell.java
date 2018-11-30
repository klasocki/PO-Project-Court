package console;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import org.jline.reader.*;
import org.jline.reader.impl.completer.*;
import org.jline.utils.*;


 class Shell {
    private String[] commandsList = { "help", "action1", "action2", "exit" };

    void run() {
        printWelcomeMessage();
        LineReaderBuilder readerBuilder = LineReaderBuilder.builder();
        var completers = new LinkedList<Completer>();

        completers.add(new StringsCompleter(commandsList));
        readerBuilder.completer(new ArgumentCompleter(completers));

        LineReader reader = readerBuilder.build();

        String line;

        while ((line = readLine(reader, "orzeczenia")) != null) {
            switch (line) {
                case "help":
                    printHelp();
                    break;
                case "action1": {
                    AttributedStringBuilder a = new AttributedStringBuilder()
                            .append("You have selected ")
                            .append("action1", AttributedStyle.BOLD.foreground(AttributedStyle.RED))
                            .append("!");

                    System.out.println(a);
                    break;
                }
                case "action2": {
                    AttributedStringBuilder a = new AttributedStringBuilder()
                            .append("You have selected ")
                            .append("action2", AttributedStyle.BOLD.foreground(AttributedStyle.RED))
                            .append("!");

                    System.out.println(a);
                    break;
                }
                case "exit":
                    System.out.println("Wychodzę z aplikacji...");
                    return;
                default:
                    System.out.println("Zła komenda. W celu uzyskania pomocy wćiśnij TAB lub wpisz \"help\" i wciśnij ENTER.");
                    break;
            }
        }

    }

    private void printWelcomeMessage() {
        System.out.println("Witaj w programie orzeczenia. W celu uzyskania pomocy wćiśnij TAB lub wpisz \"help\" i wciśnij ENTER.");
    }

    private void printHelp() {
        System.out.println("help		- Show help");
        System.out.println("action1		- Execute action1");
        System.out.println("action2		- Execute action2");
        System.out.println("exit        - Exit the app");

    }

    private String readLine(LineReader reader, String promtMessage) {
        try {
            String line = reader.readLine(promtMessage + " shell> ");
            return line.trim();
        }
        catch (UserInterruptException e) {
            // e.g. ^C
            System.out.println("Przerwano wykonanie");
            return null;
        }
        catch (EndOfFileException e) {
            // e.g. ^D
            return null;
        }
    }

}

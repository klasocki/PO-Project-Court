package pl.edu.agh.console;

import java.util.Arrays;
import java.util.LinkedList;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.jline.reader.*;
import org.jline.reader.impl.completer.*;
import pl.edu.agh.commands.CommandList;

class Shell {
    private CommandList commandList;

    Shell(CommandList commandList) {
        this.commandList = commandList;
    }

    void run() {
        String promptMessage = "orzeczenia";

        printWelcomeMessage();
        LineReader reader = prepareLineReader();
        String line;
        while ((line = readLine(reader, promptMessage)) != null) {
            var words = line.split("\"");
            if (words.length == 0) System.out.println("Podaj nazwę komenty, wciśnij tab lub wpisz help aby uzyskać pomoc");
            String command = words[0].trim();
            var args = getCommandArguments(words);
            switch (command) {
                case "":
                    break;
                case "help":
                    printHelp();
                    break;
                case "exit":
                    System.out.println("Wychodzę z aplikacji...");
                    return;
                default:
                    parseAndExecute(command, args, line);
            }
        }

    }

    String[] getCommandArguments(String[] words) {
        if (words.length == 1) words = new String[]{};
        else words = Arrays.stream(Arrays.copyOfRange(words, 1, words.length))
                .filter(StringUtils::isNotBlank)
                .map(String::trim).map(StringUtils::normalizeSpace)
                .toArray(String[]::new);
        return words;
    }

    private void parseAndExecute(String command, String[] args, String line) {
        var com = commandList.parseCommand(command, args);
        try {
            com.execute(line);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void printWelcomeMessage() {
        System.out.println("Witaj w programie orzeczenia. W celu uzyskania pomocy wćiśnij TAB lub wpisz \"help\" i wciśnij ENTER.");
    }

    private void printHelp() {
        System.out.println("\nKomendy wymagające argumentów przyjmują je jako " +
                "ciagi znaków zawarte w cudzysłowach, oddzielone białym znakiem");
        System.out.println("help        - Pokaż pomoc");
        System.out.println("exit        - Wyjdź z aplikacji");
        System.out.println(commandList.helpMessage() + "\n");
    }

    private String readLine(LineReader reader, String promptMessage) {
        try {
            String line = reader.readLine(promptMessage + " > ");
            return line.trim();
        } catch (UserInterruptException e) {
            // e.g. ^C
            System.out.println("Przerwano wykonanie");
            return null;
        } catch (EndOfFileException e) {
            // e.g. ^D
            System.err.println("Reading line interrupted");
            return null;
        }
    }

    private LineReader prepareLineReader() {
        LineReaderBuilder readerBuilder = LineReaderBuilder.builder();
        var completers = new LinkedList<Completer>();
        String[] comList = ArrayUtils.addAll(commandList.getCommandList(), "help", "exit");
        completers.add(new StringsCompleter(comList ));
        readerBuilder.completer(new ArgumentCompleter(completers));
        return readerBuilder.build();
    }

}

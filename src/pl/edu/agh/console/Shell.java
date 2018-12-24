package pl.edu.agh.console;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.jline.reader.*;
import org.jline.reader.impl.completer.*;
import pl.edu.agh.commands.Command;
import pl.edu.agh.commands.CommandList;
import pl.edu.agh.model.Judgment;


class Shell {
    private CommandList commandList;
    private String promptMessage = "orzeczenia";

    public Shell(CommandList commandList) {
        this.commandList = commandList;
    }

    void run() {
        printWelcomeMessage();
        LineReader reader = prepareLineReader();

        String line;
        while ((line = readLine(reader, promptMessage)) != null) {
            var words = line.split("\"");
            if (words.length == 0) System.out.println("Podaj nazwę komenty, wciśnij tab lub wpisz help aby uzyskać pomoc");
            String command = words[0].trim();
            var args = getCommandArguments(words);
            switch (words[0]) {
                case "help":
                    printHelp();
                    break;
                case "exit":
                    System.out.println("Wychodzę z aplikacji...");
                    return;
                default:
                    parseAndExecute(command, args);
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

    private void parseAndExecute(String command, String[] args) {
        var com = commandList.parseCommand(command, args);
        com.execute();
    }

    private LineReader prepareLineReader() {
        LineReaderBuilder readerBuilder = LineReaderBuilder.builder();
        var completers = new LinkedList<Completer>();
        completers.add(new StringsCompleter(commandList.getCommandList()));
        readerBuilder.completer(new ArgumentCompleter(completers));
        return readerBuilder.build();
    }

    private void printWelcomeMessage() {
        System.out.println("Witaj w programie orzeczenia. W celu uzyskania pomocy wćiśnij TAB lub wpisz \"help\" i wciśnij ENTER.");
    }

    private void printHelp() {
        System.out.println("Komendy wymagające argumentów przyjmują je jako " +
                "ciagi znaków zawarte w cudzysłowach, oddzielone białym znakiem");
        System.out.println("help		- Pokaż pomoc");
        System.out.println("exit        - Wyjdź z aplikacji");
        System.out.println(commandList.helpMessage());
    }

    private String readLine(LineReader reader, String promtMessage) {
        try {
            String line = reader.readLine(promtMessage + " > ");
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

}

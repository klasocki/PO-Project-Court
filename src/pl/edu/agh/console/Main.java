package pl.edu.agh.console;

import pl.edu.agh.commands.CommandList;

import java.io.IOException;


public class Main {

    public static void main(String[] args) {
        Arguments arguments;
        try {
            arguments = Arguments.getArgs(args);
            System.out.println("Wczytywanie danych...");
            var shell = new Shell(CommandList.getCommandList(arguments));
            shell.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Problem z wczytaniem orzeczeń z podanych plików," +
                    " upewnij się że znajduje się w nich conajmniej jedno orzeczenie w odpowiednim formacie");
        }
    }

}

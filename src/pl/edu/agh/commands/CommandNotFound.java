package pl.edu.agh.commands;

public class CommandNotFound implements Command {
    @Override
    public void execute(String line) {
        System.out.println("Podana komenda nie istnieje, wciśnij tab lub wpisz help aby uzyskać pomoc");
    }
}

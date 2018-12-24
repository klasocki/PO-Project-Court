package pl.edu.agh.commands;


import pl.edu.agh.console.FileUtils;
import pl.edu.agh.model.Judgment;

import java.io.IOException;
import java.util.Map;

public class TextContent implements Command {
    private String[] args;
    private Map<String, Judgment> judgements;
    private String outputFilePath;

    public TextContent(String[] args, Map<String, Judgment> judgements, String outputFilePath) {
        this.args = args;
        this.judgements = judgements;
        this.outputFilePath = outputFilePath;
    }

    public String getTC(String key) {
        var judgement = judgements.get(key);
        if (judgement == null) {
            throw new IllegalArgumentException("Nie znaleziono orzeczenia o sygnaturze " + key);
        }
        return judgement.getTextContent();
    }


    @Override
    public void execute(String line) {
        if (args.length != 1) {
            System.out.println(CommandList.expectsOneArgument());
        } else {
            var result = "";
            try {
                result = (getTC(args[0]));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
            try {
                FileUtils.writeToFile(outputFilePath, "\n" + line + "\n" + result);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(result);
        }
    }

}

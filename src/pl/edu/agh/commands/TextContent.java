package pl.edu.agh.commands;

import pl.edu.agh.model.Judgment;

import java.util.Map;

public class TextContent implements Command {
    private String[] args;
    private Map<String, Judgment> judgements;
    private String outputFilePath;
    private ExecutorOneArg executor = new ExecutorOneArg();

    TextContent(String[] args, Map<String, Judgment> judgements, String outputFilePath) {
        this.args = args;
        this.judgements = judgements;
        this.outputFilePath = outputFilePath;
    }

    String getTC(String key) {
        var judgement = judgements.get(key);
        if (judgement == null) {
            throw new IllegalArgumentException("Nie znaleziono orzeczenia o sygnaturze " + key);
        }
        return judgement.getTextContent();
    }


    @Override
    public void execute(String line) {
        executor.execute(line, this::getTC, args, outputFilePath);
    }

}

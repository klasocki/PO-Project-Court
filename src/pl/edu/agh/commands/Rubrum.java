package pl.edu.agh.commands;

import pl.edu.agh.model.Judgment;

import java.util.Map;

public class Rubrum implements Command {

    private String[] args;
    private Map<String, Judgment> judgements;
    private String outputFilePath;
    private ExecutorMultipleArgs executor = new ExecutorMultipleArgs();

    Rubrum(String[] args, Map<String, Judgment> judgements, String outputFilePath) {
        this.args = args;
        this.judgements = judgements;
        this.outputFilePath = outputFilePath;
    }

    String getRubrum(String key) {
        var judgement = judgements.get(key);
        if (judgement == null) {
            throw new IllegalArgumentException("Nie znaleziono orzeczenia o sygnaturze " + key);
        }
        var builder = new StringBuilder();
        for (var judge : judgement.getJudges()) {
            builder.append("\n").append(judge.getName()).append(" - ");
            var prefix = "";
            for (var role : judge.getSpecialRoles()) {
                builder.append(prefix).append(role);
                prefix = ", ";
            }
        }
        return "Sygnatura: " + key +
                "\nData: " + judgement.getJudgmentDate().toString()
                + "\nRodzaj sądu: " + judgement.getCourtType()
                + "\nSędziowie: " +
                builder.toString();
    }

    String getRubrum(String[] keys) throws IllegalArgumentException {
        var builder = new StringBuilder();
        var prefix = "";
        for (var key : keys) {
            builder.append(prefix).append(getRubrum(key));
            prefix = "\n***************\n";
        }
        return builder.toString();
    }

    @Override
    public void execute(String line) {
        executor.execute(line, this::getRubrum, args, outputFilePath);
    }
}

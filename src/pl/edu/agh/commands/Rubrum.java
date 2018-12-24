package pl.edu.agh.commands;

import pl.edu.agh.console.FileUtils;
import pl.edu.agh.model.Judgment;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Rubrum implements Command {

    private String[] args;
    private Map<String, Judgment> judgements;
    private String outputFilePath;

    public Rubrum(String[] args, Map<String, Judgment> judgements, String outputFilePath) {
        this.args = args;
        this.judgements = judgements;
        this.outputFilePath = outputFilePath;
    }

    public String getRubrum(String key) {
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
                + "\nRodzaj sądu: " + judgement.getCourtType().toString()
                + "\nSędziowie: " +
                builder.toString();
    }

    public String getRubrum(String[] keys) throws IllegalArgumentException {
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
        if (args.length < 1) {
            System.out.println(CommandList.expectsOneOrMoreArguments());
        } else {
            var result = "";
            try {
                result = getRubrum(args);
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

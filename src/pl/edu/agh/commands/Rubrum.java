package pl.edu.agh.commands;

import pl.edu.agh.model.Judgment;

import java.util.List;
import java.util.Map;

public class Rubrum {
    private Map<String, Judgment> judgements;

    public Rubrum(Map<String, Judgment> judgements) {
        this.judgements = judgements;
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
                builder.append(prefix).append(role.toString());
                prefix = ", ";
            }
        }
        return "Sygnatura: " + key +
                "\nData: " + judgement.getJudgmentDate().toString()
                +"\nRodzaj sądu: " + judgement.getCourtType().toString()
                +"\nSędziowie: " +
                builder.toString();
    }

    public String getRubrum(List<String> keys) throws IllegalArgumentException{
        var builder = new StringBuilder();
        var prefix = "";
        for (var key : keys) {
            builder.append(getRubrum(key)).append(prefix);
            prefix = "\n***************";
        }
        return builder.toString();
    }
}

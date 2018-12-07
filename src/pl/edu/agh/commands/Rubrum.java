package pl.edu.agh.commands;

import pl.edu.agh.model.CourtType;
import pl.edu.agh.model.Judge;
import pl.edu.agh.model.Judgement;

import java.util.Map;

public class Rubrum {
    private Map<String, Judgement> judgements;

    public Rubrum(Map<String, Judgement> judgements) {
        this.judgements = judgements;
    }

    public String getRubrum(String key) {
        var judgement = judgements.get(key);
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
}

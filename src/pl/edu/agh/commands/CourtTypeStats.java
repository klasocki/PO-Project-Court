package pl.edu.agh.commands;

import pl.edu.agh.model.CourtType;
import pl.edu.agh.model.Judgement;

import java.util.Map;

public class CourtTypeStats {
    private Map<String, Judgement> judgements;

    public CourtTypeStats(Map<String, Judgement> judgements) {
        this.judgements = judgements;
    }

    public String getStats() {
        var enumValues = CourtType.values();
        var courtTypeStats = new int[enumValues.length];
        for (var judgment : judgements.values()) {
            courtTypeStats[judgment.getCourtType().ordinal()]++;
        }

        var result = "Liczba orzeczeń danego typu sądu\n";
        for (int i = 0; i < courtTypeStats.length; i++) {
            result += enumValues[i].toString() + ": " + courtTypeStats[i] + "\n";
        }
        return result;
    }
}

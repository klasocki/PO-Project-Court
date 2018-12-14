package pl.edu.agh.commands;

import pl.edu.agh.model.Judgement;

import java.util.HashMap;
import java.util.Map;

public class MonthStats {
    private Map<String, Judgement> judgements;

    public MonthStats(Map<String, Judgement> judgements) {
        this.judgements = judgements;
    }
    public String getStats() {
        var monthJudgementCount = new int[13];
        for (var judgement : judgements.values()) {
            monthJudgementCount[judgement.getJudgmentDate().getMonthValue()]++;
        }
        //building return string (without StringBuilder, cause its guaranteed to run 10 times)
        String result = "Liczba orzeczeń w poszczególnych miesiacach (z uwzględnieniem wszystkich lat) \n";
        for (int i = 1; i < 13; i++) {
            result += i + ": " + monthJudgementCount[i] + "\n";
        }
        return result;
    }
}

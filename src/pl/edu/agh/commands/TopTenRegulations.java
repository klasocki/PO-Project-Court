package pl.edu.agh.commands;

import pl.edu.agh.model.Judgement;

import java.util.HashMap;
import java.util.Map;

public class TopTenRegulations {
    private Map<String, Judgement> judgements;

    public TopTenRegulations(Map<String, Judgement> judgements) {
        this.judgements = judgements;
    }

    public String getTopTen() {
        var regulationsJudgementCount = new HashMap<String, Integer>();
        var mapUtils = new MapUtils<String, Integer>(); //helper object
        for (var judgement : judgements.values()) {
            for (var regulation : judgement.getReferencedRegulations()) {
                mapUtils.incrValue(regulationsJudgementCount, regulation.getJournalTitle());
            }
        }
        Map<String, Integer> sortedMap = mapUtils.getTopValues(regulationsJudgementCount, 10);
        //building return string (without StringBuilder, cause its guaranteed to run 10 times)
        String result = "";
        for (var entry : sortedMap.entrySet()) {
            result+=entry.getKey() + " - " + entry.getValue() +"\n";
        }
        return result;
    }
}

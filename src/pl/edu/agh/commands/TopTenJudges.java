package pl.edu.agh.commands;

import pl.edu.agh.model.Judgement;

import java.util.*;

import static java.util.Collections.reverseOrder;

public class TopTenJudges {
    private Map<String, Judgement> judgements;

    public TopTenJudges(Map<String, Judgement> judgements) {
        this.judgements = judgements;
    }

    public String getTopTen() {
        var judgesJudgementCount = new HashMap<String, Integer>();
        var mapUtils = new MapUtils<String, Integer>(); //helper object
        for (var judgement : judgements.values()) {
            for (var judge : judgement.getJudges()) {
                mapUtils.incrValue(judgesJudgementCount, judge.getName());
            }
        }
        Map<String, Integer> sortedMap = mapUtils.getTopValues(judgesJudgementCount, 10);
        //building return string (without StringBuilder, cause its guaranteed to run 10 times)
        String result = "";
        for (var entry : sortedMap.entrySet()) {
            result+=entry.getKey() + " - " + entry.getValue() +"\n";
        }
        return result;
    }

}

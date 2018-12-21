package pl.edu.agh.commands;

import pl.edu.agh.model.MapUtils;
import pl.edu.agh.model.Judgment;

import java.util.*;

public class TopTenJudges {
    private Map<String, Judgment> judgements;

    public TopTenJudges(Map<String, Judgment> judgements) {
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
        return "Sędziowie z największą liczbą wydanych orzeczeń\n" +
                mapUtils.topValuesToString(10, " - ", judgesJudgementCount);
    }

}

package pl.edu.agh.commands;

import pl.edu.agh.model.Judgement;
import pl.edu.agh.model.MapUtils;

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
        return mapUtils.getStringTopValues(judgesJudgementCount, 10);
    }

}

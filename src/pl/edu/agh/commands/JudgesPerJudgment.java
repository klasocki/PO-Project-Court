package pl.edu.agh.commands;

import pl.edu.agh.model.Judgement;
import pl.edu.agh.model.MapUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JudgesPerJudgment {
    private Map<String, Judgement> judgements;

    public JudgesPerJudgment(Map<String, Judgement> judgements) {
        this.judgements = judgements;
    }

    public String getStats() {
        var judgementsNumberForJudgesNumber =  new HashMap<Integer, Integer>();
        var mapUtils = new MapUtils<Integer, Integer>(); //helper object
        for (var judgment : judgements.values()) {
                mapUtils.incrValue(judgementsNumberForJudgesNumber, judgment.getJudges().size());
        }
        return "Liczba orzeczeń wydanych przez skład z określoną liczbą sędziów\n"
        + mapUtils.getStringTopValues(judgementsNumberForJudgesNumber, Integer.MAX_VALUE, ": ");
    }
}

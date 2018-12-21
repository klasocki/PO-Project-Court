package pl.edu.agh.commands;

import pl.edu.agh.model.MapUtils;
import pl.edu.agh.model.Judgment;


import java.util.Map;

public class JudgesPerJudgment {
    private Map<String, Judgment> judgments;

    public JudgesPerJudgment(Map<String, Judgment> judgments) {
        this.judgments = judgments;
    }

    public String getStats() {
        var mapUtils = new MapUtils<Integer, Integer>(); //helper object

        //Max value used to list "infinity" top values
        return "Liczba orzeczeń wydanych przez skład z określoną liczbą sędziów\n"
                + mapUtils.getStringTopValues(judgments, j -> j.getJudges().size(), Integer.MAX_VALUE, ": ");
    }
}

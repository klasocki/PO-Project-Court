package pl.edu.agh.commands;

import pl.edu.agh.model.MapUtils;
import pl.edu.agh.model.Judgment;

import java.util.HashMap;
import java.util.Map;

public class TopTenRegulations {
    private Map<String, Judgment> judgements;

    public TopTenRegulations(Map<String, Judgment> judgements) {
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

        return "Najczęściej przywoływane ustawy\n" +
                mapUtils.topValuesToString(10, " - ", regulationsJudgementCount);
    }
}

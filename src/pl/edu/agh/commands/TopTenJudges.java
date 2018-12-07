package pl.edu.agh.commands;

import pl.edu.agh.model.Judgement;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;

public class TopTenJudges {
    private Map<String, Judgement> judgements;

    public TopTenJudges(Map<String, Judgement> judgements) {
        this.judgements = judgements;
    }

    public String getTopTen() {
        var judges = new HashMap<String, Integer>();
        for (var judgement : judgements.values()) {
            for (var judge : judgement.getJudges()) {
                // This adds pair (name, 1) to the judges map is no entry is present,
                // otherwise increments the existing counter
                judges.merge(judge.getName(), 1, Integer::sum);
            }
        }
        //sorting map by number of judgments and taking first 10 values
        Map<String, Integer> sortedMap = judges.entrySet().stream().sorted(reverseOrder(Map.Entry.comparingByValue())).limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        //building return string (without StringBuilder, cause its guaranteed to run 10 times)
        String result = "";
        for (var entry : sortedMap.entrySet()) {
            result+=entry.getKey() + " - " + entry.getValue() +"\n";
        }
        return result;
    }

}

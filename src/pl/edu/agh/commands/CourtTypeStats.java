package pl.edu.agh.commands;

import pl.edu.agh.model.MapUtils;
import pl.edu.agh.model.Judgment;

import java.util.HashMap;
import java.util.Map;

public class CourtTypeStats {
    private Map<String, Judgment> judgments;

    public CourtTypeStats(Map<String, Judgment> judgments) {
        this.judgments = judgments;
    }

    public String getStats() {
        var mapUtils = new MapUtils<String, Integer>(); //helper object
        //Max value used to list "infinity" top values
        return  "Liczba orzeczeń danego typu sądu\n"
                + mapUtils.getStringTopValues(judgments, Judgment::getCourtType, Integer.MAX_VALUE, ": ");

    }
}

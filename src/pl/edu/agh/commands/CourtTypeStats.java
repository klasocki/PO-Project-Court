package pl.edu.agh.commands;

import pl.edu.agh.model.MapUtils;
import pl.edu.agh.model.Judgment;

import java.util.Map;

public class CourtTypeStats implements Command {
    private String [] args;
    private Map<String, Judgment> judgments;
    private String outputFilePath;
    private ExecutorNoArgs executor = new ExecutorNoArgs();

    CourtTypeStats(String[] args, Map<String, Judgment> judgments, String outputFilePath) {
        this.args = args;
        this.judgments = judgments;
        this.outputFilePath = outputFilePath;
    }

    String getStats() {
        var mapUtils = new MapUtils<String, Integer>(); //helper object
        //Max value used to list "infinity" top values
        return  "Liczba orzeczeń danego typu sądu\n"
                + mapUtils.getStringTopValues(judgments, Judgment::getCourtType, Integer.MAX_VALUE, ": ");

    }

    @Override
    public void execute(String line) {
        executor.execute(line, s -> getStats(), args, outputFilePath);
    }
}

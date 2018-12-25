package pl.edu.agh.commands;

import pl.edu.agh.model.MapUtils;
import pl.edu.agh.model.Judgment;


import java.util.Map;

public class JudgesPerJudgment implements Command {

    private String [] args;
    private Map<String, Judgment> judgments;
    private String outputFilePath;
    private ExecutorNoArgs executor = new ExecutorNoArgs();

    JudgesPerJudgment(String[] args, Map<String, Judgment> judgments, String outputFilePath) {
        this.args = args;
        this.judgments = judgments;
        this.outputFilePath = outputFilePath;
    }

    String getStats() {
        var mapUtils = new MapUtils<Integer, Integer>(); //helper object

        //Max value used to list "infinity" top values
        return "Liczba orzeczeń wydanych przez skład z określoną liczbą sędziów\n"
                + mapUtils.getStringTopValues(judgments, j -> j.getJudges().size(), Integer.MAX_VALUE, ": ");
    }

    @Override
    public void execute(String line) {
        executor.execute(line, s -> getStats(), args, outputFilePath);
    }
}

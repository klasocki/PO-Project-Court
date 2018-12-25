package pl.edu.agh.commands;

import pl.edu.agh.model.MapUtils;
import pl.edu.agh.model.Judgment;

import java.util.*;

public class TopTenJudges implements Command {

    private String [] args;
    private Map<String, Judgment> judgements;
    private String outputFilePath;
    private ExecutorNoArgs executor = new ExecutorNoArgs();

    TopTenJudges(String[] args, Map<String, Judgment> judgements, String outputFilePath) {
        this.args = args;
        this.judgements = judgements;
        this.outputFilePath = outputFilePath;
    }

    String getTopTen() {
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

    @Override
    public void execute(String line) {
        executor.execute(line, s -> getTopTen(), args, outputFilePath);
    }

}

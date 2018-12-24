package pl.edu.agh.commands;

import pl.edu.agh.console.FileUtils;
import pl.edu.agh.model.MapUtils;
import pl.edu.agh.model.Judgment;

import java.io.IOException;
import java.util.*;

public class TopTenJudges implements Command {

    private String [] args;
    private Map<String, Judgment> judgements;
    private String outputFilePath;

    public TopTenJudges(String[] args, Map<String, Judgment> judgements, String outputFilePath) {
        this.args = args;
        this.judgements = judgements;
        this.outputFilePath = outputFilePath;
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

    @Override
    public void execute(String line) {
        if (args.length != 0) {
            System.out.println(CommandList.expectsNoArguments());
        } else {
            var result = getTopTen();
            try {
                FileUtils.writeToFile(outputFilePath, "\n" + line + "\n" + result);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(result);
        }
    }

}

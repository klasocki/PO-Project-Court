package pl.edu.agh.commands;

import pl.edu.agh.console.FileUtils;
import pl.edu.agh.model.Judgment;

import java.io.IOException;
import java.util.Map;

public class MonthStats implements Command{

    private String [] args;
    private Map<String, Judgment> judgements;
    private String outputFilePath;

    public MonthStats(String[] args, Map<String, Judgment> judgements, String outputFilePath) {
        this.args = args;
        this.judgements = judgements;
        this.outputFilePath = outputFilePath;
    }

    public String getStats() {
        var monthJudgementCount = new int[13];
        for (var judgement : judgements.values()) {
            monthJudgementCount[judgement.getJudgmentDate().getMonthValue()]++;
        }
        //building return string (without StringBuilder, cause its guaranteed to run 10 times)
        String result = "Liczba orzeczeń w poszczególnych miesiacach (z uwzględnieniem wszystkich lat) \n";
        for (int i = 1; i < 13; i++) {
            result += i + ": " + monthJudgementCount[i] + "\n";
        }
        return result;
    }

    @Override
    public void execute() {
        if (args.length != 0) {
            System.out.println(CommandList.expectsNoArguments());
        } else {
            var result = getStats();
            try {
                FileUtils.writeToFile(outputFilePath,"months\n" + result);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(result);
        }
    }
}

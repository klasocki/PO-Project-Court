package pl.edu.agh.commands;

import pl.edu.agh.model.Judgment;

import java.util.Map;

public class MonthStats implements Command{

    private String [] args;
    private Map<String, Judgment> judgements;
    private String outputFilePath;
    private ExecutorNoArgs executor = new ExecutorNoArgs();

    MonthStats(String[] args, Map<String, Judgment> judgements, String outputFilePath) {
        this.args = args;
        this.judgements = judgements;
        this.outputFilePath = outputFilePath;
    }

    String getStats() {
        var monthJudgementCount = new int[13];
        for (var judgement : judgements.values()) {
            monthJudgementCount[judgement.getJudgmentDate().getMonthValue()]++;
        }
        StringBuilder result = new StringBuilder(
                "Liczba orzeczeń w poszczególnych miesiacach (z uwzględnieniem wszystkich lat) \n");
        for (int i = 1; i < 13; i++) {
            result.append(i).append(": ").append(monthJudgementCount[i]).append("\n");
        }
        return result.toString();
    }

    @Override
    public void execute(String line) {
        executor.execute(line, s -> getStats(), args, outputFilePath);
    }
}

package pl.edu.agh.commands;

import pl.edu.agh.model.MapUtils;
import pl.edu.agh.model.Judgment;

import java.util.HashMap;
import java.util.Map;

public class TopTenRegulations implements Command {
    private String [] args;
    private Map<String, Judgment> judgements;
    private String outputFilePath;
    private ExecutorNoArgs executor = new ExecutorNoArgs();

    TopTenRegulations(String[] args, Map<String, Judgment> judgements, String outputFilePath) {
        this.args = args;
        this.judgements = judgements;
        this.outputFilePath = outputFilePath;
    }

    String getTopTen() {
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

    @Override
    public void execute(String line) {
        executor.execute(line, s -> getTopTen(), args, outputFilePath);
    }
}

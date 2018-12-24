package pl.edu.agh.commands;

import pl.edu.agh.console.FileUtils;
import pl.edu.agh.model.MapUtils;
import pl.edu.agh.model.Judgment;


import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JudgesPerJudgment implements Command {

    private String [] args;
    private Map<String, Judgment> judgments;
    private String outputFilePath;

    public JudgesPerJudgment(String[] args, Map<String, Judgment> judgments, String outputFilePath) {
        this.args = args;
        this.judgments = judgments;
        this.outputFilePath = outputFilePath;
    }

    public String getStats() {
        var mapUtils = new MapUtils<Integer, Integer>(); //helper object

        //Max value used to list "infinity" top values
        return "Liczba orzeczeń wydanych przez skład z określoną liczbą sędziów\n"
                + mapUtils.getStringTopValues(judgments, j -> j.getJudges().size(), Integer.MAX_VALUE, ": ");
    }

    @Override
    public void execute(String line) {
        if (args.length != 0) {
            System.out.println(CommandList.expectsNoArguments());
        } else {
            var result = getStats();
            try {
                FileUtils.writeToFile(outputFilePath, "\n" + line + "\n" + result);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(result);
        }
    }
}

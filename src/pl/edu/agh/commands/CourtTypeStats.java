package pl.edu.agh.commands;

import pl.edu.agh.console.FileUtils;
import pl.edu.agh.model.MapUtils;
import pl.edu.agh.model.Judgment;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CourtTypeStats implements Command {
    private String [] args;
    private Map<String, Judgment> judgments;
    private String outputFilePath;

    public CourtTypeStats(String[] args, Map<String, Judgment> judgments, String outputFilePath) {
        this.args = args;
        this.judgments = judgments;
        this.outputFilePath = outputFilePath;
    }

    public String getStats() {
        var mapUtils = new MapUtils<String, Integer>(); //helper object
        //Max value used to list "infinity" top values
        return  "Liczba orzeczeń danego typu sądu\n"
                + mapUtils.getStringTopValues(judgments, Judgment::getCourtType, Integer.MAX_VALUE, ": ");

    }

    @Override
    public void execute() {
        if(args.length != 0) {
            System.out.println(CommandList.expectsNoArguments());
        }
        else {
            String result = getStats();
            try {
                FileUtils.writeToFile(outputFilePath, "courts\n" + result);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(result);

        }
    }
}

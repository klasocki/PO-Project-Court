package pl.edu.agh.commands;

import pl.edu.agh.console.FileUtils;
import pl.edu.agh.model.Judgment;

import java.io.IOException;
import java.util.Map;

public class JudgeNoOfJudgments implements Command{
    private String [] args;
    private Map<String, Judgment> judgments;
    private String outputFilePath;

    public JudgeNoOfJudgments(String[] args, Map<String, Judgment> judgments, String outputFilePath) {
        this.args = args;
        this.judgments = judgments;
        this.outputFilePath = outputFilePath;
    }

    public int getNumber(String name) {
        int number = 0;
        for (var judgment : judgments.values())
            for (var judge : judgment.getJudges())
                if (judge.getName().equals(name)) number++;
    return number;
    }

    @Override
    public void execute(String line) {
        if (args.length != 1) {
            System.out.println(CommandList.expectsOneArgument());
        } else {
            var result = Integer.valueOf(getNumber(args[0])).toString();
            try {
                FileUtils.writeToFile(outputFilePath, "\n" + line + "\n" + result);

            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(result);
        }
    }
}

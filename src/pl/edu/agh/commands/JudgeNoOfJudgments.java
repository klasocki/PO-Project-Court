package pl.edu.agh.commands;

import pl.edu.agh.model.Judgment;

import java.util.Map;

public class JudgeNoOfJudgments implements Command {
    private String[] args;
    private Map<String, Judgment> judgments;
    private String outputFilePath;
    private ExecutorOneArg executor = new ExecutorOneArg();

    JudgeNoOfJudgments(String[] args, Map<String, Judgment> judgments, String outputFilePath) {
        this.args = args;
        this.judgments = judgments;
        this.outputFilePath = outputFilePath;
    }

    int getNumber(String name) {
        int number = 0;
        for (var judgment : judgments.values())
            for (var judge : judgment.getJudges())
                if (judge.getName().equals(name)) number++;
        if (0 == number) {
            throw new IllegalArgumentException("Sędzia " + name +
                    " nie wydał żadnego orzeczenia przechowywanego w podanych plikach");
        }
        return number;
    }

    @Override
    public void execute(String line) {
        executor.execute(line, s -> Integer.valueOf(getNumber(s)).toString(), args, outputFilePath);
    }
}

package pl.edu.agh.commands;

import java.util.function.Function;

public class ExecutorMultipleArgs implements Executor<String[]>{

    public void execute(String line, Function<String[], String> getResult, String[] args, String outputFilePath) {
        if (args.length < 1) {
            System.out.println(CommandList.expectsOneOrMoreArguments());
        } else {
            try {
                String result = getResult.apply(args);
                printResult(line, outputFilePath, result);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}

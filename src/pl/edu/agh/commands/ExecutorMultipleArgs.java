package pl.edu.agh.commands;

import java.util.function.Function;

public class ExecutorMultipleArgs implements Executor<String[]>{

    public void execute(String line, Function<String[], String> getResult,
                        String[] args, String outputFilePath) throws IllegalArgumentException {
        if (args.length < 1) {
            throw new IllegalArgumentException(CommandList.expectsOneOrMoreArguments());
        } else {
            String result = getResult.apply(args);
            printAndSaveResult(line, outputFilePath, result);
        }
    }


}

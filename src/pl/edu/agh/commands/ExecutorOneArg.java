package pl.edu.agh.commands;

import java.util.function.Function;

public class ExecutorOneArg implements Executor<String> {
    @Override
    public void execute(String line, Function<String, String> getResult, String[] args,
                        String outputFilePath) throws IllegalArgumentException {
        if (args.length != 1) {
            throw new IllegalArgumentException(CommandList.expectsOneArgument());
        } else {
            String result = getResult.apply(args[0]);
            printAndSaveResult(line, outputFilePath, result);
        }
    }
}

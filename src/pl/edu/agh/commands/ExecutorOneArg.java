package pl.edu.agh.commands;

import java.util.function.Function;

public class ExecutorOneArg implements Executor<String> {
    @Override
    public void execute(String line, Function<String, String> getResult, String[] args, String outputFilePath) {
        if (args.length != 1) {
            System.out.println(CommandList.expectsOneArgument());
        } else {
            try {
                String result = getResult.apply(args[0]);
                printResult(line, outputFilePath, result);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

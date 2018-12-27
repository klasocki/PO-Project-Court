package pl.edu.agh.commands;

import java.util.function.Function;

public class ExecutorNoArgs implements Executor<String>{
    public void execute(String line, Function<String, String> getResult, String[] args,
                        String outputFilePath) throws IllegalArgumentException{
        if(args.length != 0) {
            throw new IllegalArgumentException(CommandList.expectsNoArguments());
        }
        else {
            //getResult here is a function that ignores it's first argument
            //it's ugly but you cannot pass no argument function in java from what i know
            String result = getResult.apply("");
            printAndSaveResult(line, outputFilePath, result);
        }
    }
}

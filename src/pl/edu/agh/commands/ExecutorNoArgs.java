package pl.edu.agh.commands;

import java.util.function.Function;

public class ExecutorNoArgs implements Executor<String>{
    public void execute(String line, Function<String, String> getResult, String[] args, String outputFilePath){
        if(args.length != 0) {
            System.out.println(CommandList.expectsNoArguments());
        }
        else {
            String result = getResult.apply("");
            printResult(line, outputFilePath, result);
        }
    }

}

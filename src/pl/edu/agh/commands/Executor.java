package pl.edu.agh.commands;

import pl.edu.agh.console.FileUtils;

import java.io.IOException;
import java.util.function.Function;

public interface Executor<T> {
    void execute(String line, Function<T,String> getResult, String[] args, String outputFilePath)
            throws IllegalArgumentException;

    default void printAndSaveResult(String line, String outputFilePath, String result) {
        try {
            FileUtils.writeToFile(outputFilePath, "\n" + line + "\n" + result + "\n");
        } catch (IOException e) {
            System.out.println("Wystąpił nieoczekiwany problem z zapisem do pliku "
                    + outputFilePath + ", prawdpodobnie został usunięty lub uszkodzony " +
                    "w trakcie działania programu");
        }
        System.out.println(result);
    }
}

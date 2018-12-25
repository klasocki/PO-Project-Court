package pl.edu.agh.commands;

import pl.edu.agh.console.Arguments;
import pl.edu.agh.dataExtraction.JudgmentReader;
import pl.edu.agh.model.Judgment;

import java.io.IOException;
import java.util.Map;

public class CommandList {
    private Map<String, Judgment> judgments;
    private String outputFilePath;

    public CommandList(Map<String, Judgment> judgments, String outputFilePath) {
        this.judgments = judgments;
        this.outputFilePath = outputFilePath;
    }

    public static CommandList getCommandList(Arguments arguments) throws IOException, IllegalArgumentException {
        Map<String, Judgment> judgments = JudgmentReader.getJudgments(arguments);
        return new CommandList(judgments, arguments.outputFile);
    }

    public String[] getCommandList() {
        return new String[]{
                "rubrum",
                "content",
                "judge",
                "judges",
                "months",
                "courts",
                "regulations",
                "jury"
        };
    }

    public String helpMessage() {
        return  "rubrum      - zwraca metrykę jednego lub więcej orzeczeń o sygnaturach podanych jako parametr\n" +
                "content     - zwraca uzasadnienie orzeczenia o podanej sygnaturze\n" +
                "judge       - zwraca liczbę orzeczeń dla podanego imienia i nazwiska sędziego\n" +
                "judges      - zwraca 10 sędziów o największej liczbie orzeczeń\n" +
                "months      - zwraca rozkład statytstyczny orzeczeń ze względu na miesiąc\n" +
                "courts      - rozkład statystyczcny wyroków ze względu na typ sądu\n" +
                "regulations - 10 najczęściej przywoływanych ustaw\n" +
                "jury        - rozkład statystyczny wyroków ze względu na liczbę sędziów w składzie";
    }

    public Command parseCommand(String command, String[] args) {
        switch (command) {
            case "rubrum":
                return new Rubrum(args, judgments, outputFilePath);
            case "content":
                return new TextContent(args, judgments, outputFilePath);
            case "judge":
                return new JudgeNoOfJudgments(args, judgments, outputFilePath);
            case "judges":
                return new TopTenJudges(args, judgments, outputFilePath);
            case "months":
                return new MonthStats(args, judgments, outputFilePath);
            case "courts":
                return new CourtTypeStats(args, judgments, outputFilePath);
            case "regulations":
                return new TopTenRegulations(args, judgments, outputFilePath);
            case "jury":
                return new JudgesPerJudgment(args, judgments, outputFilePath);
        }
        return new CommandNotFound();
    }

    static String expectsNoArguments() {
        return "Podano zbyt dużo argumentów, komenda nie wymaga żadnego";
    }
    static String expectsOneOrMoreArguments() {
        return "Nie podano argumentów, wymagany jeden lub więcej, zawarte pomiędzy znakami \"";
    }
    static String expectsOneArgument() {
        return "Podano złą liczbę argumentów, komenda wymaga dokładnie jednego, zawartego pomiędzy znakami \"";
    }

}

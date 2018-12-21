package pl.edu.agh.commands;

import pl.edu.agh.model.Judgment;

import java.util.Map;

public class JudgeNoOfJudgments {
    private Map<String, Judgment> judgements;

    public JudgeNoOfJudgments(Map<String, Judgment> judgements) {
        this.judgements = judgements;
    }

    public int getNumber(String name) {
        int number = 0;
        for (var judgement : judgements.values())
            for (var judge : judgement.getJudges())
                if (judge.getName().equals(name)) number++;
    return number;
    }
}

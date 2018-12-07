package pl.edu.agh.commands;

import pl.edu.agh.model.Judgement;

import java.util.Map;

public class JudgeNoOfJudgments {
    private Map<String, Judgement> judgements;

    public JudgeNoOfJudgments(Map<String, Judgement> judgements) {
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

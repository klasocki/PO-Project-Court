package pl.edu.agh.commands;

import pl.edu.agh.model.Judgement;

import java.util.Map;

public class TextContent {
    private Map<String, Judgement> judgements;

    public TextContent(Map<String, Judgement> judgements) {
        this.judgements = judgements;
    }

    public String getTC(String key) {
        var judgement = judgements.get(key);
        if (judgement == null) {
                    throw new IllegalArgumentException("Nie znaleziono orzeczenia o sygnaturze " + key);
        }
        return judgement.getTextContent();
    }
}

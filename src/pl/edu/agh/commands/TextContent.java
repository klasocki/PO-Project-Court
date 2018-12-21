package pl.edu.agh.commands;


import pl.edu.agh.model.Judgment;

import java.util.Map;

public class TextContent {
    private Map<String, Judgment> judgements;

    public TextContent(Map<String, Judgment> judgements) {
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

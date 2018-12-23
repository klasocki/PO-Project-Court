package pl.edu.agh.model.HTML;

import pl.edu.agh.model.ReferencedRegulation;

public class ReferencedRegulationHTML implements ReferencedRegulation {
    private String title;
    private ReferencedRegulationHTML(String title) {
        this.title = title;
    }
    @Override
    public String getJournalTitle() {
        //regex for testing most possible variants of " - tekst jednolity"
        return title.split("(\\s*-\\s*)(?i)(t((ekst)|.?) ?j((ed)|\\.))")[0];
    }

    public static ReferencedRegulation stringToRegulation(String t) {
        return new ReferencedRegulationHTML(t);
    }
}

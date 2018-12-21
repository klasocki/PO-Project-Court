package pl.edu.agh.model;

import pl.edu.agh.model.JSON.JudgeJSON;
import pl.edu.agh.model.JSON.ReferencedRegulationJSON;

import java.time.LocalDate;
import java.util.List;

public interface Judgment {
    String getKey();
    List<Judge> getJudges();
    String getCourtType();
    String getTextContent();
    List<ReferencedRegulation> getReferencedRegulations();
    LocalDate getJudgmentDate();
}

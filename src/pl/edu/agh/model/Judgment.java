package pl.edu.agh.model;

import pl.edu.agh.model.JSON.CourtCase;
import pl.edu.agh.model.JSON.Judge;
import pl.edu.agh.model.JSON.ReferencedRegulation;

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

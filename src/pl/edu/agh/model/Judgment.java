package pl.edu.agh.model;

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

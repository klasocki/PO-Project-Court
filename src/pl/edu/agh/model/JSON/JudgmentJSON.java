package pl.edu.agh.model.JSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.jsoup.Jsoup;
import pl.edu.agh.model.Judge;
import pl.edu.agh.model.Judgment;
import pl.edu.agh.model.ReferencedRegulation;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JudgmentJSON implements Serializable, Judgment {

    @SerializedName("courtType")
    @Expose
    private CourtType courtType;
    @SerializedName("courtCases")
    @Expose
    private List<CourtCase> courtCases = new ArrayList<CourtCase>();
    @SerializedName("judges")
    @Expose
    private List<JudgeJSON> judges = new ArrayList<>();
    @SerializedName("textContent")
    @Expose
    private String textContent;
    @SerializedName("referencedRegulations")
    @Expose
    private List<ReferencedRegulationJSON> referencedRegulations = new ArrayList<>();
    @SerializedName("judgmentDate")
    @Expose
    private String judgmentDate;

    private final static long serialVersionUID = -4567588184386180485L;
    /**
     * No args constructor for use in serialization
     */
    public JudgmentJSON() {
    }

    public String getKey() {
        return courtCases.get(0).getCaseNumber();
    }

    public String getCourtType() {
        return courtType.toString();
    }

    public List<Judge> getJudges() {
        return Collections.unmodifiableList(judges);
    }

    public String getTextContent() {
        return Jsoup.parse(textContent).text();
    }

    public List<ReferencedRegulation> getReferencedRegulations() {
        return Collections.unmodifiableList(referencedRegulations);
    }
    public LocalDate getJudgmentDate() {
        return LocalDate.parse(this.judgmentDate);
    }

}
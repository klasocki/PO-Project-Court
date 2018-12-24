package pl.edu.agh.model.JSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import pl.edu.agh.model.Judge;
import pl.edu.agh.model.Judgment;
import pl.edu.agh.model.ReferencedRegulation;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JudgmentJSON implements Serializable, Judgment
{

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("courtType")
    @Expose
    private CourtType courtType;
    @SerializedName("courtCases")
    @Expose
    private List<CourtCase> courtCases = new ArrayList<CourtCase>();
    @SerializedName("judgmentType")
    @Expose
    private JudgmentType judgmentType;
    @SerializedName("judges")
    @Expose
    private List<JudgeJSON> judges = new ArrayList<>();
    @SerializedName("source")
    @Expose
    private Source source;
    @SerializedName("courtReporters")
    @Expose
    private List<String> courtReporters = new ArrayList<String>();
    @SerializedName("decision")
    @Expose
    private String decision;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("textContent")
    @Expose
    private String textContent;
    @SerializedName("legalBases")
    @Expose
    private List<String> legalBases = new ArrayList<String>();
    @SerializedName("referencedRegulations")
    @Expose
    private List<ReferencedRegulationJSON> referencedRegulations = new ArrayList<>();
    @SerializedName("keywords")
    @Expose
    private List<String> keywords = new ArrayList<String>();
    @SerializedName("referencedCourtCases")
    @Expose
    private List<ReferencedCourtCase> referencedCourtCases = new ArrayList<ReferencedCourtCase>();
    @SerializedName("receiptDate")
    @Expose
    private String receiptDate;
    @SerializedName("meansOfAppeal")
    @Expose
    private String meansOfAppeal;
    @SerializedName("judgmentResult")
    @Expose
    private String judgmentResult;
    @SerializedName("lowerCourtJudgments")
    @Expose
    private List<String> lowerCourtJudgments = new ArrayList<String>();
    @SerializedName("dissentingOpinions")
    @Expose
    private List<DissentingOpinion> dissentingOpinions = new ArrayList<DissentingOpinion>();
    @SerializedName("judgmentDate")
    @Expose
    private String judgmentDate;
    private final static long serialVersionUID = -4567588184386180485L;

    /**
     * No args constructor for use in serialization
     *
     */
    public JudgmentJSON() {
    }

    public String getKey() {
        return courtCases.get(0).getCaseNumber();
    }

    public int getId() {
        return id;
    }

    public String getCourtType() {
        return courtType.toString();
    }

    public List<Judge> getJudges() {
        return Collections.unmodifiableList(judges);
    }

    public String getDecision() {
        return decision;
    }

    public String getSummary() {
        return summary;
    }

    public String getTextContent() {
        return textContent;
    }

    public List<ReferencedRegulation> getReferencedRegulations() {
        return Collections.unmodifiableList(referencedRegulations);
    }

    public String getMeansOfAppeal() {
        return meansOfAppeal;
    }

    public String getJudgmentResult() {
        return judgmentResult;
    }

    public LocalDate getJudgmentDate(){
        return LocalDate.parse(this.judgmentDate);
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("courtType", courtType).append("courtCases", courtCases).append("judgmentType", judgmentType).append("judges", judges).append("source", source).append("courtReporters", courtReporters).append("decision", decision).append("summary", summary).append("textContent", textContent).append("legalBases", legalBases).append("referencedRegulations", referencedRegulations).append("keywords", keywords).append("referencedCourtCases", referencedCourtCases).append("receiptDate", receiptDate).append("meansOfAppeal", meansOfAppeal).append("judgmentResult", judgmentResult).append("lowerCourtJudgments", lowerCourtJudgments).append("dissentingOpinions", dissentingOpinions).append("judgmentDate", judgmentDate).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(summary).append(keywords).append(textContent).append(meansOfAppeal).append(judges).append(courtType).append(legalBases).append(judgmentDate).append(dissentingOpinions).append(lowerCourtJudgments).append(decision).append(referencedCourtCases).append(id).append(receiptDate).append(courtReporters).append(judgmentType).append(source).append(courtCases).append(judgmentResult).append(referencedRegulations).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof JudgmentJSON)) {
            return false;
        }
        JudgmentJSON rhs = ((JudgmentJSON) other);
        return new EqualsBuilder().append(summary, rhs.summary).append(keywords, rhs.keywords).append(textContent, rhs.textContent).append(meansOfAppeal, rhs.meansOfAppeal).append(judges, rhs.judges).append(courtType, rhs.courtType).append(legalBases, rhs.legalBases).append(judgmentDate, rhs.judgmentDate).append(dissentingOpinions, rhs.dissentingOpinions).append(lowerCourtJudgments, rhs.lowerCourtJudgments).append(decision, rhs.decision).append(referencedCourtCases, rhs.referencedCourtCases).append(id, rhs.id).append(receiptDate, rhs.receiptDate).append(courtReporters, rhs.courtReporters).append(judgmentType, rhs.judgmentType).append(source, rhs.source).append(courtCases, rhs.courtCases).append(judgmentResult, rhs.judgmentResult).append(referencedRegulations, rhs.referencedRegulations).isEquals();
    }

}
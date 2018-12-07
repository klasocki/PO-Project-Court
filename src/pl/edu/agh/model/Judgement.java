// TODO date format should be checked while instantiating

package pl.edu.agh.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Judgement implements Serializable
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
    private JudgementType judgmentType;
    @SerializedName("judges")
    @Expose
    private List<Judge> judges = new ArrayList<Judge>();
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
    private List<ReferencedRegulation> referencedRegulations = new ArrayList<ReferencedRegulation>();
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
    public Judgement() {
    }

    /**
     *
     * @param summary
     * @param keywords
     * @param textContent
     * @param meansOfAppeal
     * @param judges
     * @param courtType
     * @param legalBases
     * @param judgmentDate
     * @param dissentingOpinions
     * @param lowerCourtJudgments
     * @param decision
     * @param referencedCourtCases
     * @param id
     * @param receiptDate
     * @param judgmentType
     * @param courtReporters
     * @param source
     * @param courtCases
     * @param judgmentResult
     * @param referencedRegulations
     */
    public Judgement(int id, String courtType, List<CourtCase> courtCases, String judgmentType, List<Judge> judges, Source source, List<String> courtReporters, String decision, String summary, String textContent, List<String> legalBases, List<ReferencedRegulation> referencedRegulations, List<String> keywords, List<ReferencedCourtCase> referencedCourtCases, String receiptDate, String meansOfAppeal, String judgmentResult, List<String> lowerCourtJudgments, List<DissentingOpinion> dissentingOpinions, String judgmentDate) {
        super();
        this.id = id;
        this.courtType = CourtType.valueOf(courtType);
        this.courtCases = courtCases;
        this.judgmentType = JudgementType.valueOf(judgmentType);
        this.judges = judges;
        this.source = source;
        this.courtReporters = courtReporters;
        this.decision = decision;
        this.summary = summary;
        this.textContent = textContent;
        this.legalBases = legalBases;
        this.referencedRegulations = referencedRegulations;
        this.keywords = keywords;
        this.referencedCourtCases = referencedCourtCases;
        this.receiptDate = receiptDate;
        this.meansOfAppeal = meansOfAppeal;
        this.judgmentResult = judgmentResult;
        this.lowerCourtJudgments = lowerCourtJudgments;
        this.dissentingOpinions = dissentingOpinions;
        this.judgmentDate = judgmentDate;
    }

    public String getKey() {
        return courtCases.get(0).getCaseNumber();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CourtType getCourtType() {
        return courtType;
    }

    public void setCourtType(String courtType) {
        this.courtType = CourtType.valueOf(courtType);
    }

    public List<CourtCase> getCourtCases() {
        return courtCases;
    }

    public void setCourtCases(List<CourtCase> courtCases) {
        this.courtCases = courtCases;
    }

    public JudgementType getJudgmentType() {
        return judgmentType;
    }

    public void setJudgmentType(String judgmentType) {
        this.judgmentType = JudgementType.valueOf(judgmentType);
    }

    public List<Judge> getJudges() {
        return judges;
    }

    public void setJudges(List<Judge> judges) {
        this.judges = judges;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public List<String> getCourtReporters() {
        return courtReporters;
    }

    public void setCourtReporters(List<String> courtReporters) {
        this.courtReporters = courtReporters;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public List<String> getLegalBases() {
        return legalBases;
    }

    public void setLegalBases(List<String> legalBases) {
        this.legalBases = legalBases;
    }

    public List<ReferencedRegulation> getReferencedRegulations() {
        return referencedRegulations;
    }

    public void setReferencedRegulations(List<ReferencedRegulation> referencedRegulations) {
        this.referencedRegulations = referencedRegulations;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<ReferencedCourtCase> getReferencedCourtCases() {
        return referencedCourtCases;
    }

    public void setReferencedCourtCases(List<ReferencedCourtCase> referencedCourtCases) {
        this.referencedCourtCases = referencedCourtCases;
    }

    public LocalDate getReceiptDate() {
        return LocalDate.parse(receiptDate);
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getMeansOfAppeal() {
        return meansOfAppeal;
    }

    public void setMeansOfAppeal(String meansOfAppeal) {
        this.meansOfAppeal = meansOfAppeal;
    }

    public String getJudgmentResult() {
        return judgmentResult;
    }

    public void setJudgmentResult(String judgmentResult) {
        this.judgmentResult = judgmentResult;
    }

    public List<String> getLowerCourtJudgments() {
        return lowerCourtJudgments;
    }

    public void setLowerCourtJudgments(List<String> lowerCourtJudgments) {
        this.lowerCourtJudgments = lowerCourtJudgments;
    }

    public List<DissentingOpinion> getDissentingOpinions() {
        return dissentingOpinions;
    }

    public void setDissentingOpinions(List<DissentingOpinion> dissentingOpinions) {
        this.dissentingOpinions = dissentingOpinions;
    }

    public LocalDate getJudgmentDate(){
        return LocalDate.parse(this.judgmentDate);
    }

    public void setJudgmentDate(String judgmentDate) {
        this.judgmentDate = judgmentDate;
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
        if (!(other instanceof Judgement)) {
            return false;
        }
        Judgement rhs = ((Judgement) other);
        return new EqualsBuilder().append(summary, rhs.summary).append(keywords, rhs.keywords).append(textContent, rhs.textContent).append(meansOfAppeal, rhs.meansOfAppeal).append(judges, rhs.judges).append(courtType, rhs.courtType).append(legalBases, rhs.legalBases).append(judgmentDate, rhs.judgmentDate).append(dissentingOpinions, rhs.dissentingOpinions).append(lowerCourtJudgments, rhs.lowerCourtJudgments).append(decision, rhs.decision).append(referencedCourtCases, rhs.referencedCourtCases).append(id, rhs.id).append(receiptDate, rhs.receiptDate).append(courtReporters, rhs.courtReporters).append(judgmentType, rhs.judgmentType).append(source, rhs.source).append(courtCases, rhs.courtCases).append(judgmentResult, rhs.judgmentResult).append(referencedRegulations, rhs.referencedRegulations).isEquals();
    }

}
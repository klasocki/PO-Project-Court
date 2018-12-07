
package pl.edu.agh.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class ReferencedRegulation implements Serializable
{

    @SerializedName("journalTitle")
    @Expose
    private String journalTitle;
    @SerializedName("journalNo")
    @Expose
    private int journalNo;
    @SerializedName("journalYear")
    @Expose
    private int journalYear;
    @SerializedName("journalEntry")
    @Expose
    private int journalEntry;
    @SerializedName("text")
    @Expose
    private String text;
    private final static long serialVersionUID = -9188532900197882989L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ReferencedRegulation() {
    }

    /**
     * 
     * @param text
     * @param journalNo
     * @param journalEntry
     * @param journalTitle
     * @param journalYear
     */
    public ReferencedRegulation(String journalTitle, int journalNo, int journalYear, int journalEntry, String text) {
        super();
        this.journalTitle = journalTitle;
        this.journalNo = journalNo;
        this.journalYear = journalYear;
        this.journalEntry = journalEntry;
        this.text = text;
    }

    public String getJournalTitle() {
        return journalTitle;
    }

    public void setJournalTitle(String journalTitle) {
        this.journalTitle = journalTitle;
    }

    public int getJournalNo() {
        return journalNo;
    }

    public void setJournalNo(int journalNo) {
        this.journalNo = journalNo;
    }

    public int getJournalYear() {
        return journalYear;
    }

    public void setJournalYear(int journalYear) {
        this.journalYear = journalYear;
    }

    public int getJournalEntry() {
        return journalEntry;
    }

    public void setJournalEntry(int journalEntry) {
        this.journalEntry = journalEntry;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("journalTitle", journalTitle).append("journalNo", journalNo).append("journalYear", journalYear).append("journalEntry", journalEntry).append("text", text).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(text).append(journalNo).append(journalEntry).append(journalTitle).append(journalYear).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ReferencedRegulation) == false) {
            return false;
        }
        ReferencedRegulation rhs = ((ReferencedRegulation) other);
        return new EqualsBuilder().append(text, rhs.text).append(journalNo, rhs.journalNo).append(journalEntry, rhs.journalEntry).append(journalTitle, rhs.journalTitle).append(journalYear, rhs.journalYear).isEquals();
    }

}

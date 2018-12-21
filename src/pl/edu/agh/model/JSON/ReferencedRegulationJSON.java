
package pl.edu.agh.model.JSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import pl.edu.agh.model.ReferencedRegulation;

import java.io.Serializable;

public class ReferencedRegulationJSON implements Serializable, ReferencedRegulation
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
    public ReferencedRegulationJSON() {
    }

    public String getJournalTitle() {
        return journalTitle;
    }

    public int getJournalNo() {
        return journalNo;
    }

    public int getJournalYear() {
        return journalYear;
    }

    public int getJournalEntry() {
        return journalEntry;
    }

    public String getText() {
        return text;
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
        if (!(other instanceof ReferencedRegulationJSON)) {
            return false;
        }
        var rhs = ((ReferencedRegulationJSON) other);
        return new EqualsBuilder().append(text, rhs.text).append(journalNo, rhs.journalNo).append(journalEntry, rhs.journalEntry).append(journalTitle, rhs.journalTitle).append(journalYear, rhs.journalYear).isEquals();
    }

}

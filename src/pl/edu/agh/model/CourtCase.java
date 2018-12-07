
package pl.edu.agh.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class CourtCase implements Serializable
{

    @SerializedName("caseNumber")
    @Expose
    private String caseNumber;
    private final static long serialVersionUID = 6173036093291686720L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CourtCase() {
    }

    /**
     * 
     * @param caseNumber
     */
    public CourtCase(String caseNumber) {
        super();
        this.caseNumber = caseNumber;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("caseNumber", caseNumber).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(caseNumber).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CourtCase) == false) {
            return false;
        }
        CourtCase rhs = ((CourtCase) other);
        return new EqualsBuilder().append(caseNumber, rhs.caseNumber).isEquals();
    }

}

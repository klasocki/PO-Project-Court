
package pl.edu.agh.model.JSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReferencedCourtCase implements Serializable
{

    @SerializedName("caseNumber")
    @Expose
    private String caseNumber;
    @SerializedName("judgementsIds")
    @Expose
    private List<String> judgementsIds = new ArrayList<String>();
    @SerializedName("generated")
    @Expose
    private boolean generated;
    private final static long serialVersionUID = 8679050774030862367L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ReferencedCourtCase() {
    }

    /**
     * 
     * @param generated
     * @param judgementsIds
     * @param caseNumber
     */
    public ReferencedCourtCase(String caseNumber, List<String> judgementsIds, boolean generated) {
        super();
        this.caseNumber = caseNumber;
        this.judgementsIds = judgementsIds;
        this.generated = generated;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public List<String> getJudgementsIds() {
        return judgementsIds;
    }

    public void setJudgementsIds(List<String> judgementsIds) {
        this.judgementsIds = judgementsIds;
    }

    public boolean isGenerated() {
        return generated;
    }

    public void setGenerated(boolean generated) {
        this.generated = generated;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("caseNumber", caseNumber).append("judgementsIds", judgementsIds).append("generated", generated).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(generated).append(judgementsIds).append(caseNumber).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ReferencedCourtCase) == false) {
            return false;
        }
        ReferencedCourtCase rhs = ((ReferencedCourtCase) other);
        return new EqualsBuilder().append(generated, rhs.generated).append(judgementsIds, rhs.judgementsIds).append(caseNumber, rhs.caseNumber).isEquals();
    }

}

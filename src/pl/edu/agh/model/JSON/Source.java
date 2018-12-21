
package pl.edu.agh.model.JSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class Source implements Serializable
{

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("judgmentUrl")
    @Expose
    private String judgmentUrl;
    @SerializedName("judgmentId")
    @Expose
    private String judgmentId;
    @SerializedName("publisher")
    @Expose
    private String publisher;
    @SerializedName("reviser")
    @Expose
    private String reviser;
    @SerializedName("publicationDate")
    @Expose
    private String publicationDate;
    private final static long serialVersionUID = -5882449742765435399L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Source() {
    }

    /**
     * 
     * @param reviser
     * @param judgmentUrl
     * @param code
     * @param judgmentId
     * @param publicationDate
     * @param publisher
     */
    public Source(String code, String judgmentUrl, String judgmentId, String publisher, String reviser, String publicationDate) {
        super();
        this.code = code;
        this.judgmentUrl = judgmentUrl;
        this.judgmentId = judgmentId;
        this.publisher = publisher;
        this.reviser = reviser;
        this.publicationDate = publicationDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getJudgmentUrl() {
        return judgmentUrl;
    }

    public void setJudgmentUrl(String judgmentUrl) {
        this.judgmentUrl = judgmentUrl;
    }

    public String getJudgmentId() {
        return judgmentId;
    }

    public void setJudgmentId(String judgmentId) {
        this.judgmentId = judgmentId;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getReviser() {
        return reviser;
    }

    public void setReviser(String reviser) {
        this.reviser = reviser;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("code", code).append("judgmentUrl", judgmentUrl).append("judgmentId", judgmentId).append("publisher", publisher).append("reviser", reviser).append("publicationDate", publicationDate).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(reviser).append(judgmentUrl).append(code).append(judgmentId).append(publicationDate).append(publisher).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Source) == false) {
            return false;
        }
        Source rhs = ((Source) other);
        return new EqualsBuilder().append(reviser, rhs.reviser).append(judgmentUrl, rhs.judgmentUrl).append(code, rhs.code).append(judgmentId, rhs.judgmentId).append(publicationDate, rhs.publicationDate).append(publisher, rhs.publisher).isEquals();
    }

}

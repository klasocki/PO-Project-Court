package court;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DissentingOpinion implements Serializable
{

    @SerializedName("textContent")
    @Expose
    private String textContent;
    @SerializedName("authors")
    @Expose
    private List<String> authors = new ArrayList<String>();
    private final static long serialVersionUID = 6582367062749941517L;

    /**
     * No args constructor for use in serialization
     *
     */
    public DissentingOpinion() {
    }

    /**
     *
     * @param authors
     * @param textContent
     */
    public DissentingOpinion(String textContent, List<String> authors) {
        super();
        this.textContent = textContent;
        this.authors = authors;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("textContent", textContent).append("authors", authors).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(authors).append(textContent).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DissentingOpinion) == false) {
            return false;
        }
        DissentingOpinion rhs = ((DissentingOpinion) other);
        return new EqualsBuilder().append(authors, rhs.authors).append(textContent, rhs.textContent).isEquals();
    }

}
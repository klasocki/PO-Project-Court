
package pl.edu.agh.model.JSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import java.io.Serializable;

public class Source implements Serializable
{
    /**
     * No args constructor for use in serialization
     *
     */
    public Source() {
    }

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


}

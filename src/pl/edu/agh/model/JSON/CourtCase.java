
package pl.edu.agh.model.JSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class CourtCase implements Serializable
{
    /**
     * No args constructor for use in serialization
     *
     */
    public CourtCase() {
    }

    @SerializedName("caseNumber")
    @Expose
    private String caseNumber;
    private final static long serialVersionUID = 6173036093291686720L;

    public String getCaseNumber() {
        return caseNumber;
    }
}

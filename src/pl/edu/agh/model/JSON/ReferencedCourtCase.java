
package pl.edu.agh.model.JSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
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
}

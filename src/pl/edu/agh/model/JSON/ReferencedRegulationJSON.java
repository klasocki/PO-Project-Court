
package pl.edu.agh.model.JSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import pl.edu.agh.model.ReferencedRegulation;

import java.io.Serializable;

public class ReferencedRegulationJSON implements Serializable, ReferencedRegulation
{

    @SerializedName("journalTitle")
    @Expose
    private String journalTitle;

    public String getJournalTitle() {
        return journalTitle;
    }

    private final static long serialVersionUID = -9188532900197882989L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ReferencedRegulationJSON() {
    }

}

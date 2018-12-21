package pl.edu.agh.model.JSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DissentingOpinion implements Serializable
{
    public DissentingOpinion() {
    }

    /**
     * No args constructor for use in serialization
     *
     */

    @SerializedName("textContent")
    @Expose
    private String textContent;
    @SerializedName("authors")
    @Expose
    private List<String> authors = new ArrayList<String>();
    private final static long serialVersionUID = 6582367062749941517L;


}
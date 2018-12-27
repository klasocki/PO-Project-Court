//TODO override toString in SpecialRoles

package pl.edu.agh.model.JSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import pl.edu.agh.model.Judge;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class JudgeJSON implements Serializable, Judge {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("function")
    @Expose
    private Object function;
    @SerializedName("specialRoles")
    @Expose
    private List<SpecialRole> specialRoles = new ArrayList<>();

    public String getName() {
        return name;
    }

    @Override
    public List<String> getSpecialRoles() {
        return specialRoles.stream().map(SpecialRole::toString).collect(Collectors.toUnmodifiableList());
    }

    public enum SpecialRole {
        PRESIDING_JUDGE, // przewodniczacy składu sędziowskiego

        REPORTING_JUDGE, // sędzia sprawozdawca

        REASONS_FOR_JUDGMENT_AUTHOR // autor uzasadnienia

        ;

        public String toString() {
            switch (this) {
                case PRESIDING_JUDGE:
                    return "Przewodniczacy składu sędziowskiego";
                case REPORTING_JUDGE:
                    return "Sędzia sprawozdawca";
                case REASONS_FOR_JUDGMENT_AUTHOR:
                    return "Autor uzasadnienia";
            }
            return "";
        }

    }

    private final static long serialVersionUID = 2321313045761325177L;

    /**
     * No args constructor for use in serialization
     */
    public JudgeJSON() {
    }
}

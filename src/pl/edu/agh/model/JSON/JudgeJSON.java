//TODO override toString in SpecialRoles

package pl.edu.agh.model.JSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import pl.edu.agh.model.Judge;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class JudgeJSON implements Serializable, Judge
{
    /**
     * No args constructor for use in serialization
     *
     */
    public JudgeJSON() {
    }

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("function")
    @Expose
    private Object function;
    @SerializedName("specialRoles")
    @Expose
    private List<SpecialRole> specialRoles = new ArrayList<>();
    private final static long serialVersionUID = 2321313045761325177L;

    public String getName() {
        return name;
    }

    @Override
    public List<String> getSpecialRoles() {
        return specialRoles.stream().map(SpecialRole::toString).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("function", function).append("specialRoles", specialRoles).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(specialRoles).append(name).append(function).toHashCode();
    }


    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof JudgeJSON)) {
            return false;
        }
        JudgeJSON rhs = ((JudgeJSON) other);
        return new EqualsBuilder().append(specialRoles, rhs.specialRoles).append(name, rhs.name).append(function, rhs.function).isEquals();
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


}
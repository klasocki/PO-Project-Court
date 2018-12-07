
package pl.edu.agh.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Judge implements Serializable
{

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

    /**
     * No args constructor for use in serialization
     * 
     */
    public Judge() {
    }

    /**
     * 
     * @param specialRoles
     * @param name
     * @param function
     */
    public Judge(String name, Object function, List<String> specialRoles) {
        super();
        this.name = name;
        this.function = function;
        this.specialRoles = specialRoles.stream().map(SpecialRole::valueOf).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getFunction() {
        return function;
    }

    public void setFunction(Object function) {
        this.function = function;
    }

    public List<SpecialRole> getSpecialRoles() {
        return specialRoles;
    }

    public void setSpecialRoles(List<String> specialRoles) {
        this.specialRoles = specialRoles.stream().map(SpecialRole::valueOf).collect(Collectors.toList());
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
        if (!(other instanceof Judge)) {
            return false;
        }
        Judge rhs = ((Judge) other);
        return new EqualsBuilder().append(specialRoles, rhs.specialRoles).append(name, rhs.name).append(function, rhs.function).isEquals();
    }


        public enum SpecialRole {
            PRESIDING_JUDGE, // przewodniczacy składu sędziowskiego

            REPORTING_JUDGE, // sędzia sprawozdawca

            REASONS_FOR_JUDGMENT_AUTHOR // autor uzasadnienia

        }


}

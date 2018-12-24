package pl.edu.agh.model.HTML;

import pl.edu.agh.model.Judge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JudgeHTML implements Judge {
    private String name;
    List<String> specialRoles = new ArrayList<>();

    public JudgeHTML(String text) {
        this.name = text.split("/")[0];
        var roles = text.split("/")[1].split("\\s");
        this.specialRoles.addAll(Arrays.asList(roles));
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<String> getSpecialRoles() {
        return specialRoles;
    }
}

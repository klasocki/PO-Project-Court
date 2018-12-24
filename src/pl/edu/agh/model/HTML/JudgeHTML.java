package pl.edu.agh.model.HTML;

import pl.edu.agh.model.Judge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JudgeHTML implements Judge {
    private String name;
    List<String> specialRoles = new ArrayList<>();

    public JudgeHTML(String text) {
        var splittedText = text.split("/");
        this.name = splittedText[0];
        if (splittedText.length > 1) {
            var roles = splittedText[1].split("\\s");
            this.specialRoles.addAll(Arrays.asList(roles));
        }
    }

    @Override
    public String getName() {
        return name.trim();
    }

    @Override
    public List<String> getSpecialRoles() {
        return specialRoles;
    }
}

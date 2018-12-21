package pl.edu.agh.model;

import pl.edu.agh.model.JSON.JudgeJSON;

import java.util.List;

public interface Judge {
    String getName();
    List<JudgeJSON.SpecialRole> getSpecialRoles();
}

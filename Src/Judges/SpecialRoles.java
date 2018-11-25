package Judges;

import java.util.ArrayList;
import java.util.List;

public class SpecialRoles {
    List<SpecialRole> specialRoles = new ArrayList<>();
    public enum SpecialRole {
        PRESIDING_JUDGE, // przewodniczacy składu sędziowskiego

        REPORTING_JUDGE, // sędzia sprawozdawca

        REASONS_FOR_JUDGMENT_AUTHOR // autor uzasadnienia
    }

}

package Judges;

import java.util.ArrayList;
import java.util.List;

public class Judges {
    List<Judge> judges = new ArrayList<>();

    private class Judge{
        Name name;
        String function;
        SpecialRoles specialRoles;
    }
}

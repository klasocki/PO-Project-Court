package Court;

import Judges.Name;

import java.net.URL;
import java.util.Date;

public class RulingSource {
    Code code;
    String judgementId;
    Name publisher;
    Name reviser;
    Date publicationDate;
    URL judgementUrl;

    public enum Code {
        COMMON_COURT, // sąd powszechny
        SUPREME_COURT, // Sąd Najwyższy
        CONSTITUTIONAL_TRIBUNAL, // Trybunał Konstytucyjny
        NATIONAL_APPEAL_CHAMBER // Krajowa Izba Odwoławcza
    }
}

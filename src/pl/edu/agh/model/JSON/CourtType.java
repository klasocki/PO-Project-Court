package pl.edu.agh.model.JSON;

public enum CourtType {
    COMMON, // sąd powszechny

    SUPREME, // Sąd Najwyższy

    ADMINISTRATIVE, // sąd administracyjny

    CONSTITUTIONAL_TRIBUNAL, // Trybunał Konstytucyjny

    NATIONAL_APPEAL_CHAMBER; // Krajowa Izba Odwoławcza


    @Override
    public String toString() {
        switch (this) {
            case COMMON:
                return "Sąd powszechny";
            case SUPREME:
                return "Sąd Najwyższy";
            case ADMINISTRATIVE:
                return "Sąd Administracyjny";
            case CONSTITUTIONAL_TRIBUNAL:
                return "Trybunał Konstytucyjny";
            case NATIONAL_APPEAL_CHAMBER:
                return "Krajowa Izba Odwoławcza";
        }
        return "";
    }
}

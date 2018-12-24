package pl.edu.agh.model.HTML;

import pl.droidsonroids.jspoon.annotation.Format;
import pl.droidsonroids.jspoon.annotation.Selector;
import pl.edu.agh.model.Judge;
import pl.edu.agh.model.Judgment;
import pl.edu.agh.model.ReferencedRegulation;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class JudgmentHTML implements Judgment {
    @Selector(
            value = "TITLE",
            //regex matching everything before " -"
            regex = "(.+?(?=\\s+-))"
    )
    private String signature;

    @Format(value = "yyyy-MM-dd")
    @Selector(
            value = "tr.niezaznaczona",
            //date regex (judgment date is always the first date in the table)
            regex = "(\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01]))"
    )
    private Date date;

    @Selector("span.info-list-value-uzasadnienie")
    private List<String> textContent;

    @Selector("span.nakt")
    private List<String> regulations;

    @Selector("tr.niezaznaczona")
    private List<Niezaznaczona> tableRows;

    private List<Judge> judges = new ArrayList<>();

    @Override
    public String getKey() {
        return signature;
    }

    @Override
    public List<Judge> getJudges() {
        return Collections.unmodifiableList(judges);
    }

    @Override
    public String getCourtType() {
        for (var tr : tableRows) {
            if (tr.label.matches("(?i)(s[aą]d)q")) {
                //regex to get e.g. only "sąd wojewódzki" from "sąd wojewódzki w Krakowie"
                return tr.value.trim().split("\\s+w\\s+\\p{Lu}\\p{Ll}+")[0];
            }
        }
        return null;
    }

    @Override
    public String getTextContent() {
        // niektore orzeczenia nie maja uzasadnienia, tylko sentencje!!
        // A niektóre i tezy i sentencje, ale uzasadnienie jest zawsze na koncu
        return textContent.get(textContent.size() - 1);
    }

    @Override
    public List<ReferencedRegulation> getReferencedRegulations() {
        return regulations.stream().map(ReferencedRegulationHTML::stringToRegulation).
                collect(Collectors.toList());
    }

    @Override
    public LocalDate getJudgmentDate() {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    void setJudges(List<Judge> judges) {
        if (!judges.isEmpty()) {
            throw new UnsupportedOperationException("You can only set judges once, through the builder class!");
        } else
            this.judges = judges;
    }

    private class Niezaznaczona {
        @fr.whimtrip.ext.jwhthtmltopojo.annotation.Selector("td.info-list-label")
        String label;
        @fr.whimtrip.ext.jwhthtmltopojo.annotation.Selector("td.info-list-value")
        String value;
    }
}


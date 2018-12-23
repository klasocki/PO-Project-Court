package pl.edu.agh.model.HTML;

import pl.droidsonroids.jspoon.annotation.Format;
import pl.droidsonroids.jspoon.annotation.Selector;
import pl.edu.agh.model.Judge;
import pl.edu.agh.model.Judgment;
import pl.edu.agh.model.ReferencedRegulation;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class JudgmentHTML implements Judgment {
    @Selector(
            value = "TITLE",
            regex = "(.+?(?=\\s-))"
    )
    private String signature;

    @Format(value = "yyyy-MM-dd")
    @Selector(
            value = "tr.niezaznaczona",
            regex = "(\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01]))"
    )
    private Date date;

    @Selector(
            value = "span.info-list-value-uzasadnienie"
    )
    private List<String> textContent;

    @Override
    public String getKey() {
        return signature;
    }

    @Override
    public List<Judge> getJudges() {
        return null;
    }

    @Override
    public String getCourtType() {
        return null;
    }

    @Override
    public String getTextContent() {
        if (textContent.size() == 2) {
            return textContent.get(1);
        }
        // niektore orzeczenia nie maja uzasadnienia, tylko sentencje!!
        return textContent.get(0);
    }

    @Override
    public List<ReferencedRegulation> getReferencedRegulations() {
        return null;
    }

    @Override
    public LocalDate getJudgmentDate() {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}


package pl.edu.agh.model.HTML;

import org.jsoup.Jsoup;
import pl.droidsonroids.jspoon.HtmlAdapter;
import pl.droidsonroids.jspoon.Jspoon;
import pl.edu.agh.model.Judge;
import pl.edu.agh.model.Judgment;

import java.util.ArrayList;
import java.util.List;

public class JudgmentHTMLBuilder {

    private final Jspoon jspoon = Jspoon.create();
    private final HtmlAdapter<JudgmentHTML> adapter = jspoon.adapter(JudgmentHTML.class);

    public Judgment buildJudgment(String htmlContent) {
        var judgment = adapter.fromHtml(htmlContent);
        judgment.setJudges(buildJudges(htmlContent));
        return judgment;
    }

    private List<Judge> buildJudges(String htmlContent) {
        String judgesRawHtml = getJudgesRawHtml(htmlContent);
        var judgesString = judgesRawHtml.trim().split("<br>");
        List<Judge> result = new ArrayList<>();
        for (var judgeText : judgesString) {
            result.add(new JudgeHTML(judgeText));
        }
        return result;
    }

    private String getJudgesRawHtml(String htmlContent) {
        var doc = Jsoup.parse(htmlContent);
        var labelQuery = "td.info-list-label";
        var valueQuery = "td.info-list-value";
        var judgesRawHtml = "";
        for (var element : doc.select("tr.niezaznaczona")) {
            if (element.select(labelQuery).text().matches("\\s*(?i)(s([eę])dzi(a|(owie)))\\s*")) {
                judgesRawHtml = element.select(valueQuery).html();
            }
        }
        return judgesRawHtml;
    }
}

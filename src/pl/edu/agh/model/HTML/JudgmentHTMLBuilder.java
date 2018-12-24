package pl.edu.agh.model.HTML;

import fr.whimtrip.ext.jwhthtmltopojo.HtmlToPojoEngine;
import fr.whimtrip.ext.jwhthtmltopojo.intrf.HtmlAdapter;
import org.jsoup.Jsoup;
import pl.edu.agh.model.Judge;
import pl.edu.agh.model.Judgment;

import java.util.ArrayList;
import java.util.List;

public class JudgmentHTMLBuilder {

    private final HtmlToPojoEngine htmlToPojoEngine = HtmlToPojoEngine.create();
    private final HtmlAdapter<JudgmentHTML> adapter = htmlToPojoEngine.adapter(JudgmentHTML.class);

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

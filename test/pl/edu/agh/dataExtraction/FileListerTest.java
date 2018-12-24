package pl.edu.agh.dataExtraction;

import fr.whimtrip.ext.jwhthtmltopojo.HtmlToPojoEngine;
import fr.whimtrip.ext.jwhthtmltopojo.adapter.*;
import fr.whimtrip.ext.jwhthtmltopojo.annotation.ReplaceWith;
import fr.whimtrip.ext.jwhthtmltopojo.intrf.HtmlAdapter;
import pl.droidsonroids.jspoon.Jspoon;
import pl.droidsonroids.jspoon.annotation.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.select.Selector;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileListerTest {

    private static final String file = "jsonData";

    private static void wrongArgumentExecutable() throws IOException {
        FileLister.listFiles(file, ".txt");
    }

    @Test
    void listFilesTest() throws IOException {
        assertThrows(IllegalArgumentException.class, FileListerTest::wrongArgumentExecutable,
                "No files in directory " + file + " end with: .txt");
        File[] files = {
                new File("jsonData/judgments-348.json"),
                new File("jsonData/judgments-356.json"),
                new File("jsonData/judgments-520.json"),
                new File("jsonData/judgments-924.json"),
                new File("jsonData/judgments-995.json"),
                new File("jsonData/judgments-1117.json"),
                new File("jsonData/judgments-1287.json"),
                new File("jsonData/judgments-1324.json"),
                new File("jsonData/judgments-1338.json"),
                new File("jsonData/judgments-1912.json")
        };
        List<File> fileList = Arrays.asList(files);
        var filesRead = Arrays.asList(FileLister.listFiles(file, ".json"));
        assertTrue(fileList.containsAll(filesRead));
    }

    @Test
    void foo() throws IOException {
        final String fieldNameQuery = "td.lista-label";
        final String fieldValueQuery = "td.info-list-value";


        var files = FileLister.listFiles("htmlData", ".html");
        var file = files[0];
        Document doc = Jsoup.parse(file, "utf-8");
        Elements s = Selector.select(fieldNameQuery, doc);
        var val = Selector.select(fieldValueQuery, doc);
        var sentence = Selector.select("span.info-list-value-uzasadnienie", doc);
        System.out.println(sentence.get(1).text());

        System.out.println("Ewa Markiewicz /sprawozdawca/ /tentego/".split("/")[1]);

        HtmlToPojoEngine htmlToPojoEngine = HtmlToPojoEngine.create();

        HtmlAdapter<HasTitle> adapter = htmlToPojoEngine.adapter(HasTitle.class);
        var string = new String(Files.readAllBytes(Paths.get("htmlData/10/20/B10EFA642A.html")), StandardCharsets.UTF_8);
        var z = adapter.fromHtml(string);
        for (var t : z.regulations) {
            System.out.println(t);
        }

        for (var el : doc.select("tr.niezaznaczona") ) {
            if (el.select(fieldNameQuery).text().matches("\\s*(?i)(s(e|ę)dzi(a|(owie)))\\s*")) {
                System.out.println(el.select(fieldValueQuery).html());
                System.out.println(el.
                        select("td.info-list-value").
//                        text());
                        toString().split("<td class=\"info-list-value\">")[1].split("</td>")[0]
                .split("<br>").length
                );
                System.out.println("tu match jest");
            }

        }
    }
}

class HasTitle {
    @fr.whimtrip.ext.jwhthtmltopojo.annotation.Selector("tr.niezaznaczona")
    @ReplaceWith(value = "/",
            with = "**********")
    List<Niezaznaczona> tags;

    @fr.whimtrip.ext.jwhthtmltopojo.annotation.Selector("span.nakt")
    List<String> regulations;
}

class Niezaznaczona {
    @fr.whimtrip.ext.jwhthtmltopojo.annotation.Selector("td.info-list-label")
    String label;
    @fr.whimtrip.ext.jwhthtmltopojo.annotation.Selector("td.info-list-value")
    String value;
    @Override
    public String toString() {
        return "Niezaznaczona{" +
                "label='" + label + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

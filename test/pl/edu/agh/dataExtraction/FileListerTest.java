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
        var s = "polecenie \"argumenty\" \"argumenty to jest tooo\" \"oo tak\" ";
        /*for (var v : s.split("\\s")) {
            System.out.println(v);
        }*/
        for (var q : s.split("\"")) {
            System.out.println(q);
        }

    }
}

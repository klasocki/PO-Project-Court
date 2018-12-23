package pl.edu.agh.console;

import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

    public static void writeToFile(String filePath, String content) throws IOException {
        var fw = new FileWriter(filePath);
        fw.write(content);
        fw.close();
    }

}

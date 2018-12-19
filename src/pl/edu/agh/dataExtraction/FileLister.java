package pl.edu.agh.dataExtraction;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileLister {
    public static File[] listFiles(File folder, String endingWith) throws IllegalArgumentException, IOException {

        File[] filesFiltered = Files.walk(Paths.get(folder.getPath()))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .filter(f -> f.getName().endsWith(endingWith))
                .toArray(File[]::new);

        if (filesFiltered.length == 0) {
            throw new IllegalArgumentException("No files in directory " + folder.getPath() + " end with: " + endingWith);
        }
        return filesFiltered;
    }
}

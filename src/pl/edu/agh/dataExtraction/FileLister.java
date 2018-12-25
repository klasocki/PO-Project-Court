package pl.edu.agh.dataExtraction;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileLister {
    public static File[] listFiles(String folder, String endingWith) throws IllegalArgumentException, IOException {

        File[] filesFiltered = Files.walk(Paths.get(folder))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .filter(f -> f.getName().endsWith(endingWith))
                .toArray(File[]::new);

        if (filesFiltered.length == 0) {
            throw new IllegalArgumentException("W folderze " + folder +
                    " nie ma plików kończących się na: " + endingWith);
        }
        return filesFiltered;
    }
}

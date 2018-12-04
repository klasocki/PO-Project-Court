package dataExtraction;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;


public class FileLister {
    public static File[] listFiles(File folder, String endingWith) throws IllegalArgumentException {
        File[] filesFiltered = folder.listFiles((file, s) -> s.endsWith(endingWith));
        if (filesFiltered == null || filesFiltered.length == 0) {
            throw new IllegalArgumentException("No files in directory " + folder.getPath() + "end with: " + endingWith);
        }
        return filesFiltered;
    }
}

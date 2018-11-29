package dataExtraction;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileLister {
    public static List<String> listFiles(File folder, String endingWith) throws IllegalArgumentException {
        var filesFiltered = folder.listFiles((file, s) -> s.endsWith(endingWith));
        if (filesFiltered == null || filesFiltered.length == 0) {
            throw new IllegalArgumentException("No files in directory " + folder.getPath() + "end with: " + endingWith);
        }
        return Arrays.stream(filesFiltered).map(File::getName).collect(Collectors.toList());
    }
}

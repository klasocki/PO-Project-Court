package pl.edu.agh.commands;

import org.junit.jupiter.api.Test;
import pl.edu.agh.TestFileReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TextContentTest {
    @Test
    void getTextContentTest() throws IOException {
        var judgements = TestFileReader.read();
        var textContentCommand = new TextContent(new String[]{}, judgements, "");
        assertEquals(textContentCommand.getTC("U 3/86").substring(0, 36), "Orzeczenie z dnia 16 czerwca 1986 r.");
        assertThrows(IllegalArgumentException.class, () -> textContentCommand.getTC("adfs"),
                "Nie znaleziono orzeczenia o sygnaturze adfs");
    }

}
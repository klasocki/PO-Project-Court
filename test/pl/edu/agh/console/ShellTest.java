package pl.edu.agh.console;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShellTest {

    @Test
    void getCommandArgumentsTest() {
        var shell = new Shell(null);
        var args = shell.getCommandArguments("rubrum \"sa     3r.3 \" \"asf3r\" \"".split("\""));
        assertEquals("sa 3r.3", args[0]);
        assertEquals("asf3r", args[1]);
    }
}
package ua.duikt.pr6;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

final class Utf8 {
    private Utf8() { }

    static void init() {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.setErr(new PrintStream(System.err, true, StandardCharsets.UTF_8));
    }
}

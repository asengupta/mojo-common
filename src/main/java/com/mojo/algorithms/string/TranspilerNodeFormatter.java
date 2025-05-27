package com.mojo.algorithms.string;

import java.util.stream.Stream;

import static org.apache.commons.lang3.StringUtils.truncate;

public class TranspilerNodeFormatter {
    public String prettyShort(String s, int maxLength) {
        return truncate(squish(s), maxLength);
    }

    public String squish(String s) {
        return s.trim()
                .replaceAll("\\s+", " ")
                .replaceAll("\n", " ");
    }

    public String prettyShort(String s) {
        return prettyShort(s, 30);
    }

    public Stream<String> splitLinesStream(String s, int lineLength) {
        if (s.length() < lineLength) return Stream.of(s);
        return Stream.concat(Stream.of(truncate(s, lineLength)), splitLinesStream(s.substring(lineLength), lineLength));
    }

    public String splitLines(String s, int lineLength, String joinCharacter) {
        return splitLinesStream(s, lineLength).reduce("",  (a, b) -> a + joinCharacter + b) + joinCharacter;
    }
}

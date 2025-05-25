package com.mojo.algorithms.string;

import static org.apache.commons.lang3.StringUtils.truncate;

public class TranspilerNodeFormatter {
    public String prettyShort(String s, int maxLength) {
        return truncate(s.trim()
                .replaceAll("\\s+", " ")
                .replaceAll("\n", " "), maxLength);
    }

    public String prettyShort(String s) {
        return prettyShort(s, 30);
    }
}

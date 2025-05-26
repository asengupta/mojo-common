package com.mojo.algorithms.string;

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
}

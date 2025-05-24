package com.mojo.algorithms.domain;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class NullTranspilerInstruction extends TranspilerInstruction {
    private Map<String, String> metadata;

    public NullTranspilerInstruction(String id) {
        this(id, ImmutableMap.of());
    }

    public NullTranspilerInstruction(String id, Map<String, String> metadata) {
        super(null, CodeSentinelType.BODY, id);
        this.metadata = metadata;
    }

    @Override
    public String description() {
        return "NULL_INSTRUCTION";
    }

    @Override
    public String originalText() {
        return "NULL_INSTRUCTION";
    }

    @Override
    public String toString() {
        return "NULL_INSTRUCTION";
    }
}

package com.mojo.algorithms.domain;

public class NullTranspilerInstruction extends TranspilerInstruction {
    public NullTranspilerInstruction(String id) {
        super(null, CodeSentinelType.BODY, id);
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

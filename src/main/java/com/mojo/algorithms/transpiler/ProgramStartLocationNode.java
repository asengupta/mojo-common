package com.mojo.algorithms.transpiler;

public class ProgramStartLocationNode extends LocationNode {
    public static LocationNode START = new ProgramStartLocationNode();
    @Override
    public String description() {
        return "programStart()";
    }

    @Override
    public String name() {
        return "START";
    }
}

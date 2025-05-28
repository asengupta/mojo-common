package com.mojo.algorithms.domain;

import com.google.common.collect.ImmutableMap;
import com.mojo.algorithms.id.Identifiable;
import com.mojo.algorithms.id.InstructionLike;
import com.mojo.algorithms.list.CarCdr;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BasicBlock<T extends InstructionLike> implements Identifiable {
    @Getter
    private final List<T> instructions = new ArrayList<>();
    private final String id;
    private Map<String, Object> properties;

    public BasicBlock(String id) {
        this(id, ImmutableMap.of());
    }

    public BasicBlock(String id, Map<String, Object> properties) {
        this.id = id;
        this.properties = properties;
    }

    public BasicBlock(String id, List<T> instructions, Map<String, Object> properties) {
        this.id = id;
        this.instructions.addAll(instructions);
        this.properties = properties;
    }

    public Object getProperty(String property) {
        return properties.get(property);
    }

    public void add(T instruction) {
        instructions.add(instruction);
    }

    public boolean isEmpty() {
        return instructions.isEmpty();
    }

    public int size() {
        return instructions.size();
    }

    public T firstInstruction() {
        return CarCdr.head(instructions).get();
    }
    public T lastInstruction() {
        return instructions.getLast();
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public String label() {
        return id;
    }

    public boolean contains(T instruction, CodeSentinelType codeSentinelType) {
        return instructions.contains(instruction) && instruction.sentinel() == codeSentinelType;
    }
}

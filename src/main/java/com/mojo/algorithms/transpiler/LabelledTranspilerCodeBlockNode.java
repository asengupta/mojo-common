package com.mojo.algorithms.transpiler;

import com.google.common.collect.ImmutableList;
import com.mojo.algorithms.domain.SemanticCategory;
import com.mojo.algorithms.domain.TranspilerNode;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class LabelledTranspilerCodeBlockNode extends TranspilerCodeBlockNode {
    private final String name;

    public LabelledTranspilerCodeBlockNode(String name, List<TranspilerNode> children, Map<String, Object> properties) {
        this(name, children, properties, ImmutableList.of(SemanticCategory.CODE_BLOCK));
    }

    public LabelledTranspilerCodeBlockNode(String name, List<TranspilerNode> children, Map<String, Object> properties, List<SemanticCategory> categories) {
        super(children, properties, categories);
        this.name = name;
    }

    @Override
    public String description() {
        return String.format("[CODE_BLOCK: %s] : ", name) + " {\n" + String.join("\n", childTranspilerNodes.stream().map(TranspilerNode::description).toList()) + "\n}\n";
//        return String.format("[%s]", name);
    }

    @Override
    public String shortDescription() {
        return String.format("[CODE_BLOCK: %s] : ", name);
    }

    @Override
    public String label() {
        return name;
    }
}

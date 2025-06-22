package com.mojo.algorithms.task;

import com.mojo.algorithms.id.IncrementingIdProvider;
import com.mojo.algorithms.domain.TranspilerInstruction;
import com.mojo.algorithms.domain.TranspilerNode;
import com.mojo.algorithms.visitor.TranspilerInstructionGeneratorVisitor;
import com.mojo.algorithms.navigation.AggregatingTranspilerNodeTraversal;

import java.util.List;

public class BuildTranspilerInstructionsFromIntermediateTreeTask {
    private final IncrementingIdProvider idProvider;
    private final TranspilerNode root;

    public BuildTranspilerInstructionsFromIntermediateTreeTask(TranspilerNode root, IncrementingIdProvider idProvider) {
        this.root = root;
        this.idProvider = idProvider;
    }

    public List<TranspilerInstruction> run() {
        TranspilerInstructionGeneratorVisitor visitor = new TranspilerInstructionGeneratorVisitor(idProvider);
        new AggregatingTranspilerNodeTraversal<List<TranspilerInstruction>>().accept(root, visitor);
        return visitor.result();
    }
}

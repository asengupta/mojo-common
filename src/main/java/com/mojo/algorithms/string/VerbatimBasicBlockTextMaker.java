package com.mojo.algorithms.string;

import com.mojo.algorithms.domain.BasicBlock;
import com.mojo.algorithms.domain.TranspilerInstruction;
import com.mojo.algorithms.transpiler.IfTranspilerNode;

public class VerbatimBasicBlockTextMaker implements BasicBlockTextMaker {
    private final TranspilerNodeFormatter textFormatter = new TranspilerNodeFormatter();

    @Override
    public String format(BasicBlock<TranspilerInstruction> bb) {
        if (bb.getInstructions().size() == 1 && bb.firstInstruction().ref() instanceof IfTranspilerNode)
            return textFormatter.splitLines(textFormatter.squish(flowchartSourceText(bb.getInstructions().getFirst())), 15, "\n");
        String flowchartLabelLineBreak = "\\l";
        return bb.getInstructions().stream()
                                   .map(instruction -> textFormatter.squish(flowchartSourceText(instruction)))
                                   .reduce("", (a, b) -> a + flowchartLabelLineBreak + b) + flowchartLabelLineBreak;
    }

    private static String flowchartSourceText(TranspilerInstruction instruction) {
        if (instruction.ref() instanceof IfTranspilerNode ift)
            return "Is " + ift.getCondition().description() + "?";
        return instruction.originalText();
    }
}

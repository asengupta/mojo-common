package com.mojo.algorithms.string;

import com.mojo.algorithms.domain.BasicBlock;
import com.mojo.algorithms.domain.TranspilerInstruction;

public interface BasicBlockTextFormatter {
    String format(BasicBlock<TranspilerInstruction> bb);
}

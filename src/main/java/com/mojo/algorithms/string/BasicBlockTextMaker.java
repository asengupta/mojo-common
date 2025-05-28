package com.mojo.algorithms.string;

import com.mojo.algorithms.domain.BasicBlock;
import com.mojo.algorithms.domain.TranspilerInstruction;

public interface BasicBlockTextMaker {
    String format(BasicBlock<TranspilerInstruction> bb);
}

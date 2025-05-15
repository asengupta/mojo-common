# mojo-common

A repository of frequently used algorithms and tools for code analysis, transformation, and transpilation.

## Overview

mojo-common is a Java library that provides a comprehensive set of utilities and algorithms for:

- Graph theory operations and analysis
- Control flow analysis
- Code structure representation and manipulation
- Tree traversal and transformation
- Code transpilation (converting code from one language to another)

The library is particularly focused on providing tools for analyzing and transforming code, with special support for control flow graphs, abstract syntax trees, and structured programming transformations.

## Requirements

- Java 21 or higher
- Maven 3.x

## Installation

Add the following dependency to your Maven project:

```xml
<dependency>
    <groupId>com.mojo.algorithms</groupId>
    <artifactId>mojo-algorithms-common</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

Or clone the repository and build it locally:

```bash
git clone https://github.com/yourusername/mojo-common.git
cd mojo-common
mvn clean install
```

## Key Modules

### Domain Package (`com.mojo.algorithms.domain`)

Contains core domain models and data structures for representing code and control flow:

- Graph representations (`TranspilerFlowgraph`, `DominatorTree`, etc.)
- Flow control structures (`BasicBlock`, `FlowNodeType`, etc.)
- Tree manipulation utilities (`TreeSmith`, `TreeMatchResult`)
- Typed data structures (`TypedRecord`, `TypedGraphVertex`, etc.)

### ID Package (`com.mojo.algorithms.id`)

Provides utilities for generating and managing identifiers:

- `IdProvider` - Interface for ID generation
- `IncrementingIdProvider` - Sequential ID generation
- `UUIDProvider` - UUID-based ID generation

### List Package (`com.mojo.algorithms.list`)

Contains list manipulation utilities:

- `CarCdr` - Functional programming utilities for list operations (inspired by Lisp)

### Navigation Package (`com.mojo.algorithms.navigation`)

Provides tools for traversing and manipulating tree structures:

- Visitor pattern implementations (`NodeVisitor`, `TreeMapperVisitor`, etc.)
- Tree traversal utilities (`TreeTraversal`, `AggregatingTranspilerNodeTraversal`, etc.)

### Task Package (`com.mojo.algorithms.task`)

Contains a framework for performing code analysis and transformation tasks:

- Graph analysis tasks (`BuildDJTreeTask`, `BuildDominatorTreeTask`, etc.)
- Control flow analysis (`BuildBasicBlocksTask`, `BuildInstructionFlowgraphTask`, etc.)
- Loop analysis (`LoopBodyDetectionTask`, `NaturalLoopOfBackEdgeTask`, etc.)
- Code transformation tasks (`RemoveGotoTask`, `StructuredProgramTheoremFormTranspilerTask`, etc.)

### Transpiler Package (`com.mojo.algorithms.transpiler`)

Provides a rich set of node types for representing and manipulating code:

- Operation nodes (`AddNode`, `MultiplyNode`, `DivideNode`, etc.)
- Comparison nodes (`EqualToNode`, `GreaterThanNode`, etc.)
- Control flow nodes (`IfTranspilerNode`, `JumpTranspilerNode`, etc.)
- Function-related nodes (`CallFunctionTranspilerNode`, `FunctionTranspilerNode`, etc.)
- Tree manipulation utilities (`TranspilerCloneOperation`, `TreeMatcher`, etc.)

### Types Package (`com.mojo.algorithms.types`)

Contains classes for representing and manipulating data types:

- COBOL-specific types (`AbstractCobolType`, `CobolDataType`, etc.)
- Value comparison utilities (`ValueBasedComparator`)

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

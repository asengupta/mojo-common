package com.mojo.algorithms.visualisation;

import com.google.common.collect.ImmutableList;

import java.io.IOException;
import java.util.logging.Logger;

/*
These are all options to try:
------------------------------------
dot -Kneato -v5 -Tpng dotfile.dot -oflowchart-level5.png
dot -Kdot -v5 -Gsize=200,200\! -Goverlap=scale -Tpng -Gnslimit=2 -Gnslimit1=2 -Gmaxiter=2000 -Gsplines=line dotfile.dot -oflowchart-level5.png
dot -Kfdp -v5 -Goverlap=scale -Gsize=200,200\! -Tpng  dotfile.dot -oflowchart-level5.png
dot -Ktwopi -v5 -Gsize=200,200\! -Tpng  dotfile.dot -oflowchart-level5.png

This prints out all levels
----------------------------
dot -Kdot -v5 -Gsize=200,200\! -Goverlap=scale -Tpng -Gnslimit=4 -Gnslimit1=4 -Gmaxiter=2000 -Gsplines=line dotfile.dot -oflowchart-level5.png

For large complex graphs, go all out with this
-------------------------------------------------------

dot -Kdot -v5 -Gsize=800,800\! -Goverlap=scale -Tsvg  -Gnodesep-0.5 -Granksep=0.5 -Gpack=true -Gsplines=ortho flowchart.dot -oflowchart.svg
 */

public class GraphGenerator {
    private static final java.util.logging.Logger LOGGER = Logger.getLogger(GraphGenerator.class.getName());
    private final FlowchartOutputFormat outputFormat;

    public GraphGenerator(FlowchartOutputFormat outputFormat) {
        this.outputFormat = outputFormat;
    }

    public void generateImage(String dotFilePath, String imageOutputPath) throws IOException, InterruptedException {
        ImmutableList<String> graphGenerationCommand = ImmutableList.of("dot", "-Kdot", "-v5", "-Gsize=800,800\\!", "-Goverlap=scale", "-T" + outputFormat.extension(), "-Gnodesep-0.5", "-Granksep=0.5", "-Gpack=true", String.format("-Gsplines=%s", outputFormat.lineStyle()), dotFilePath, String.format("-o%s", imageOutputPath));
//        String graphGenerationCommand = String.format("dot -Kdot -v5 -Gsize=800,800\\! -Goverlap=scale -Tpng -Gnslimit=7 -Gnslimit1=7 -Gnodesep-0.5 -Granksep=0.5 -Gmaxiter=5000 -Gsplines=line %s -o%s", dotFilePath, graphOutputPath);
        Process p = new ProcessBuilder(graphGenerationCommand).inheritIO().start();
        int rc = p.waitFor();
//        Process pr = rt.exec(graphGenerationCommand);
        LOGGER.info("Completed graph generation");
    }
}

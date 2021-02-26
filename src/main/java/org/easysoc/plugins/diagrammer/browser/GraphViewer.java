package org.easysoc.plugins.diagrammer.browser;

import com.intellij.openapi.project.Project;

import javax.swing.*;

public class GraphViewer extends JFrame {

    public GraphViewer(String graphFile, Project project) {
        setTitle("Graph Viewer");
        setSize(900,650);
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setContentPane(new GraphBrowser(graphFile, this).getComponent());
    }
}

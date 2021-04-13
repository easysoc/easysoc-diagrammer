package org.easysoc.plugins.diagrammer.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.vfs.VirtualFile;
import org.easysoc.plugins.diagrammer.browser.GraphViewer;
import org.easysoc.plugins.diagrammer.graph.GraphUtil;

public class ElkGraphAction extends AnAction {

  @Override
  public void actionPerformed(AnActionEvent e) {
    VirtualFile file = e.getData(PlatformDataKeys.VIRTUAL_FILE);
    ApplicationManager.getApplication().invokeLater(() -> {
        GraphUtil.init();
        new GraphViewer(file.getCanonicalPath(), e.getProject()).setVisible(true);
    });
  }
}

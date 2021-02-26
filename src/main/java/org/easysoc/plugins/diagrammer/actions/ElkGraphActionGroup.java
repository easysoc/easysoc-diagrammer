package org.easysoc.plugins.diagrammer.actions;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

public class ElkGraphActionGroup extends DefaultActionGroup {

  @Override
  public void update(@NotNull AnActionEvent e) {
    VirtualFile file = e.getData(PlatformDataKeys.VIRTUAL_FILE);
    Presentation presentation = e.getPresentation();

    boolean enable = file != null && file.getFileType().getName().equals("Elkt");
    presentation.setVisible(enable);
  }
}

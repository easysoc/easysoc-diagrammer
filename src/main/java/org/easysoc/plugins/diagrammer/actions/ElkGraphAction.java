package org.easysoc.plugins.diagrammer.actions;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ApplicationNamesInfo;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;
import org.easysoc.plugins.diagrammer.browser.GraphViewer;
import org.easysoc.plugins.diagrammer.graph.GraphUtil;
import org.easysoc.plugins.diagrammer.util.CheckLicense;

public class ElkGraphAction extends AnAction {

  @Override
  public void actionPerformed(AnActionEvent e) {
    VirtualFile file = e.getData(PlatformDataKeys.VIRTUAL_FILE);
    ApplicationManager.getApplication().invokeLater(() -> {
      if (CheckLicense.isLicensed() || ApplicationNamesInfo.getInstance().getProductName().equals("CHIP")) {
        GraphUtil.init();
        new GraphViewer(file.getCanonicalPath(), e.getProject()).setVisible(true);
      } else {
        final ActionManager actionManager = ActionManager.getInstance();
        // first, assume we are running inside the opensource version
        AnAction registerAction = actionManager.getAction("RegisterPlugins");
        if (registerAction == null) {
          // assume running inside commercial IDE distribution
          registerAction = actionManager.getAction("Register");
          if (registerAction != null) {
            registerAction.actionPerformed(AnActionEvent.createFromDataContext("", new Presentation(), CheckLicense.asDataContext("Current functionality requires a license!")));
          } else {
            // fuck pirated copies
            Messages.showErrorDialog("This plugin does not support your environment!",
                    "May Be Pirated Software");
            ApplicationManager.getApplication().exit(true,false,false);
          }
        }
      }
    });
  }
}

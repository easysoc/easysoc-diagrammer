package org.easysoc.plugins.diagrammer.actions;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.vfs.VirtualFile;
import org.easysoc.plugins.diagrammer.graph.GraphUtil;
import org.easysoc.plugins.diagrammer.util.LZString;
import org.eclipse.sprotty.SGraph;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OpenBrowserAction extends AnAction {

  @Override
  public void actionPerformed(AnActionEvent e) {
    VirtualFile file = e.getData(PlatformDataKeys.VIRTUAL_FILE);
    ApplicationManager.getApplication().invokeLater(() -> {
      GraphUtil.init();
      String graphString = "";
      try {
        graphString = Files.readString(Paths.get(file.getCanonicalPath()));
      } catch (IOException ee) {
        ee.printStackTrace();
      }
      if (!graphString.isEmpty()) {
        SGraph graph = GraphUtil.generate(graphString);
        Gson gson = new GsonBuilder().create();
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
        graphString = gson.toJson(graph);
      }

      String url = "https://www.easysoc.org/icviewer/?graph=" + LZString.compressToEncodedURIComponent(graphString);
      BrowserUtil.browse(url);
    });
  }
}

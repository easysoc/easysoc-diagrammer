package org.easysoc.plugins.diagrammer.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.actionSystem.ex.ComboBoxAction;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.PathManager;
import com.intellij.openapi.ui.Messages;
import org.easysoc.plugins.diagrammer.browser.GraphBrowser;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class ThemeAction extends ComboBoxAction {

  private String theme = "";
  private final String webappPath = PathManager.getPluginsPath() + "/easysoc-diagrammer/webapp/";
  private GraphBrowser graphBrowser;

  public ThemeAction(GraphBrowser browser) {
    graphBrowser = browser;
  }

  @Override
  public void update(@NotNull AnActionEvent e) {
    e.getPresentation().setText(theme.isEmpty()? "Theme" : theme);
  }

  @Override
  protected @NotNull DefaultActionGroup createPopupActionGroup(JComponent button) {
    DefaultActionGroup actionGroup = new DefaultActionGroup();
    actionGroup.add(new AnAction("Purple", "Purple", null) {
      @Override
      public void actionPerformed(@NotNull AnActionEvent e) {
        theme = "Purple";
        setTheme();
      }
    });
    actionGroup.add(new AnAction("Solid", "Solid", null) {
      @Override
      public void actionPerformed(@NotNull AnActionEvent e) {
        theme = "Solid";
        setTheme();
      }
    });
    return actionGroup;
  }

  private void setTheme() {
    ApplicationManager.getApplication().invokeLater(() -> {
      String css = "";
      String cssFile = webappPath + theme + ".css";
      try {
        css = Files.readString(Paths.get(cssFile));
      } catch (NoSuchFileException e){
        ApplicationManager.getApplication().invokeLater(() -> {
          Messages.showErrorDialog("Can not find file " + cssFile,"Error");
        });
      } catch (IOException e) {
        e.printStackTrace();
      }

      if (!css.isEmpty()) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(webappPath + "diagram.css", false))) {
          bufferedWriter.write(css);
          graphBrowser.reload();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    });
  }
}

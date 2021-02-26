package org.easysoc.plugins.diagrammer.browser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.intellij.icons.AllIcons;
import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.actionSystem.ex.ToolbarLabelAction;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.PathManager;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.ui.messages.MessageDialog;
import com.intellij.openapi.util.Disposer;
import com.intellij.ui.jcef.JBCefBrowser;
import com.intellij.ui.jcef.JBCefJSQuery;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import org.cef.browser.CefBrowser;
import org.cef.browser.CefFrame;
import org.cef.handler.CefLoadHandler;
import org.cef.network.CefRequest;
import org.easysoc.plugins.diagrammer.actions.ThemeAction;
import org.easysoc.plugins.diagrammer.graph.GraphUtil;
import org.eclipse.sprotty.SGraph;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class GraphBrowser {

    private JFrame frame;
    private String rootGraphFile;
    private String currentGraphDir;
    private String currentGraphName;
    private boolean initialized = false;

    private JComponent browserComponent;
    private JPanel rootPanel;
    private JComponent toolBar;
    private JLabel navigator;
    private DefaultActionGroup actionGroup;

    private JBCefBrowser jbBrowser;
    private CefBrowser browser;

    public GraphBrowser(String graphFile, GraphViewer parent) {
        frame = parent;
        rootGraphFile = graphFile;
        currentGraphDir = new File(rootGraphFile).getParent() + "/";
        setupUI();
    }

    private void setupUI() {
        navigator = new JLabel("");

        createUIComponents();

        rootPanel = new JPanel();
        rootPanel.setLayout(new GridLayoutManager(2, 5, new Insets(0, 0, 0, 0), -1, -1, false, false));
        rootPanel.add(browserComponent, new GridConstraints(1, 0, 1, 5, 0, 3, 3, 3, (Dimension)null, (Dimension)null, (Dimension)null));

        JPanel var3 = new JPanel();
        var3.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1, false, false));
        rootPanel.add(var3, new GridConstraints(0, 0, 1, 4, 1, 1, 3, 0, (Dimension)null, (Dimension)null, (Dimension)null));

        var3.add(toolBar, new GridConstraints(0, 0, 1, 1, 8, 0, 6, 0, (Dimension)null, new Dimension(-1, 20), (Dimension)null));
        var3.add(navigator, new GridConstraints(0, 1, 1, 1, 8, 0, 3, 0, (Dimension)null, (Dimension)null, (Dimension)null));
        Spacer var6 = new Spacer();
        rootPanel.add(var6, new GridConstraints(0, 4, 1, 1, 0, 1, 6, 1, (Dimension)null, (Dimension)null, (Dimension)null));
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        initBrowser();

        ActionManager actionManager = ActionManager.getInstance();
        actionGroup = new DefaultActionGroup(); // must new

        // 必须在窗口关闭时清空，否则 action 内的 jbBrowser 始终指向旧的
        if (actionGroup.getChildrenCount() == 0) {
            actionGroup.add(new AnAction("Root","Root", AllIcons.Nodes.HomeFolder) {
                @Override
                public void actionPerformed(@NotNull AnActionEvent e) {
                    reset();
                }
            });
            actionGroup.add(new AnAction("Go Back", "Go back", AllIcons.Actions.Back) {
                @Override
                public void actionPerformed(@NotNull AnActionEvent e) {
                    goBack();
                }
            });
            actionGroup.add(new AnAction("Center View", "Center view", AllIcons.Actions.GroupByModule) {
                @Override
                public void actionPerformed(@NotNull AnActionEvent e) {
                    centerView();
                }
            });
            actionGroup.add(new AnAction("Fill View", "Fill view", AllIcons.Actions.GroupByModuleGroup) {
                @Override
                public void actionPerformed(@NotNull AnActionEvent e) {
                    fillView();
                }
            });
            actionGroup.add(new AnAction("Export SVG","Export SVG", AllIcons.Actions.Install) {
                @Override
                public void actionPerformed(@NotNull AnActionEvent e) {
                    exportSVG();
                }
            });
            actionGroup.add(new AnAction("Ask Questions", "Ask questions", AllIcons.Actions.Help) {
                @Override
                public void actionPerformed(@NotNull AnActionEvent e) {
                    BrowserUtil.browse("https://github.com/easysoc/easysoc-diagrammer");
                }
            });
            actionGroup.addSeparator();
            actionGroup.add(new ThemeAction(this));
            actionGroup.add(new AnAction("Open Devtools", "Open devtools", AllIcons.Actions.StartDebugger) {
                @Override
                public void actionPerformed(@NotNull AnActionEvent e) {
                    jbBrowser.openDevtools();
                }
            });
            actionGroup.add(new ToolbarLabelAction(){{getTemplatePresentation().setText("Hierarchical:");}});
        }

        toolBar = actionManager.createActionToolbar(ActionPlaces.TOOLBAR, actionGroup, true).getComponent();
        browserComponent = jbBrowser.getComponent();
    }

    private void initBrowser() {
        jbBrowser = new JBCefBrowser(getStartUrl());
        browser = jbBrowser.getCefBrowser();

        JBCefJSQuery renderingGraphQuery = JBCefJSQuery.create(jbBrowser);
        renderingGraphQuery.addHandler((name) -> {
            String graph =  getGraph(graphNameToFile(name));
            if (!graph.isEmpty()) {
//                browser.executeJavaScript("updateModel('"+ name + "'," + graph + ")", null , 0);
                return new JBCefJSQuery.Response("updateModel('"+ name + "'," + graph + ")");
            }
            return new JBCefJSQuery.Response("",1,name + " is empty");
        });

        JBCefJSQuery saveFileQuery = JBCefJSQuery.create(jbBrowser);
        saveFileQuery.addHandler((content) -> {
            saveFile(currentGraphDir + currentGraphName +".svg", content);
            return null;
        });

        JBCefJSQuery setNavigatorQuery = JBCefJSQuery.create(jbBrowser);
        setNavigatorQuery.addHandler((content) -> {
            navigator.setText(content);
            // fix currentGraphName
            String[] nav = content.split("=>");
            graphNameToFile(nav[nav.length - 1].trim());
            return null;
        });

        jbBrowser.getJBCefClient().addLoadHandler(new CefLoadHandler(){
            @Override
            public void onLoadingStateChange(CefBrowser cefBrowser, boolean b, boolean b1, boolean b2) {}

            @Override
            public void onLoadStart(CefBrowser cefBrowser, CefFrame cefFrame, CefRequest.TransitionType transitionType) {
                if (!initialized) {
                    expose(renderingGraphQuery, "renderingGraph" , "" ,
                            "function(response) {new Function(response)();}",
                            "function(error_code, error_message) {}");
                }
            }

            @Override
            public void onLoadEnd(CefBrowser cefBrowser, CefFrame cefFrame, int i) {
                if (!initialized) {
                    browser.executeJavaScript("renderingGraph('root')", null , 0);
                    expose(saveFileQuery, "saveFile" , "" , "", "");
                    expose(setNavigatorQuery, "setNavigator" , "" , "", "");

                    initialized = true;
                }
            }

            @Override
            public void onLoadError(CefBrowser cefBrowser, CefFrame cefFrame, ErrorCode errorCode, String s, String s1) {
                System.out.println(s);
            }
        }, jbBrowser.getCefBrowser());

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                Disposer.dispose(renderingGraphQuery);
                Disposer.dispose(saveFileQuery);
                Disposer.dispose(setNavigatorQuery);
                // see com.intellij.ui.jcef.JBCefBrowser.dispose
//                Disposer.dispose(jbBrowser.getJBCefClient());
                Disposer.dispose(jbBrowser);
                actionGroup.removeAll();
                frame.dispose();
                super.windowClosed(e);
            }
        });

    }

    private void expose(JBCefJSQuery javaFunc, String funcName, String arg, String onSuccessCallback, String onFailureCallback) {
        if (onSuccessCallback.isEmpty()) {
            onSuccessCallback = "function(response) {}";
        }
        if (onFailureCallback.isEmpty()) {
            onFailureCallback = "function(error_code, error_message) {}";
        }
        browser.executeJavaScript(
                "window." + funcName + " = " + " function(arg) {" +
                        javaFunc.inject("arg", onSuccessCallback , onFailureCallback) +
                        "}",
                null, 0);
    }

    private String getGraph(String graphFile)  {
        String graphString = "";
        try {
            graphString = Files.readString(Paths.get(graphFile));
        } catch (NoSuchFileException e){
            ApplicationManager.getApplication().invokeLater(() -> {
                Messages.showErrorDialog("Can not find file " + graphFile,"Error");
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!graphString.isEmpty()) {
            SGraph graph = GraphUtil.generate(graphString);
            Gson gson = new GsonBuilder().create();
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            return gson.toJson(graph);
        }
        return "";
    }

    private String graphNameToFile(String name) {
        String graphFile;
        if (name.equals("root")) {
            currentGraphName = new File(rootGraphFile).getName().replaceAll(".graph","");
            graphFile = rootGraphFile;
        } else {
            currentGraphName = name;
            graphFile = currentGraphDir + name + ".graph";
        }
        return graphFile;
    }

    private void saveFile(String filepath, String content) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filepath, false))) {
            bufferedWriter.write(content);
            ApplicationManager.getApplication().invokeLater(() -> {
                MessageDialog dialog = new MessageDialog("The SVG file has been exported as\n" + filepath +
                        "\nNot all viewers are compatible with the SVG standard.\n" +
                        "Please use Chrome browser to view your SVG file.",
                        "File Export Message",new String[]{"OK"},0, AllIcons.General.InformationDialog);
                dialog.setModal(false);
                dialog.show();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void reset() {
        browser.executeJavaScript("reset()", null , 0);
    }

    private void goBack() {
        browser.executeJavaScript("goBack()", null , 0);
    }

    private void centerView() {
        browser.executeJavaScript("centerView()", null , 0);
    }

    private void fillView() {
        browser.executeJavaScript("fillView()", null , 0);
    }

    private void exportSVG() {
        browser.executeJavaScript("exportSVG()", null , 0);
    }

    private String getStartUrl() {
//        return "file://" + "/media/itviewer/linux/easysoc/easysoc-diagrammer/src/main/webapp/index.html";
        String pluginDir = PathManager.getPluginsPath();
        return "file://" + pluginDir + "/easysoc-diagrammer/webapp/index.html";
    }

    public void reload() {
        initialized = false;
        browser.reload();
    }

    public JPanel getComponent() {
        return rootPanel;
    }

}

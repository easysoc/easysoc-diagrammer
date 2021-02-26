import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.easysoc.plugins.diagrammer.graph.ElkGraphGenerator;
import org.easysoc.plugins.diagrammer.util.LZString;
import org.eclipse.elk.graph.text.ElkGraphStandaloneSetupGenerated;
import org.eclipse.sprotty.SGraph;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class ElktTest {
    public static void main(String[] args) {
        SGraph graph = getGraph();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String base64Graph = Base64.getUrlEncoder().encodeToString(gson.toJson(graph).getBytes(StandardCharsets.UTF_8));
//        System.out.println(base64Graph);
        String lzGraph = LZString.compressToEncodedURIComponent(gson.toJson(graph));
        openUrl("http://localhost/?graph=" + lzGraph);
//        System.out.println(new String(Base64.getUrlDecoder().decode(base64Graph)));
//        System.out.println(gson.toJson(graph));
//        System.out.println(graph.toString());
    }

    public static SGraph getGraph() {
        String initialContent = "algorithm: layered\n" +
                "node n1\n" +
                "node n2\n" +
                "node n3\n" +
                "edge n1 -> n2\n" +
                "edge n1 -> n3";

        try {
            initialContent = Files.readString(Paths.get("/media/itviewer/eda/chisel/layered-firrtl/test_run_dir/visualizer/TopOfVisualizer.graph"));
        } catch (IOException e) {
            e.printStackTrace();
        }

//        ElkGraphPackage.eINSTANCE.getNsURI();
        new ElkGraphStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();

        ElkGraphGenerator generator = new ElkGraphGenerator();
        return generator.generate(initialContent);
    }

    public static void openUrl(String url) {
        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + url);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

package org.easysoc.plugins.diagrammer.graph;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.varia.NullAppender;
import org.eclipse.elk.core.data.LayoutMetaDataService;
import org.eclipse.elk.graph.ElkGraphPackage;
import org.eclipse.elk.graph.text.ElkGraphStandaloneSetupGenerated;
import org.eclipse.sprotty.SGraph;
import org.eclipse.elk.alg.layered.options.LayeredMetaDataProvider;

public class GraphUtil {
    private static ElkGraphGenerator generator;

    public static SGraph generate(String graph) {
        return generator.generate(graph);
    }

    public static void init() {
        if (generator == null) {
            Logger.getRootLogger().removeAllAppenders();
            Logger.getRootLogger().addAppender(new NullAppender());
//            BasicConfigurator.configure();

            // elkt format supports dependency injection
            ElkGraphPackage.eINSTANCE.getNsURI();   // important
            new ElkGraphStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();
            LayoutMetaDataService.getInstance().registerLayoutMetaDataProviders(new LayeredMetaDataProvider());
            generator = new ElkGraphGenerator();
        }
    }
}

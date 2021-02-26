import { Container, ContainerModule } from "inversify";
import {
    TYPES,
    defaultModule,
    boundsModule,
    fadeModule,
    viewportModule,
    selectModule,
    moveModule,
    hoverModule,
    edgeLayoutModule,
    SGraphView,
    ConsoleLogger,
    LogLevel,
    configureViewerOptions,
    configureModelElement,
    undoRedoModule,
    routingModule,
    modelSourceModule,
    openModule, zorderModule,
} from "sprotty";

import { ElkNodeView, ElkPortView, ElkEdgeView, ElkLabelView, JunctionView } from "./views";
import {ElkNode, ElkPort, ElkEdge, ElkJunction, ElkLabel, ElkGraph, SubModule} from "./model";
import {GraphModelSource} from "./model-source";
import {SvgExporter} from "./svg-exporter";
import {ExportSvgKeyListener} from "sprotty";

export default () => {
    const elkGraphModule = new ContainerModule((bind, unbind, isBound, rebind) => {
        rebind(TYPES.ILogger).to(ConsoleLogger).inSingletonScope();
        rebind(TYPES.LogLevel).toConstantValue(LogLevel.info);
        // custom svg export begin
        bind(TYPES.KeyListener).to(ExportSvgKeyListener).inSingletonScope();
        bind(TYPES.SvgExporter).to(SvgExporter).inSingletonScope();
        // custom svg export end
        bind(TYPES.ModelSource).to(GraphModelSource).inSingletonScope();
        const context = { bind, unbind, isBound, rebind };
        configureModelElement(context, 'graph', ElkGraph, SGraphView);
        configureModelElement(context, 'node', ElkNode, ElkNodeView);
        configureModelElement(context, 'submodule', SubModule, ElkNodeView);
        configureModelElement(context, 'port', ElkPort, ElkPortView);
        configureModelElement(context, 'edge', ElkEdge, ElkEdgeView);
        configureModelElement(context, 'label', ElkLabel, ElkLabelView);
        configureModelElement(context, 'junction', ElkJunction, JunctionView);
        // see defaultViewerOptions
        configureViewerOptions(context, {
            needsClientLayout: false,
            needsServerLayout: false
        });
    })
    const container = new Container();
    const modules = [
        defaultModule, modelSourceModule, boundsModule, /*buttonModule,*/
        /*commandPaletteModule, contextMenuModule, decorationModule, edgeEditModule,*/
        edgeLayoutModule, /*expandModule, exportModule,*/ fadeModule,
        hoverModule, /*labelEditModule, labelEditUiModule,*/ moveModule,
        openModule, routingModule, selectModule, undoRedoModule,
        /*updateModule, */viewportModule, zorderModule
    ];
    container.load(...modules);
    container.load(elkGraphModule);

    return container;
}

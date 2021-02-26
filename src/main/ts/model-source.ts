import {inject, injectable} from "inversify";
import {
    Action, ActionHandlerRegistry, LocalModelSource, SwitchEditModeAction,
    OpenAction, ExportSvgAction, RequestExportSvgAction, TYPES, IModelFactory, FitToScreenAction
} from "sprotty";
import {SvgExporter} from "./svg-exporter";
import {Stack} from "./stack"

@injectable()
export class GraphModelSource extends LocalModelSource {

    // @inject(TYPES.IModelFactory) modelFactory: IModelFactory;
    @inject(TYPES.SvgExporter) protected svgExporter: SvgExporter;

    private readonly renderingGraph: (graphName: string) => void;
    private lastModuleStack: Stack = new Stack();

    constructor() {
        super();
        if (typeof window.renderingGraph === "function") {
            this.renderingGraph = window.renderingGraph;
            window.reset = () => {
                if (this.lastModuleStack.size() > 1) {
                    this.lastModuleStack.clear();
                    this.setGraph('root');
                }
            }
        } else {
            this.renderingGraph = function (graphName: string) {
                alert("Please use easysoc-diagrammer plugin instead!");
            };
        }
    }

    initialize(registry: ActionHandlerRegistry): void {
        super.initialize(registry);
        registry.register(SwitchEditModeAction.KIND, this);
        registry.register(OpenAction.KIND, this)
        // registry.deregisterAll(RequestExportSvgAction.KIND);
        registry.register(RequestExportSvgAction.KIND, this);
    }

    handle(action: Action) {
        switch (action.kind) {
            case SwitchEditModeAction.KIND:
                break;
            case OpenAction.KIND:
                this.handleOpenActionAction(action as OpenAction)
                break
            case RequestExportSvgAction.KIND:
                this.handleRequestExportSvgAction(action as RequestExportSvgAction);
                break
            default:
                super.handle(action); // not possible
        }
    }

    setGraph(graphName: string): void {
        // console.info(window.graphMap)
        if (window.graphMap.has(graphName)) {
            this.setModel(window.graphMap.get(graphName));
            this.actionDispatcher.dispatch(new FitToScreenAction([]));
            this.lastModuleStack.push(graphName);
            if (typeof window.setNavigator === "function") {
                window.setNavigator(this.lastModuleStack.toString());
            }
        } else {
            this.renderingGraph(graphName);
        }
    }

    goBack() {
        if (this.lastModuleStack.size() > 1) {
            this.lastModuleStack.pop();
            let p = this.lastModuleStack.pop();
            this.setGraph(p);
        }
    }

    protected handleOpenActionAction(action: OpenAction): void {
        let noPrefix = action.elementId.slice(action.elementId.lastIndexOf("submodule_"));
        let graphId = noPrefix.split("_")
        graphId.shift();
        graphId.shift();
        const graphName  = graphId.join("_");
        this.setGraph(graphName);

        // const element = findElement(this.currentRoot, action.elementId);
        // if (element !== undefined) {
        //  const factory = this.container.get<SModelFactory>(TYPES.IModelFactory);
        //     const node = factory.createElement(element) as SubModule;
        // }
    }

    protected handleExportSvgAction(action: ExportSvgAction): void{
        // super.handleExportSvgAction(action)
        if (typeof window.saveFile === "function") {
            window.saveFile(action.svg);
        } else {
            super.handleExportSvgAction(action);
        }
    }

    protected handleRequestExportSvgAction(action: RequestExportSvgAction): void {
        this.actionDispatcher.dispatch(new FitToScreenAction([])).then(() => {
            this.svgExporter.export(action);
        });
    }
}

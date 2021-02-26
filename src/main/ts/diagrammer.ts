import 'reflect-metadata';
import {
    CenterAction,
    FitToScreenAction,
    RedoAction,
    RequestExportSvgAction, SelectAllAction, SGraphSchema, SModelRootSchema,
    TYPES,
    UndoAction
} from 'sprotty';
import createContainer from './di.config';
import {GraphModelSource} from "./model-source";
// import LZString = require('lz-string');

// import './diagram.css';

declare global {
    interface Window {
        updateModel: Function,
        renderingGraph: any,
        centerView: Function,
        fillView: Function,
        // undo: Function
        // redo: Function,
        goBack: Function,
        exportSVG: Function,
        saveFile: Function,
        reset: Function,
        setNavigator: Function,
        graphMap: Map<any, any>
    }
}

const container = createContainer();
const modelSource = container.get<GraphModelSource>(TYPES.ModelSource);

// called by java
function updateModel(graphName: string, graph: SModelRootSchema) {
    // console.info(graphName);
    // console.info(graph);

    // cache the graph data
    window.graphMap.set(graphName, graph);
    modelSource.setGraph(graphName);

    // let node = {id: 'node', type: 'node', position: {x: 100, y: 100}, size: {width: 100, height: 100}};
    // let initGraph: SGraphSchema = {id: 'graph', type: 'graph', children: [node]};
    // modelSource.setModel(initGraph);
}

function centerView() {
    modelSource.actionDispatcher.dispatch(new CenterAction([]));
}

function fillView() {
    modelSource.actionDispatcher.dispatch(new FitToScreenAction([]));
}

// function undo() {
//     modelSource.actionDispatcher.dispatch(new UndoAction());
// }
//
// function redo() {
//     modelSource.actionDispatcher.dispatch(new RedoAction());
// }

function goBack() {
    modelSource.goBack();
}

function exportSVG() {
    modelSource.actionDispatcher.dispatch(new SelectAllAction(false));
    modelSource.actionDispatcher.dispatch(new FitToScreenAction([]));
    modelSource.actionDispatcher.dispatch(RequestExportSvgAction.create());
}

window.updateModel = updateModel;
window.centerView = centerView;
window.fillView = fillView;
// window.undo = undo;
// window.redo = redo;
window.goBack = goBack;
window.exportSVG = exportSVG;
window.graphMap = new Map();

// function getQueryVariable(name: string) {
//     const url = decodeURI(location.search); // 获取url中"?"符后的字串(包括问号)
//     // let query = {};
//     if (url.indexOf("?") != -1) {
//         const str = url.substr(1);
//         const pairs = str.split("&");
//         for (let i = 0; i < pairs.length; i++) {
//             const pair = pairs[i].split("=");
//             // query[pair[0]] = pair[1];
//             if (pair[0] === name) return pair[1]; // 返回 参数值
//         }
//     }
//     return '';
// }
//
// let graphString = getQueryVariable("graph");
// if (graphString != '') {
//     const graph = LZString.decompressFromEncodedURIComponent(graphString);
//     if (graph) {
//         modelSource.setModel(JSON.parse(graph));
//         modelSource.actionDispatcher.dispatch(new FitToScreenAction([]));
//     }
// } else {
//     // let node = {id: 'node', type: 'node', position: {x: 100, y: 100}, size: {width: 100, height: 100}};
//     // let initGraph: SGraphSchema = {id: 'graph', type: 'graph', children: []};
//     // updateModel(initGraph);
// }

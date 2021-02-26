import {ExportSvgAction, ViewerOptions} from "sprotty";
import { RequestAction } from "sprotty";
import { ActionDispatcher } from "sprotty";
import { TYPES } from "sprotty";
import { EMPTY_BOUNDS } from "sprotty";
import { ILogger } from "sprotty";
import { injectable, inject } from "inversify";



@injectable()
export class SvgExporter {

    @inject(TYPES.ViewerOptions) protected options: ViewerOptions;
    @inject(TYPES.IActionDispatcher) protected actionDispatcher: ActionDispatcher;
    @inject(TYPES.ILogger) protected log: ILogger;

    export(request?: RequestAction<ExportSvgAction>): void {
        if (typeof document !== 'undefined') {
            const div = document.getElementById(this.options.baseDiv);
            if (div !== null && div.firstElementChild && div.firstElementChild.tagName === 'svg') {
                const svgElement = div.firstElementChild as SVGSVGElement;
                const svg = this.createSvg(svgElement);
                this.actionDispatcher.dispatch(new ExportSvgAction(svg, request ? request.requestId : ''));
            }
        }
    }

    protected createSvg(svgElementOrig: SVGSVGElement): string {
        const serializer = new XMLSerializer();
        const svgCopy = serializer.serializeToString(svgElementOrig);
        const iframe: HTMLIFrameElement = document.createElement('iframe');
        document.body.appendChild(iframe);
        if (!iframe.contentWindow)
            throw new Error('IFrame has no contentWindow');
        const docCopy = iframe.contentWindow.document;
        docCopy.open();
        docCopy.write(svgCopy);
        docCopy.close();
        const svgElementNew = docCopy.getElementById(svgElementOrig.id)!;
        svgElementNew.removeAttribute('opacity');
        this.copyStyles(svgElementOrig, svgElementNew, ['width', 'height', 'opacity']);
        svgElementNew.setAttribute('version', '1.1');
        let bounds =   EMPTY_BOUNDS;
        const g = svgElementNew.firstElementChild;
        if (g && g.tagName === 'g') {
            bounds = g.getBoundingClientRect();
            // g.removeAttribute('transform');
        }
        // const bounds = this.getBounds(root);
        svgElementNew.setAttribute('viewBox', `${bounds.x - 20} ${bounds.y - 20} ${bounds.width + 40} ${bounds.height + 40}`);
        svgElementNew.removeAttribute('style');
        const svgCode = serializer.serializeToString(svgElementNew);
        document.body.removeChild(iframe);
        return svgCode;
    }

    protected copyStyles(source: Element, target: Element, skipedProperties: string[]) {
        const sourceStyle = getComputedStyle(source);
        const targetStyle = getComputedStyle(target);
        let diffStyle = '';
        for (let i = 0; i < sourceStyle.length; i++) {
            const key = sourceStyle[i];
            if (skipedProperties.indexOf(key) === -1) {
                const value = sourceStyle.getPropertyValue(key);
                if (targetStyle.getPropertyValue(key) !== value) {
                    diffStyle += key + ":" + value + ";";
                }
            }
        }
        if (diffStyle !== '')
            target.setAttribute('style', diffStyle);
        // 必须将样式内联？这样会增加文件大小
        target.removeAttribute('class');
        target.removeAttribute('id');

        // IE doesn't retrun anything on source.children
        for (let i = 0; i < source.childNodes.length; ++i) {
            const sourceChild = source.childNodes[i];
            const targetChild = target.childNodes[i];
            if (sourceChild instanceof Element)
                this.copyStyles(sourceChild, targetChild as Element, []);
        }
    }

    // protected getBounds(root: SModelRoot) {
    //     const allBounds: Bounds[] = [ EMPTY_BOUNDS ];
    //     root.children.forEach(element => {
    //         if (isBoundsAware(element)) {
    //             allBounds.push(element.bounds);
    //         }
    //     });
    //     return allBounds.reduce((one, two) => combine(one, two));
    // }
}

/** @jsx svg */
import { svg } from 'snabbdom-jsx';

import { injectable } from "inversify";
import { VNode } from "snabbdom/vnode";
import {
    RenderingContext, SEdge, IView, PolylineEdgeView, RectangularNodeView, CircularNodeView,
    Point, toDegrees, SLabel, angleOfPoint
} from "sprotty";
import { ElkNode, ElkPort, ElkJunction } from "./model";

@injectable()
export class ElkNodeView extends RectangularNodeView {
    render(node: ElkNode, context: RenderingContext): VNode {
        return <g>
            <rect class-elknode={true} class-mouseover={node.hoverFeedback} class-selected={node.selected}
                    x="0" y="0" width={node.bounds.width} height={node.bounds.height}></rect>
            { context.renderChildren(node) }
        </g>;
    }
}

@injectable()
export class ElkPortView extends RectangularNodeView {
    render(port: ElkPort, context: RenderingContext): VNode {
        return <g>
            <rect class-elkport={true} class-mouseover={port.hoverFeedback} class-selected={port.selected}
                    x="0" y="0" width={port.bounds.width} height={port.bounds.height}></rect>
            { context.renderChildren(port) }
        </g>;
    }
}

@injectable()
export class ElkEdgeView extends PolylineEdgeView {
    protected renderLine(edge: SEdge, segments: Point[], context: RenderingContext): VNode {
        const firstPoint = segments[0];
        let path = `M ${firstPoint.x},${firstPoint.y}`;
        for (let i = 1; i < segments.length; i++) {
            const p = segments[i];
            path += ` L ${p.x},${p.y}`;
        }
        return <path class-elkedge={true} d={path} class-mouseover={edge.hoverFeedback} class-selected={edge.selected} />;
    }

    protected renderAdditionals(edge: SEdge, segments: Point[], context: RenderingContext): VNode[] {
        const p1 = segments[segments.length - 2];
        const p2 = segments[segments.length - 1];
        return [
            <path class-elkedge={true} class-arrow={true} d="M 0,0 L 8,-3 L 8,3 Z"
                  transform={`rotate(${toDegrees(angleOfPoint({ x: p1.x - p2.x, y: p1.y - p2.y }))} ${p2.x} ${p2.y}) translate(${p2.x} ${p2.y})`}/>
        ];
    }
}

@injectable()
export class ElkLabelView implements IView {
    render(label: SLabel, context: RenderingContext): VNode {
        return <text class-elklabel={true}>{label.text}</text>;
    }
}

@injectable()
export class JunctionView extends CircularNodeView {
    render(node: ElkJunction, context: RenderingContext): VNode {
        const radius = this.getRadius(node);
        return <g>
            <circle class-elkjunction={true} r={radius}></circle>
        </g>;
    }

    protected getRadius(node: ElkJunction): number {
        return 2;
    }
}

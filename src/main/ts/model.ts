import {
    SNode, RectangularNode, RectangularPort, SEdge, SGraph, SLabel
} from "sprotty";
import {connectableFeature, selectFeature, hoverFeedbackFeature, boundsFeature, layoutContainerFeature,
    fadeFeature, viewportFeature, exportFeature, alignFeature, layoutableChildFeature, edgeLayoutFeature,
    openFeature
} from "sprotty";

// class SModelElement
// class SParentElement extends SModelElement
// class SChildElement extends SParentElement

// abstract class SShapeElement extends SChildElement implements BoundsAware, Locateable, LayoutableChild
// abstract class SConnectableElement extends SShapeElement implements Connectable
// class SNode extends SConnectableElement implements Selectable, Fadeable, Hoverable

// abstract class SRoutableElement extends SChildElement
// class SEdge extends SRoutableElement implements Fadeable, Selectable, Hoverable, BoundsAware

// class SModelRoot extends SParentElement
// class ViewportRootElement extends SModelRoot implements Viewport
// class SGraph extends ViewportRootElement

// class SLabel extends SShapeElement implements Selectable, Alignable, Fadeable

export class ElkGraph extends SGraph {
    static readonly DEFAULT_FEATURES = [viewportFeature, exportFeature];
}

export class ElkNode extends RectangularNode {
    static readonly DEFAULT_FEATURES = [connectableFeature, selectFeature, boundsFeature,
         layoutContainerFeature, fadeFeature, hoverFeedbackFeature];

}

export class SubModule extends ElkNode {
    static readonly DEFAULT_FEATURES = [connectableFeature, selectFeature, boundsFeature,
        layoutContainerFeature, fadeFeature, hoverFeedbackFeature, openFeature];

}

export class ElkPort extends RectangularPort {
    static readonly DEFAULT_FEATURES = [connectableFeature, selectFeature, boundsFeature,
        layoutContainerFeature, fadeFeature, hoverFeedbackFeature];
}

export class ElkEdge extends SEdge {
    static readonly DEFAULT_FEATURES = [selectFeature, fadeFeature,
        hoverFeedbackFeature];
}

export class ElkLabel extends SLabel {
    static readonly DEFAULT_FEATURES = [boundsFeature, alignFeature, layoutableChildFeature,
        edgeLayoutFeature, fadeFeature];
}

export class ElkJunction extends SNode {
    static readonly DEFAULT_FEATURES = [connectableFeature, boundsFeature,
        layoutContainerFeature, fadeFeature];
}

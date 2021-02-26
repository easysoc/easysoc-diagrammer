
package org.easysoc.plugins.diagrammer.graph;

import org.eclipse.elk.core.IGraphLayoutEngine;
import org.eclipse.elk.core.RecursiveGraphLayoutEngine;
import org.eclipse.elk.core.math.KVector;
import org.eclipse.elk.core.math.KVectorChain;
import org.eclipse.elk.core.options.CoreOptions;
import org.eclipse.elk.core.util.BasicProgressMonitor;
import org.eclipse.elk.graph.*;
import org.eclipse.elk.graph.util.ElkGraphUtil;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.sprotty.*;
import org.eclipse.xtext.xbase.lib.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Transforms ELK graphs into sprotty models to be transferred to clients.
 */
@SuppressWarnings("all")
public class ElkGraphGenerator {

  private final IGraphLayoutEngine layoutEngine = new RecursiveGraphLayoutEngine();
  
  private int defaultPortSize = 5;
  private int defaultNodeSize = 30;
  
  public SGraph generate(String graph) {
    final ElkNode elkGraph = loadElkGraph(graph,"elkt");
    if (elkGraph != null) {
      try {
        applyDefaults(elkGraph);
        ElkNode laidOutGraph = null;
        {
          BasicProgressMonitor _basicProgressMonitor = new BasicProgressMonitor();
          layoutEngine.layout(elkGraph, _basicProgressMonitor);
          laidOutGraph = elkGraph;
        }
        
        final SGraph sgraph = new SGraph();
        sgraph.setType("graph");
        sgraph.setId("graph");
        processContent(laidOutGraph, sgraph);
        return sgraph;
      } catch (final Throwable _t) {
        if (_t instanceof RuntimeException) {
          final RuntimeException exc = (RuntimeException)_t;
          return showError(exc);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
    return null;
  }

  private ElkNode loadElkGraph(final String graph, final String format) {
    try {
      final Resource r = new ResourceSetImpl().createResource(URI.createURI(("dummy." + format)));
      URIConverter.ReadableInputStream _readableInputStream = new URIConverter.ReadableInputStream(graph, "UTF-8");
      r.load(_readableInputStream, null);
      EObject _head = IterableExtensions.<EObject>head(r.getContents());
      final ElkNode elkGraph = (ElkNode) _head;
      boolean _isEmpty = r.getErrors().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        EList<Resource.Diagnostic> _errors = r.getErrors();
        throw new ImportExportException(_errors);
      }
      return elkGraph;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Transform all content of the given parent node.
   */
  protected void processContent(final ElkNode parent, final SModelElement container) {
    EList<ElkPort> _ports = parent.getPorts();
    for (final ElkPort elkPort : _ports) {
      {
        final SPort sport = new SPort();
        sport.setType("port");
        sport.setId(getId(elkPort));
        transferBounds(elkPort, sport);
        addChild(container, sport);
        processLabels(elkPort, sport);
      }
    }
    EList<ElkNode> _children = parent.getChildren();
    for (final ElkNode elkNode : _children) {
      {
        final SNode snode = new SNode();
        snode.setType(elkNode.getIdentifier().startsWith("submodule")? "submodule" : "node");
        snode.setId(getId(elkNode));
        transferBounds(elkNode, snode);
        addChild(container, snode);
        processLabels(elkNode, snode);
        processContent(elkNode, snode);
      }
    }
    EList<ElkEdge> _containedEdges = parent.getContainedEdges();
    for (final ElkEdge elkEdge : _containedEdges) {
      if (((elkEdge.getSources().size() == 1) && (elkEdge.getTargets().size() == 1))) {
        final SEdge sedge = new SEdge();
        sedge.setType("edge");
        sedge.setId(getId(elkEdge));
        sedge.setSourceId(getId(IterableExtensions.<ElkConnectableShape>head(elkEdge.getSources())));
        sedge.setTargetId(getId(IterableExtensions.<ElkConnectableShape>head(elkEdge.getTargets())));
        transferEdgeLayout(elkEdge, sedge);
        addChild(container, sedge);
        processLabels(elkEdge, sedge);
      } else {
        EList<ElkConnectableShape> _sources = elkEdge.getSources();
        for (final ElkConnectableShape source : _sources) {
          EList<ElkConnectableShape> _targets = elkEdge.getTargets();
          for (final ElkConnectableShape target : _targets) {
            {
              final SEdge sedge_1 = new SEdge();
              sedge_1.setType("edge");
              String _id = getId(elkEdge);
              String _plus = (_id + "_");
              String _id_1 = getId(source);
              String _plus_1 = (_plus + _id_1);
              String _plus_2 = (_plus_1 + "_");
              String _id_2 = getId(target);
              String _plus_3 = (_plus_2 + _id_2);
              sedge_1.setId(_plus_3);
              sedge_1.setSourceId(getId(source));
              sedge_1.setTargetId(getId(target));
              transferEdgeLayout(elkEdge, sedge_1);
              addChild(container, sedge_1);
              processLabels(elkEdge, sedge_1);
            }
          }
        }
      }
    }
  }
  
  /**
   * Transform all labels of the given graph element.
   */
  protected void processLabels(final ElkGraphElement element, final SModelElement container) {
    EList<ElkLabel> _labels = element.getLabels();
    for (final ElkLabel elkLabel : _labels) {
      {
        final SLabel slabel = new SLabel();
        slabel.setType("label");
        slabel.setId(getId(elkLabel));
        slabel.setText(elkLabel.getText());
        transferBounds(elkLabel, slabel);
        addChild(container, slabel);
        processLabels(elkLabel, slabel);
      }
    }
  }
  
  /**
   * Apply default layout information to all contents of the given parent node.
   */
  private void applyDefaults(final ElkNode parent) {
    EList<ElkPort> _ports = parent.getPorts();
    for (final ElkPort port : _ports) {
      {
        double _width = port.getWidth();
        boolean _lessEqualsThan = (_width <= 0);
        if (_lessEqualsThan) {
          port.setWidth(defaultPortSize);
        }
        double _height = port.getHeight();
        boolean _lessEqualsThan_1 = (_height <= 0);
        if (_lessEqualsThan_1) {
          port.setHeight(defaultPortSize);
        }
        computeLabelSizes(port);
      }
    }

    EList<ElkNode> _children = parent.getChildren();
    for (final ElkNode node : _children) {
      {
        double _width = node.getWidth();
        boolean _lessEqualsThan = (_width <= 0);
        if (_lessEqualsThan) {
          node.setWidth(defaultNodeSize);
        }
        double _height = node.getHeight();
        boolean _lessEqualsThan_1 = (_height <= 0);
        if (_lessEqualsThan_1) {
          node.setHeight(defaultNodeSize);
        }
        computeLabelSizes(node);
        applyDefaults(node);
      }
    }

    final ArrayList<ElkEdge> fixEdges = CollectionLiterals.<ElkEdge>newArrayList();
    EList<ElkEdge> _containedEdges = parent.getContainedEdges();
    for (final ElkEdge edge : _containedEdges) {
      final ElkNode bestContainer = ElkGraphUtil.findBestEdgeContainment(edge);
      if (((bestContainer != null) && (bestContainer != parent))) {
        fixEdges.add(edge);
      }
//      computeLabelSizes(edge);
    }
    for (final ElkEdge edge : fixEdges) {
      ElkGraphUtil.updateContainment(edge);
    }
  }
  
  /**
   * Compute sizes for all labels of an element. <em>Note:</em> Sizes are hard-coded here, so don't expect
   * the result to be rendered properly on all clients!
   */
  private void computeLabelSizes(final ElkGraphElement element) {
    EList<ElkLabel> _labels = element.getLabels();
    for (final ElkLabel label : _labels) {
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(label.getText());
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        double _width = label.getWidth();
        boolean _lessEqualsThan = (_width <= 0);
        if (_lessEqualsThan) {
          int _length = label.getText().length();
          int _multiply = (_length * 9);
          label.setWidth(_multiply);
        }
        double _height = label.getHeight();
        boolean _lessEqualsThan_1 = (_height <= 0);
        if (_lessEqualsThan_1) {
          label.setHeight(16);
        }
      }
    }
  }
  
  /**
   * Add a child element to the sprotty model.
   */
  private void addChild(final SModelElement container, final SModelElement child) {
    List<SModelElement> _children = container.getChildren();
    boolean _tripleEquals = (_children == null);
    if (_tripleEquals) {
      container.setChildren(CollectionLiterals.<SModelElement>newArrayList());
    }
    container.getChildren().add(child);
  }
  
  /**
   * Transfer bounds to a sprotty model element.
   */
  private void transferBounds(final ElkShape shape, final BoundsAware bounds) {
    double _x = shape.getX();
    double _y = shape.getY();
    Point _point = new Point(_x, _y);
    bounds.setPosition(_point);
    if (((shape.getWidth() > 0) || (shape.getHeight() > 0))) {
      double _width = shape.getWidth();
      double _height = shape.getHeight();
      Dimension _dimension = new Dimension(_width, _height);
      bounds.setSize(_dimension);
    }
  }
  
  /**
   * Transfer an edge layout to a sprotty edge.
   */
  private void transferEdgeLayout(final ElkEdge elkEdge, final SEdge sEdge) {
    sEdge.setRoutingPoints(CollectionLiterals.<Point>newArrayList());
    EList<ElkEdgeSection> _sections = elkEdge.getSections();
    for (final ElkEdgeSection section : _sections) {
      {
        List<Point> _routingPoints = sEdge.getRoutingPoints();
        double _startX = section.getStartX();
        double _startY = section.getStartY();
        Point _point = new Point(_startX, _startY);
        _routingPoints.add(_point);
        EList<ElkBendPoint> _bendPoints = section.getBendPoints();
        for (final ElkBendPoint bendPoint : _bendPoints) {
          List<Point> _routingPoints_1 = sEdge.getRoutingPoints();
          double _x = bendPoint.getX();
          double _y = bendPoint.getY();
          Point _point_1 = new Point(_x, _y);
          _routingPoints_1.add(_point_1);
        }
        List<Point> _routingPoints_2 = sEdge.getRoutingPoints();
        double _endX = section.getEndX();
        double _endY = section.getEndY();
        Point _point_2 = new Point(_endX, _endY);
        _routingPoints_2.add(_point_2);
      }
    }
    final KVectorChain junctionPoints = elkEdge.<KVectorChain>getProperty(CoreOptions.JUNCTION_POINTS);
    final Procedures.Procedure2<KVector, Integer> _function = (KVector point, Integer index) -> {
      final SNode sJunction = new SNode();
      sJunction.setType("junction");
      String _id = getId(elkEdge);
      String _plus = (_id + "_j");
      String _plus_1 = (_plus + index);
      sJunction.setId(_plus_1);
      Point _point = new Point(point.x, point.y);
      sJunction.setPosition(_point);
      addChild(sEdge, sJunction);
    };
    IterableExtensions.<KVector>forEach(junctionPoints, _function);
  }
  
  /**
   * Compute a unique identifier for the given element.
   */
  private String getId(final ElkGraphElement element) {
    final EObject container = element.eContainer();
    if ((container instanceof ElkGraphElement)) {
      String identifier = element.getIdentifier();
      if ((identifier == null)) {
        final EStructuralFeature feature = element.eContainingFeature();
        Object _eGet = ((ElkGraphElement)container).eGet(feature);
        final List<? extends ElkGraphElement> list = ((List<? extends ElkGraphElement>) _eGet);
        String _name = feature.getName();
        String _plus = (_name + "#");
        int _indexOf = list.indexOf(element);
        String _plus_1 = (_plus + Integer.valueOf(_indexOf));
        identifier = _plus_1;
      }
      String _id = getId(((ElkGraphElement)container));
      String _plus_2 = (_id + ".");
      return (_plus_2 + identifier);
    } else {
      String _elvis = null;
      String _identifier = element.getIdentifier();
      if (_identifier != null) {
        _elvis = _identifier;
      } else {
        _elvis = "graph";
      }
      return _elvis;
    }
  }
  
  private SGraph showError(final Throwable throwable) {
    final SGraph sgraph = new SGraph();
    sgraph.setType("graph");
    final SLabel label = new SLabel();
    label.setType("label");
    label.setId("error");
    String _simpleName = throwable.getClass().getSimpleName();
    String _plus = (_simpleName + ": ");
    String _message = throwable.getMessage();
    String _plus_1 = (_plus + _message);
    label.setText(_plus_1);
    Point _point = new Point(20, 20);
    label.setPosition(_point);
    addChild(sgraph, label);
    return sgraph;
  }
  
  public void setDefaultPortSize(final int defaultPortSize) {
    this.defaultPortSize = defaultPortSize;
  }
  
  public void setDefaultNodeSize(final int defaultNodeSize) {
    this.defaultNodeSize = defaultNodeSize;
  }

  public class ImportExportException extends Exception {
    private final List<Resource.Diagnostic> diagnostics;

    public ImportExportException(final List<Resource.Diagnostic> diagnostics) {
      super();
      this.diagnostics = diagnostics;
    }
  }
}

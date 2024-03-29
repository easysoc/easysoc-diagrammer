## EasySoC Diagrammer

**Note1:** This project is suitable for viewing the connection relationship between circuit modules at a **high** level. If a module is too detailed, such as containing thousands of primitive operations, it is meaningless to visualize such a module, and it will take a lot of time and resources to render the graph.

**Note2:** In addition to layout the graph through various [algorithms](https://www.eclipse.org/elk/reference/algorithms.html), the generated graph file can be consumed by [ELK](https://search.maven.org/artifact/org.eclipse.elk/org.eclipse.elk.graph.text/0.7.1/eclipse-plugin) to create a corresponding graph [data structure](https://www.eclipse.org/elk/documentation/tooldevelopers/graphdatastructure.html), and circuit analysis can be performed based on the graph.

![](./images/diagrammer.png)

## Features

- Go to Top module
- Double-click go to submodule
- Go back
- Center selection, or if nothing is selected center the entire diagram
- Zoom selection to fill the entire canvas, or if nothing is selected zoom the entire diagram
- Export diagram to SVG
- Highlight selected elements

## FAQs

1. How to view the graph file

    After generating graph files by [easysoc-firrtl](https://github.com/easysoc/easysoc-firrtl), when you open a `.graph` file or right-click on it, menu 

    `HDL->Rendering the Graph Interactively` becomes available. 

    When opening the graph for the first time, some initialization work is required. After that, the rendering of the graph will be very fast.

2. How to view the exported SVG file

    The rendering effect of the diagram is mainly adapted to Chrome browser, other SVG viewers may see inconsistent effects. It is recommended to use Chrome browser and [SVG Navigator plugin](https://chrome.google.com/webstore/detail/svg-navigator/pefngfjmidahdaahgehodmfodhhhofkl) to see the SVG file.


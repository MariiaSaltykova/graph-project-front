package com.project.graphApp.graph.controller;

import com.project.graphApp.graph.model.Graph;
import com.project.graphApp.graph.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Umożliwia dostęp z dowolnego źródła (przydatne przy łączeniu z frontendem)
public class GraphController {

    @Autowired
    private GraphService graphService;

    // @PostMapping("/generateGraph")
    // public Graph generateGraph(@RequestBody GraphRequest graphRequest) {
    //     return graphService.generateGraph(graphRequest);
    // }
    @PostMapping("/generateGraph")
    public Graph generateGraph(@RequestBody GraphRequest graphRequest) {
    System.out.println("Otrzymano dane: " + graphRequest);
    return graphService.generateGraph(graphRequest);
}
}

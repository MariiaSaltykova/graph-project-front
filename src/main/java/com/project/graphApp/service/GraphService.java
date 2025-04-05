package com.project.graphApp.graph.service;

import com.project.graphApp.graph.factory.GraphFactory;
import com.project.graphApp.graph.model.Graph;
import com.project.graphApp.graph.controller.GraphRequest;
import org.springframework.stereotype.Service;

@Service
public class GraphService {

    public Graph generateGraph(GraphRequest request) {
        // Tutaj można dodać dodatkową walidację lub logikę przetwarzania
        return GraphFactory.createGraph(request);
    }
}

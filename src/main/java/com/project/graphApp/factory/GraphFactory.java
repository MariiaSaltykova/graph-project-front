package com.project.graphApp.graph.factory;

import com.project.graphApp.graph.model.Graph;
import com.project.graphApp.graph.model.UnweightedGraph;
import com.project.graphApp.graph.model.WeightedGraph;
import com.project.graphApp.graph.controller.GraphRequest;

public class GraphFactory {

    public static Graph createGraph(GraphRequest request) {
        // W zależności od parametru 'weighted' tworzymy odpowiedni obiekt
        if (request.isWeighted()) {
            return new WeightedGraph(
                    request.getVertices(),
                    request.getEdges(),
                    request.getMinWeight(),
                    request.getMaxWeight(),
                    request.getWeightType(),
                    request.getEndpoint()
            );
        } else {
            return new UnweightedGraph(
                    request.getVertices(),
                    request.getEdges(),
                    request.getEndpoint()
            );
        }
    }
}

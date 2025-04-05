package com.project.graphApp.graph.model;

public class UnweightedGraph implements Graph {
    private int vertices;
    private int edges;
    private int endpoint;

    public UnweightedGraph(int vertices, int edges, int endpoint) {
        this.vertices = vertices;
        this.edges = edges;
        this.endpoint = endpoint;
        generate();
    }

    @Override
    public void generate() {
        // Logika generowania grafu nieważonego
        System.out.println("Generowanie grafu nieważonego...");
    }

    @Override
    public String getInfo() {
        return "Graf nieważony: " + vertices + " wierzchołków, " + edges + " krawędzi, endpoint: " + endpoint;
    }
}

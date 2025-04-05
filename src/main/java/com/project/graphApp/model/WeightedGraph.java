package com.project.graphApp.graph.model;

public class WeightedGraph implements Graph {
    private int vertices;
    private int edges;
    private double minWeight;
    private double maxWeight;
    private String weightType;
    private int endpoint;

    public WeightedGraph(int vertices, int edges, double minWeight, double maxWeight, String weightType, int endpoint) {
        this.vertices = vertices;
        this.edges = edges;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.weightType = weightType;
        this.endpoint = endpoint;
        generate();
    }

    @Override
    public void generate() {
        // Logika generowania grafu ważonego
        System.out.println("Generowanie grafu ważonego...");
    }

    @Override
    public String getInfo() {
        return "Graf ważony: " + vertices + " wierzchołków, " + edges + " krawędzi, wagi: " + minWeight + "-" + maxWeight +
                " (" + weightType + "), endpoint: " + endpoint;
    }
}

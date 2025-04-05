package com.project.graphApp.graph.controller;

public class GraphRequest {
    private boolean weighted;
    private boolean directed;
    private int vertices;
    private int edges;
    private Double minWeight;
    private Double maxWeight;
    private String weightType;
    private int endpoint;

    // Gettery i settery
    public boolean isWeighted() {
        return weighted;
    }
    public void setWeighted(boolean weighted) {
        this.weighted = weighted;
    }
    public boolean isDirected() {
        return directed;
    }
    public void setDirected(boolean directed) {
        this.directed = directed;
    }
    public int getVertices() {
        return vertices;
    }
    public void setVertices(int vertices) {
        this.vertices = vertices;
    }
    public int getEdges() {
        return edges;
    }
    public void setEdges(int edges) {
        this.edges = edges;
    }
    public Double getMinWeight() {
        return minWeight;
    }
    public void setMinWeight(Double minWeight) {
        this.minWeight = minWeight;
    }
    public Double getMaxWeight() {
        return maxWeight;
    }
    public void setMaxWeight(Double maxWeight) {
        this.maxWeight = maxWeight;
    }
    public String getWeightType() {
        return weightType;
    }
    public void setWeightType(String weightType) {
        this.weightType = weightType;
    }
    public int getEndpoint() {
        return endpoint;
    }
    public void setEndpoint(int endpoint) {
        this.endpoint = endpoint;
    }
}

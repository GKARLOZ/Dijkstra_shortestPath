package Dijkstra_shortestPath.Version1;

import java.util.ArrayList;

public class Vertex {

    private String data;
    private ArrayList<Edge> edges;

    public Vertex(String inputData) {
        this.data = inputData;
        this.edges = new ArrayList<>();
    }

    public void addEdge(Vertex endVertex, Integer weight) {

        this.edges.add(new Edge(this, endVertex, weight));
    }

    public void removeEdge(Vertex endVertex) {
        this.edges.removeIf(edge -> edge.getEnd().equals(endVertex));
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

    public ArrayList<Edge> getEdges(){
        return this.edges;
    }

    @Override
    public String toString() {
        return "Dijkstra_shortestPath.Version1.Vertex{" +
                "data='" + data + '\'' +
                ", edges=" + edges +
                '}';
    }
}

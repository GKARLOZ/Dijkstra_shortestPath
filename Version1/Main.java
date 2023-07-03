package Dijkstra_shortestPath.Version1;

import java.util.Dictionary;

public class Main {

    public static void main(String[] args) {
        createGraph();
    }

        public static void createGraph(){


        // Create a weighted directed graph
        Graph graph = new Graph(true, true);

        // Represent Locations
        Vertex v1 = graph.addVertex("v1");
        Vertex v2 = graph.addVertex("v2");
        Vertex v3 = graph.addVertex("v3");
        Vertex v4 = graph.addVertex("v4");
        Vertex v5 = graph.addVertex("v5");
        Vertex v6 = graph.addVertex("v6");

        // Represent Routes
        graph.addEdge(v1, v2, 4);
        graph.addEdge(v1, v3, 1);
        graph.addEdge(v2, v4, 2);
        graph.addEdge(v3, v2, 1);
        graph.addEdge(v3, v4, 2);
        graph.addEdge(v4, v5, 1);
        graph.addEdge(v5, v6, 2);
        graph.addEdge(v2, v5, 1);


        Vertex startingLocation = v1;
        Vertex endingLocation = v6;


        // Dijkstra_shortestPath.Version1.Dijkstra's algorithm
        Dictionary[] result = Dijkstra.findAllShortestPath(graph, startingLocation);
        Dictionary<String, Integer> distances = result[0];
        Dictionary<String, Vertex> previous = result[1];


        int distanceToDestination = distances.get("v6");
        System.out.println("Shortest distance from " + startingLocation.getData() +" to "+ endingLocation.getData() +": " + distanceToDestination);
        System.out.print("Path: ");
        Dijkstra.printPath(previous, endingLocation);
        System.out.println();


    }
}

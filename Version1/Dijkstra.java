package Dijkstra_shortestPath.Version1;

import java.util.*;

public class Dijkstra {

    public static Dictionary[] findAllShortestPath(Graph g, Vertex startingVertex){
        Dictionary<String, Integer> distances = new Hashtable<>();
        Dictionary<String, Vertex> previous = new Hashtable<>();
        PriorityQueue<QueueObject> queue = new PriorityQueue<>();

        distances.put(startingVertex.getData(), 0);
        QueueObject qo = new QueueObject(startingVertex, 0);
        queue.add(qo);

        for (Vertex v: g.getVertices()) {
            if(v != startingVertex){
                distances.put(v.getData(), Integer.MAX_VALUE);

            }
            previous.put(v.getData(), new Vertex("Null"));
        }

        while(queue.size() != 0){
            Vertex currentVertex = queue.poll().getVertex();

            for (Edge e: currentVertex.getEdges()) {
                Integer alternate = distances.get(currentVertex.getData()) + e.getWeight();
                String neighborData = e.getEnd().getData();

                if (alternate < distances.get(neighborData)){
                    distances.put(neighborData, alternate);
                    previous.put(neighborData, currentVertex);
                    queue.add(new QueueObject(e.getEnd(), distances.get(neighborData)));

                }
            }
        }

        return new Dictionary[]{distances, previous};
    }

    public static void printPath(Dictionary<String, Vertex> previous, Vertex destination) {
        if (!destination.getData().equals("Null")) {
            Vertex previousVertex = previous.get(destination.getData());
            printPath(previous, previousVertex);
            System.out.print(" -> " + destination.getData());
        }
    }



}

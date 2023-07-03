package Dijkstra_shortestPath.Version1;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.PriorityQueue;

public class testingDijk {
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

    public class Graph {

        private ArrayList<Vertex> vertices;
        private boolean isWeighted;
        private boolean isDirected;

        public Graph(boolean inputIsWeighted, boolean inputIsDirected) {
            this.vertices = new ArrayList<Vertex>();
            this.isWeighted = inputIsWeighted;
            this.isDirected = inputIsDirected;
        }

        public Vertex addVertex(String data) {
            Vertex newVertex = new Vertex(data);
            this.vertices.add(newVertex);
            return newVertex;
        }

        public void addEdge(Vertex vertex1, Vertex vertex2, Integer weight) {
            if (!this.isWeighted) {
                weight = null;
            }
            vertex1.addEdge(vertex2, weight);
            if (!this.isDirected) {
                vertex2.addEdge(vertex1, weight);
            }
        }

        public void removeEdge(Vertex vertex1, Vertex vertex2) {
            vertex1.removeEdge(vertex2);

            if (!this.isDirected) {
                vertex2.removeEdge(vertex1);
            }
        }

        public void removeVertex(Vertex vertex) {
            this.vertices.remove(vertex);
        }

        public ArrayList<Vertex> getVertices() {
            return this.vertices;
        }

        public boolean isWeighted() {
            return this.isWeighted;
        }

        public boolean isDirected() {
            return this.isDirected;
        }

        public Vertex getVertexByValue(String value) {
            for(Vertex v: this.vertices) {
                if (v.getData() == value) {
                    return v;
                }
            }

            return null;
        }

        public void print() {
            for(Vertex v: this.vertices) {
                //v.print(isWeighted);
                System.out.println(isWeighted);
            }
        }

    }



}

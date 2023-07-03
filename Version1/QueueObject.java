package Dijkstra_shortestPath.Version1;

public class QueueObject implements  Comparable<QueueObject>{

        private Vertex vertex;
        private int distance;

    public QueueObject(Vertex vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    public Vertex getVertex() {
        return vertex;
    }

    public void setVertex(Vertex vertex) {
        this.vertex = vertex;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public int compareTo(QueueObject o) {

        return Integer.compare(this.distance, o.distance);
    }

    @Override
    public String toString() {
        return "Dijkstra_shortestPath.Version1.QueueObject{" +
                "vertex=" + vertex.getData() +
//                ", distance=" + distance +
                '}';
    }
}

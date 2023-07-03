package Dijkstra_shortestPath.Version2.Navigator;

import Dijkstra_shortestPath.Version2.Model.Location;

public class QueueObject implements  Comparable<QueueObject>{

        private Location vertex;
        private Long duration;

    public QueueObject(Location vertex, Long duration) {
        this.vertex = vertex;
        this.duration = duration;
    }

    public Location getVertex() {
        return vertex;
    }

    public void setVertex(Location vertex) {
        this.vertex = vertex;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    @Override
    public int compareTo(QueueObject o) {

        return Long.compare(this.duration, o.duration);
    }

    @Override
    public String toString() {
        return "Dijkstra_shortestPath.Version1.QueueObject{" +
                "vertex=" + vertex.getName() +
                '}';
    }
}

package Dijkstra_shortestPath.Version2.Navigator;

import Dijkstra_shortestPath.Version2.Model.Location;
import Dijkstra_shortestPath.Version2.Model.Route;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.PriorityQueue;

public class Dijkstra {

    public static Dictionary[] findAllShortestPath(Graph g, Location startlocation){
        Dictionary<String, Long> distances = new Hashtable<>();
        Dictionary<String, Location> previous = new Hashtable<>();
        PriorityQueue<QueueObject> queue = new PriorityQueue<>();


        distances.put(startlocation.getName(), 0L);
        QueueObject qo = new QueueObject(startlocation, 0L);
        queue.add(qo);

        for (Location v: g.getLocations()) {
            if(v != startlocation){
                distances.put(v.getName(), Long.MAX_VALUE);

            }
            previous.put(v.getName(), new Location("Null"));
        }

        while(queue.size() != 0){
            Location currentLocation = queue.poll().getVertex();

            for (Route e: currentLocation.getRoutes()) {
                Long alternate = distances.get(currentLocation.getName()) + e.getDuration();
                String neighborData = e.getLocationB().getName();

                if (alternate < distances.get(neighborData)){
                    distances.put(neighborData, alternate);
                    previous.put(neighborData, currentLocation);
                    queue.add(new QueueObject(e.getLocationB(), distances.get(neighborData)));

                }
            }
        }

        return new Dictionary[]{distances, previous};
    }

    public static void printPathWithTransportation(Dictionary<String,Location> previous, Location destination) {

        if (!destination.getName().equals("Null")) {
            Location previousLocation = previous.get(destination.getName());
            printPathWithTransportation(previous, previousLocation);
            for(Route r: previousLocation.getRoutes()){
                if(r.getLocationB().getName() == destination.getName()) {
                    System.out.print(" --| " + r.getTransportationId().getName()+" (" + r.getDuration()+") |--> "+ destination.getName());
                    return;
                }

            }
            System.out.print(" -> " + destination.getName());

        }
    }

    public static void printPath(Dictionary<String,Location> previous, Location destination) {
        if (!destination.getName().equals("Null")) {
            Location previousVertex = previous.get(destination.getName());
            printPath(previous, previousVertex);
            System.out.print(" -> " + destination.getName());
        }
    }



}

package Dijkstra_shortestPath.Version2;
import Dijkstra_shortestPath.Version2.Navigator.*;
import Dijkstra_shortestPath.Version2.Model.*;

import java.util.Dictionary;

public class Main {

    public static void main(String[] args) {

        createNavigator();

           }

    public static void createNavigator(){

        Graph graph = new Graph(true, true);

        Location LA = graph.addLocation("Los Angeles");
        Location LV = graph.addLocation("Los Vegas");
        Location NY = graph.addLocation("New York");
        Location SF = graph.addLocation("San Fransisco");
        Location Bro = graph.addLocation("Brooklyn");
        Location Ho = graph.addLocation("Hobart");
        Location Mi = graph.addLocation("Miami");
        Location Sea = graph.addLocation("Seattle");

        Transportation bus = new Transportation("Bus");
        Transportation train = new Transportation("Train");
        Transportation plane = new Transportation("Plane");


        graph.addRoute(LA,LV,3L,bus);
        graph.addRoute(LA,SF,8L,train);
        graph.addRoute(SF,LV,7L,train);
        graph.addRoute(LV,NY,50L,plane);
        graph.addRoute(NY,Bro,3L,bus);
        graph.addRoute(Bro,Ho,8L,train);
        graph.addRoute(Ho,Mi,7L,train);
        graph.addRoute(Mi,Sea,50L,plane);


        Location startingLocation = LA;
        Location endingLocation = Ho;

        Dictionary[] result = Dijkstra.findAllShortestPath(graph, startingLocation);
        Dictionary<String, Long> duration = result[0];
        Dictionary<String, Location> previous = result[1];

        Long durationToDestination = duration.get("Hobart");
        System.out.println("Shortest distance from " + startingLocation.getName() +" to "+ endingLocation.getName() +": " + durationToDestination);
        System.out.print("Path: ");
        Dijkstra.printPathWithTransportation(previous, endingLocation);
        System.out.println();




    }



}

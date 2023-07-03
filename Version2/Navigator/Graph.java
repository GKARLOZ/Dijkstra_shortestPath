package Dijkstra_shortestPath.Version2.Navigator;

import Dijkstra_shortestPath.Version2.Model.Location;
import Dijkstra_shortestPath.Version2.Model.Transportation;

import java.util.ArrayList;

public class Graph {

        private ArrayList<Location> locations;
        private boolean isWeighted;
        private boolean isDirected;


        public Graph(boolean inputIsWeighted, boolean inputIsDirected) {
            this.locations = new ArrayList<Location>();
            this.isWeighted = inputIsWeighted;
            this.isDirected = inputIsDirected;
        }

        public Location addLocation(String data) {
            Location newLocation = new Location(data);
            this.locations.add(newLocation);
            return newLocation;
        }

        public void addRoute(Location location1, Location location2, Long weight) {
            if (!this.isWeighted) {
                weight = null;
            }
            location1.addRoute(location2, weight);
            if (!this.isDirected) {
                location2.addRoute(location1, weight);
            }
        }

        public void addRoute(Location location1, Location location2, Long weight, Transportation t) {
            if (!this.isWeighted) {
            weight = null;
            }
            location1.addRoute(location2, weight,t);
            if (!this.isDirected) {
            location2.addRoute(location1, weight);
            }
        }

        public void removeRoute(Location location1, Location location2) {
            location1.removeEdge(location2);

            if (!this.isDirected) {
                location2.removeEdge(location1);
            }
        }

        public void removeLocation(Location Location) {
            this.locations.remove(Location);
        }

        public ArrayList<Location> getLocations() {
            return this.locations;
        }

        public boolean isWeighted() {
            return this.isWeighted;
        }

        public boolean isDirected() {
            return this.isDirected;
        }

        public Location getLocationByValue(String value) {
            for(Location v: this.locations) {
                if (v.getName() == value) {
                    return v;
                }
            }

            return null;
        }

        public void print() {
            for(Location v: this.locations) {
                //v.print(isWeighted);
                System.out.println(isWeighted);
            }
        }

}

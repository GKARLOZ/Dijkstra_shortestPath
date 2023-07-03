package Dijkstra_shortestPath.Version2.Model;
import java.util.ArrayList;
import java.util.List;

    public class Location {
        private Long id;
        private String name;
        private List<Route> routes;

        public Location(){

        }
        public Location(String name){
            this.name = name;
            this.routes = new ArrayList<>();
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        public List<Route> getRoutes() {
            return routes;
        }

        public void setRoutes(List<Route> routes) {
            this.routes = routes;
        }

        public void addRoute(Location endLocation, Long weight) {

            this.routes.add(new RouteBuilder().withLocationA(this).withLocationB(endLocation).withDuration(weight).createRoute());
        }

        public void addRoute(Location endLocation, Long weight, Transportation t) {

            this.routes.add(new RouteBuilder().withLocationA(this).withLocationB(endLocation).withDuration(weight).withTransportation(t).createRoute());
        }

        public void removeEdge(Location endLocation) {

            this.routes.removeIf(route ->route.getLocationB().equals(endLocation) );
        }


        public String toString() {
            return "Location{" +
                    "id=" + id +
                    ", name='" + name +
                    ", routes=" + routes +
                    '}';
        }


}

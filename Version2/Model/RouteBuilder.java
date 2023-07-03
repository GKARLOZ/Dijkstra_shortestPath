package Dijkstra_shortestPath.Version2.Model;

public class RouteBuilder {
    private Long id;
    private Location locationA;
    private Location locationB;
    private Long duration;
    private Transportation transportation;
    private Long cost;
    private Long distance;

    public RouteBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public RouteBuilder withLocationA(Location locationA) {
        this.locationA = locationA;
        return this;
    }

    public RouteBuilder withLocationB(Location locationB) {
        this.locationB = locationB;
        return this;
    }

    public RouteBuilder withDuration(Long duration) {
        this.duration = duration;
        return this;
    }

    public RouteBuilder withTransportation(Transportation transportation) {
        this.transportation = transportation;
        return this;
    }

    public RouteBuilder withCost(Long cost) {
        this.cost = cost;
        return this;
    }

    public RouteBuilder withDistance(Long distance) {
        this.distance = distance;
        return this;
    }

    public Route createRoute() {
        return new Route(id, locationA, locationB, duration, transportation, cost, distance);
    }
}
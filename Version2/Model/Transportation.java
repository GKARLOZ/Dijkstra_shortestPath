package Dijkstra_shortestPath.Version2.Model;
public class Transportation {
        private long id;
        private String name;
        private Driver driver;

        public Transportation() {

        }
    public Transportation(String name) {
        this.name = name;
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

        public String toString() {
            return "Driver{" +
                    "id=" + id +
                    ", name='" + name +
                    ", driver='" + driver +
                    '}';
        }



}

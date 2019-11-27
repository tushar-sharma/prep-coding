import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Vertex of a graph
 */
class Vertex {
    String label;

    public Vertex(String label) {
        this.label = label;
    }

    /**
     * @return true if string exist
     */
    public boolean hasLabel(String label) {
        return this.label.equals(label);
    }
}

/**
 * Graph using adjaceny list
 */
public class Graph {
    private Map<Vertex, List<Vertex>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    /**
     * add a vertex in a graph
     *
     * @param label String
    */
    public void addVertex(String label) {
        //for all the keys, check if label exist
        //else insert the label
        for(Map.Entry<Vertex, List<Vertex>> entry : adjList.entrySet()) {
            Vertex temp_vertex = entry.getKey();

            if (temp_vertex.hasLabel(label)) {
                return;
            }
        }

        adjList.put(new Vertex(label), new ArrayList<>());
    }

    /**
     * add a edge between two vertex
     */
    public void addEdge(String vertex1, String vertex2) {

        // first check if a vertex1 exist
        // add vertex2 to adjacency List of vertex1
        for (Map.Entry<Vertex, List<Vertex>> entry : adjList.entrySet()) {

            Vertex temp_vertex = entry.getKey();

            if (temp_vertex.hasLabel(vertex1)) {

                List<Vertex> temp_list = entry.getValue();

                for (Vertex v : temp_list) {
                    if (v.hasLabel(vertex2)) {
                        return;
                    }
                }

                adjList.get(temp_vertex).add(new Vertex(vertex2));
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        //add vertices
        g.addVertex("1");
        g.addVertex("2");
        g.addVertex("3");
        g.addVertex("4");
        g.addVertex("5");
        g.addVertex("6");
        g.addVertex("7");
        // add edges
        g.addEdge("1", "2");
        g.addEdge("1", "3");
        g.addEdge("2", "4");
        g.addEdge("2", "5");
        g.addEdge("3", "6");
        g.addEdge("4", "7");
        g.addEdge("5", "7");
        g.addEdge("6", "5");
        g.addEdge("6", "7");
    }
}

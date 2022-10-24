package app;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.EdgeReversedGraph;
import org.jgrapht.graph.SimpleDirectedGraph;

// Una clase para representar un objeto grafo
class App {
    // metodo que retorna la trasnpuesta de un arbol dado
    private static EdgeReversedGraph<Integer, DefaultEdge> transpuesta(Graph<Integer, DefaultEdge> g2) {
        return new EdgeReversedGraph<>(g2);
    }

    public static void main(String[] args) {
        Graph<Integer, DefaultEdge> g = new SimpleDirectedGraph<>(DefaultEdge.class);
        // vertices
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        // artistas
        g.addEdge(1, 3);
        g.addEdge(2, 1);
        g.addEdge(2, 3);

        System.out.println(g); // original
        System.out.println(transpuesta(g)); // transpuesta de g
    }
}

package app;

public class grafo {
    boolean matriz[][];
    int cantNodos; // cantidad de nodos del grafo

    public grafo(boolean matriz_adyacencia[][]) {
        matriz = matriz_adyacencia;
        cantNodos = matriz.length;
    }

    /**
     * Retorna un nuevo grafo, el cual es transpuesto al grafo original
     */
    public grafo transponerOriginal() {
        boolean aux[][] = matriz;
        for (int i = 0; i < cantNodos; i++) {
            for (int k = 0; k < cantNodos; k++) {
                // switch conections
                boolean x = aux[i][k];
                aux[i][k] = aux[k][i];
                aux[k][i] = x;
            }
        }
        return new grafo(aux);
    }

    /**
     * Retorna un nuevo grafo, el cual es transpuesto al grafo proporcionado
     */
    public static grafo transpuesta(grafo g) {
        boolean aux[][] = g.matriz;
        for (int i = 0; i < g.cantNodos; i++) {
            for (int k = 0; k < g.cantNodos; k++) {
                // switch conections
                boolean x = aux[i][k];
                aux[i][k] = aux[k][i];
                aux[k][i] = x;
            }
        }
        return new grafo(aux);
    }
}

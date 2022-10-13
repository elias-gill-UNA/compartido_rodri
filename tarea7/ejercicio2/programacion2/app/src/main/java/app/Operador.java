package app;

/**
 * 
 */

public class Operador {
    private char matriz[][];
    private int filas;
    private int columnas;
    private int aux;
    // variables que contienen el resultado del recorrido
    int resultado[];
    int contador;

    public void areasLibres() {
        resultado = new int[(filas * columnas) / 2];
        contador = 0;
        for (int i = 0; i < filas; i++) {
            for (int k = 0; k < columnas; k++) {
                if (matriz[i][k] == '.') { // si el lugar tiene un punto
                    contador++;
                    aux = 0;
                    recorrer(i, k);
                    resultado[contador - 1] = aux;
                }
            }
        }
    }

    private void recorrer(int i, int k) {
        // si encuentra un # entonces se para el recorrido recursivo
        if (matriz[i][k] == '#') {
            return;
        }

        // cerrar ese camino y continuar recorriendo
        aux++;
        matriz[i][k] = '#';

        // vecinos verticales
        if (i + 1 < filas) {
            recorrer(i + 1, k);
        }
        if (i - 1 >= 0) {
            recorrer(i - 1, k);
        }

        // vecinos horizontales
        if (k + 1 < columnas) {
            recorrer(i, k + 1);
        }
        if (k - 1 >= 0) {
            recorrer(i, k - 1);
        }
    }

    public Operador(char matriz[][], int filas, int columnas) {
        this.matriz = matriz;
        this.filas = filas;
        this.columnas = columnas;
    }
}

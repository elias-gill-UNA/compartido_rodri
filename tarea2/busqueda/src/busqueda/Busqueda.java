/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busqueda;

/**
 *
 * @author Admin
 */
public class Busqueda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Hasta donde iterar
        final int constante = 50000;
        double t1, t2;
        double b1, b2;
        for (int N = 50000; N <= constante; N += 50000) {
            double media1 = 0, media2 = 0;

            // repetir N veces otra vez
            for (int i = 0; i < N; i++) {
                // generar numeros aleatorios
                Double vector[] = new Double[N];
                for (int j = 0; j < vector.length; j++) {
                    double valorEntero = (Math.floor(Math.random() * (1000000 - 10000 + 1) +
                            10000));
                    vector[j] = valorEntero;
                }

                // Elemento aleatorio del vector
                int elemento = (int) (Math.floor(Math.random() * (N - 1)));
                // Busqueda Lineal
                t1 = System.currentTimeMillis();
                buscar.lineal(vector, vector[elemento]);
                t2 = System.currentTimeMillis();
                media1 += t2 - t1;

                // Busqueda Binaria
                Util.quicksort(vector);
                b1 = System.currentTimeMillis();
                buscar.busquedaBinaria(vector, vector[elemento]);
                b2 = System.currentTimeMillis();
                media2 += b2 - b1;
            }
            // imprimir resultados parciales
            System.out.printf("%10d | %10f | %10f | %10f | %10f | %10f | %10f | %10f | %10f\n",
                    N, media1, media1 / N, media1 / (N * (Math.log(N) / Math.log(2))),
                    media1 / (N * N),
                    media2, media2 / N, media2 / (N * (Math.log(N) / Math.log(2))), media2 / (N * N));
        }
    }
}

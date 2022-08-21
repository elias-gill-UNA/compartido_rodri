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
        final int constante = 1000000;
        double t1, t2;
        double b1, b2;

        System.out.println(
                " -------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-14s | %-59s | %47s\n |", "    N    ", "          Busqueda Lineal", "Busqueda Binaria    ");
        System.out.println(
                " --------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-12s | %-12s | %-12s | %-12s | %-12s | %-12s | %-12s | %-12s | %-12s |\n",
                "", "T(n) ms", "T/N", "T/(N*LogN)", "T/N^2", "T(n) ms", "T/N", "T/(N*LogN)", "T/(N^2)");

        for (int N = 50000; N <= constante; N += 50000) {
            double media1 = 0, media2 = 0;

            // generar numeros aleatorios
            Integer vector[] = new Integer[N];
            for (int j = 0; j < vector.length; j++) {
                int valorEntero = (int) (Math.floor(Math.random() * (1000000 - 10000 + 1) +
                        10000));
                vector[j] = valorEntero;
            }

            // busqueda lineal
            for (int i = 0; i < N; i++) {
                // Elemento aleatorio del vector
                int elemento = (int) (Math.floor(Math.random() * (N - 1)));
                // Busqueda Lineal
                t1 = System.currentTimeMillis();
                buscar.lineal(vector, vector[elemento]);
                t2 = System.currentTimeMillis();
                media1 += t2 - t1;
            }

            // ordenar y busqueda binaria
            Util.quicksort(vector);
            for (int i = 0; i < N; i++) {
                int elemento = (int) (Math.floor(Math.random() * (N - 1)));
                // Busqueda Binaria
                b1 = System.currentTimeMillis();
                buscar.busquedaBinaria(vector, vector[elemento]);
                b2 = System.currentTimeMillis();
                media2 += b2 - b1;
            }

            // imprimir resultados parciales
            System.out.println(
                    " --------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %12d | %12f | %12f | %12f | %12f | %12f | %12f | %12f | %12f |\n",
                    N, media1, media1 / N, media1 / (N * (Math.log(N) / Math.log(2))),
                    media1 / (N ^ 2),
                    media2, media2 / N, media2 / (N * (Math.log(N) / Math.log(2))), media2 / (N ^ 2));
        }
        System.out.println(
                " --------------------------------------------------------------------------------------------------------------------------------------");
    }
}

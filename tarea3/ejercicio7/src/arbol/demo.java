package arbol;

public class demo {
    private static int[] nuevoDesordenado(int n) {
        int[] res = new int[n];
        // rellenar de numeros
        for (int i = 0; i < n; i++) {
            res[i] = i;
        }
        // esparcir numeros
        for (int i = 0; i < n; i++) {
            // dos posiciones aleatorias
            int random = (int) (Math.random() * (n));
            int random2 = (int) (Math.random() * (n));
            // swap
            int aux = res[random];
            res[random] = res[random2];
            res[random2] = aux;
        }
        return res;
    }

    public static void main(String[] args) {
        // Hasta donde iterar
        final int constante = 4000;
        double t1, t2;

        System.out.println(
                " -------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-14s | %-59s | %47s\n |", "    N    ", "          Arbol balanceado",
                "Arbol desbalanceado    ");
        System.out.println(
                " --------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-12s | %-12s | %-12s | %-12s | %-12s | %-12s | %-12s | %-12s | %-12s |\n",
                "", "T(n) ms", "T/N", "T/(N*LogN)", "T/N^2", "T(n) ms", "T/N", "T/(N*LogN)", "T/(N^2)");

        for (int N = 1000; N <= constante; N += 1000) {
            double media1 = 0, media2 = 0;
            int[] aleatorio = nuevoDesordenado(N);

            // arbol balanceado
            for (int i = 0; i < N; i++) {
                t1 = System.currentTimeMillis();
                AVLTree avlTree = new AVLTree();

                // nodos balanceados al insertar
                for (int k = 0; k < N; k++) {
                    avlTree.add(new NodoBalanceado(aleatorio[k]));
                }
                // simulacion de impresion, realmente no hace nada
                avlTree.inorder();

                t2 = System.currentTimeMillis();
                media1 += t2 - t1;
            }

            // arbol desbalanceado
            for (int i = 0; i < N; i++) {
                // ordenamiento
                t1 = System.currentTimeMillis();
                AVLTree avlTree = new AVLTree();

                // nodos que no se balancean al insertar
                for (int k = 0; k < N; k++) {
                    avlTree.add(new NodoDesbalanceado(aleatorio[k]));
                }
                // simulacion de impresion, realmente no hace nada
                avlTree.inorder();

                t2 = System.currentTimeMillis();
                media2 += t2 - t1;
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

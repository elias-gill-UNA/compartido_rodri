package busqueda;

public class Main {
    private static final int len = 50;

    public static void main(String[] args) {
        long t1;
        long t2;
        // matriz que contiene los resultados
        long[] res = new long[2];

        System.out.println(" N | Fibbo ciclo  | Fibbo recursivo");
        System.out.println("-------------------------------------");
        for (int i = 0; i < len; i++) {
            // tiempo de duracion
            t1 = System.nanoTime();
            fibbo.fibboCiclico(i);
            t2 = System.nanoTime();
            // guardar tiempo
            res[0] = t2 - t1;

            t1 = System.nanoTime();
            fibbo.fibboRecursivo(i);
            t2 = System.nanoTime();
            res[1] = t2 - t1;

            System.out.printf("%2d |   %6d ms  |  %6d ms\n", i+1, res[0] / 10 ^ 3, res[1] / 10 ^ 3);
        }
    }
}

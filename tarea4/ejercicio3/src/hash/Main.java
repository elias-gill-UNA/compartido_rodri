package hash;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {

        ClosedDoubleHashTable<String> dobleHash = new ClosedDoubleHashTable<>(0.6, 1000);
        ClosedLinearHashTable<String> linear = new ClosedLinearHashTable<>(0.6, 1000);
        ClosedCuadraticHashTable<String> cuadratic = new ClosedCuadraticHashTable<>(0.6, 1000);
        OpenHashTable<String> open = new OpenHashTable<>(8000);

        long times[] = new long[4]; // [lineal, cuadratico, doble, abierto]
        long a, b;

        // --- medicion de anadir un nuevo elemento
        try {
            BufferedReader file = new BufferedReader(
                    new FileReader("/home/elias/Documentos/compartido_rodri/tarea4/es_ES.dic"));

            // leer las lineas del archivo
            String currentLine = file.readLine().split("/")[0];
            while (currentLine != null) {
                a = System.nanoTime();
                linear.add(currentLine);
                b = System.nanoTime();
                times[0] += b - a;

                a = System.nanoTime();
                cuadratic.add(currentLine);
                b = System.nanoTime();
                times[1] += b - a;

                a = System.nanoTime();
                dobleHash.add(currentLine);
                b = System.nanoTime();
                times[2] += b - a;

                a = System.nanoTime();
                open.add(currentLine);
                b = System.nanoTime();
                times[3] += b - a;

                // leer la linea actual
                try {
                    currentLine = file.readLine().split("/")[0];
                } catch (Exception e) {
                    file.close();
                    currentLine = null;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.printf("Tiempos anadir \n %s \n %20s %20s %20s %20s \n%20s %20s %20s %20s",
                "------------------------------------------------",
                "Lineal", "Cuadratica", "Doble hash", "Abierta",
                times[0], times[1], times[2], times[3]);

        // --- medicion de eliminar un nuevo elemento
        times = new long[4]; // [lineal, cuadratico, doble, abierto]
        try {
            BufferedReader file = new BufferedReader(
                    new FileReader("/home/elias/Documentos/compartido_rodri/tarea4/es_ES.dic"));

            // leer las lineas del archivo
            String currentLine = file.readLine().split("/")[0];
            while (currentLine != null) {
                a = System.nanoTime();
                linear.delete(currentLine);
                b = System.nanoTime();
                times[0] += b - a;

                a = System.nanoTime();
                cuadratic.delete(currentLine);
                b = System.nanoTime();
                times[1] += b - a;

                a = System.nanoTime();
                dobleHash.delete(currentLine);
                b = System.nanoTime();
                times[2] += b - a;

                a = System.nanoTime();
                open.delete(currentLine);
                b = System.nanoTime();
                times[3] += b - a;

                // leer la linea actual
                try {
                    currentLine = file.readLine().split("/")[0];
                } catch (Exception e) {
                    file.close();
                    currentLine = null;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.printf("\n\nTiempos eliminacion \n %s \n %20s %20s %20s %20s \n%20s %20s %20s %20s",
                "------------------------------------------------",
                "Lineal", "Cuadratica", "Doble hash", "Abierta",
                times[0], times[1], times[2], times[3]);

        // --- medicion de buscar un elemento
        times = new long[4]; // [lineal, cuadratico, doble, abierto]
        try {
            BufferedReader file = new BufferedReader(
                    new FileReader("/home/elias/Documentos/compartido_rodri/tarea4/es_ES.dic"));

            // leer las lineas del archivo
            String currentLine = file.readLine().split("/")[0];
            while (currentLine != null) {
                a = System.nanoTime();
                linear.search(currentLine);
                b = System.nanoTime();
                times[0] += b - a;

                a = System.nanoTime();
                cuadratic.search(currentLine);
                b = System.nanoTime();
                times[1] += b - a;

                a = System.nanoTime();
                dobleHash.search(currentLine);
                b = System.nanoTime();
                times[2] += b - a;

                a = System.nanoTime();
                open.search(currentLine);
                b = System.nanoTime();
                times[3] += b - a;

                // leer la linea actual
                try {
                    currentLine = file.readLine().split("/")[0];
                } catch (Exception e) {
                    file.close();
                    currentLine = null;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.printf("\n\nTiempos busqueda \n %s \n %20s %20s %20s %20s \n%20s %20s %20s %20s",
                "------------------------------------------------",
                "Lineal", "Cuadratica", "Doble hash", "Abierta",
                times[0], times[1], times[2], times[3]);

        // determinar agrupamientos
        // lineal
        System.out.println("Agrupamiento lineal\n");
        int []aux = linear.agrupamientos();
        for (int i = 1; i<aux.length; i++) {
            if (aux[i] != 0) {
                System.out.printf("Indice: %4d\tVeces: %4d\n", i+1, aux[i]);
            }
        }

        System.out.println("\nAgrupamiento cuadratico");
        aux = cuadratic.agrupamientos();
        for (int i = 1; i<aux.length; i++) {
            if (aux[i] != 0) {
                System.out.printf("Indice: %4d\tVeces: %4d\n", i+1, aux[i]);
            }
        }

        System.out.println("\nAgrupamiento doble hash");
        aux = dobleHash.agrupamientos();
        for (int i = 1; i<aux.length; i++) {
            if (aux[i] != 0) {
                System.out.printf("Indice: %4d\tVeces: %4d\n", i+1, aux[i]);
            }
        }
    }
}

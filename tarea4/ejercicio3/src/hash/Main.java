package hash;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        /*
         * ClosedDoubleHashTable<Integer> dobleHash = new ClosedDoubleHashTable<>(0.6);
         * ClosedLinearHashTable<Integer> linear = new ClosedLinearHashTable<>(0.6);
         * ClosedCuadraticHashTable<Integer> cuadratic = new
         * ClosedCuadraticHashTable<>(0.6);
         * OpenHashTable<Integer> open = new OpenHashTable<>();
         * 
         * dobleHash.add(1);
         * linear.add(1);
         * cuadratic.add(1);
         * open.add(1);
         */

        try {
            BufferedReader file = new BufferedReader(
                    new FileReader("/home/elias/Documentos/compartido_rodri/tarea4/es_ES.dic"));

            // leer las lineas del archivo
            String currentLine = file.readLine();
            while (currentLine != null) {
                System.out.println(currentLine);
                currentLine = file.readLine();
            }

            file.close();

        } catch (Exception e) {
            System.out.println("file does not exist");
        }
    }
}

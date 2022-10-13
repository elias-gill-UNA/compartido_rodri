/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package app;

import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {
            Scanner lector = new Scanner(new File("/home/elias/matriz.txt"));
            String linea = lector.nextLine();
            int filas = Integer.parseInt(linea.split(" ")[0]);
            int columnas = Integer.parseInt(linea.split(" ")[1]);
            char matriz[][] = new char[filas][columnas];

            // cargar la matriz desde el archivo
            int i = 0;
            while (lector.hasNextLine()) {
                linea = lector.nextLine();
                // rellenar la matriz caracter a caracter
                for (int k = 0; k < columnas; k++) {
                    matriz[i][k] = linea.charAt(k);
                }
                i++;
            }
            Operador op = new Operador(matriz, filas, columnas);
            imprimirMatriz(matriz);

            op.areasLibres();
            System.out.println(op.contador);
            imprimirArray(op.resultado);

        } catch (Exception e) {
            System.out.println("Unable to open the file");
            System.out.println(e);
        }
    }

    private static void imprimirMatriz(char[][] matriz) {
        for (char[] i : matriz) {
            for (char k : i) {
                System.out.print(k);
            }
            System.out.println(" ");
        }
    }

    private static void imprimirArray(int[] resultado) {
        for (int i : resultado) {
            if (i != 0) {
                System.out.print(i + "  ");
            }
        }
    }
}

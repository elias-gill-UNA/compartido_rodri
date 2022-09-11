/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author Admin
 */
public class hash {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        int claves[] = new int[1000];
        int R = 64;

        try {
            BufferedReader file = new BufferedReader(
                    new FileReader("/home/elias/Documentos/compartido_rodri/tarea4/es_ES.dic"));

            // leer las lineas del archivo
            String currentLine = file.readLine();
            while (currentLine != null) {
                currentLine = file.readLine().split("/")[0];

                int hash_value = 0;
                for (int k = 1; k < currentLine.length(); k *= 2) {
                    hash_value = hash_value * R + (currentLine.charAt(k - 1));
                }
                claves[Math.abs(hash_value % 1000)]++;
            }

            file.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        // imprimir los resultados
        for (int entero : claves) {
            System.out.println(entero);
        }

    }
}

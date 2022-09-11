/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

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
        int R = 37;
        try {
            BufferedReader file = new BufferedReader(
                    new FileReader("C:/Users/Admin/Documents/NetBeansProjects/hash/es-ES.dic"));

            // leer las lineas del archivo
            String currentLine = file.readLine();
            for(int i=0;i<10000;i++){
                //System.out.println(currentLine);
                currentLine = file.readLine();
                currentLine = file.readLine();
                
                int hash_value = 0;
                for (int k = 1; k < currentLine.length(); k *= 2) {
                    hash_value = hash_value * R + (currentLine.charAt(k - 1));
                    claves[hash_value%1000]++;
                }
            }
            for(int entero:claves){
                System.out.println(entero);
            }

            file.close();

        } catch (Exception e) {
            System.out.println("file does not exist");
        }
    }
}
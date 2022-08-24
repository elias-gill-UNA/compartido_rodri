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
public class buscar<T> {
    public static <T> int lineal(T vector[], T valor) {
        int posicion = -1;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == valor) {
                return i;
            }
        }
        return posicion;
    }

    public static <T extends Comparable<T>> int busquedaBinaria(T[] vector, T valor) {
        int inicio = 0, fin = vector.length - 1, posicion;
        while (inicio <= fin) {
            posicion = (inicio + fin) / 2;
            if (vector[posicion].compareTo(valor) < 0) {
                inicio = posicion + 1;
            } else if (vector[posicion].compareTo(valor) > 0) {
                fin = posicion - 1;
            } else {
                return posicion;
            }
        }
        return -1;
    }
}

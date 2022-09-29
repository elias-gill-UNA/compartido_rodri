/*
    Grupo g22
    Gill Quintana, Elias Sebastian            CI: 5.223.284       Seccion TR
    Alvarenga Cavallero, Rodrigo              CI: 5.711.576       Seccion TR

    Tarea 2-U2 - Ejercicio II.1

  DECLARACIÓN DE HONOR
  • Nosotros Elias Gill y Rodrigo Alvarenga:

  • No hemos discutido el código fuente de nuestra tarea con ningún otro
  grupo, solo con el Profesor o el AER.

  • No hemos usado código obtenido de otro estudiante o de cualquier otra
  fuente no autorizada, modificada o no modificada.

  • Cualquier código o documentación utilizada en nuestro programa
  obtenido de fuentes, tales como libros o notas de curso, han sido claramente
  indicada en nuestra tarea.
*/
package ejercicio2;

import java.util.Arrays;

public class App {

    // funcion que realiza el radix sort sobre un array
    public static void radixSort(String input[],
                                 int radix,
                                 int largo) {
        for (int i = 0; i < largo; i++) {
            performRadixSort(input, i, radix);
        }
    }

    private static void performRadixSort(String input[],
                                         int posicion,
                                         int radix) {

        // crear un array temporal para el conteo
        int countArray[] = new int[radix];
        int nos = input.length;

        // rellenando el nuevo array
        for (String value : input) {
            countArray[getDigito(posicion,
                    value, radix)]++;
        }

        // normalizar el arreglo
        for (int i = 1; i < radix; i++) {
            countArray[i] = countArray[i]
                    + countArray[i - 1];
        }

        String temp[] = new String[nos];
        // rellendo el arreglo temporal
        for (int i = nos - 1; i >= 0; i--) {
            temp[--countArray[getDigito(
                    posicion, input[i], radix)]] = input[i];
        }
        // copiando en un nuevo arreglo
        for (int i = 0; i < nos; i++) {
            input[i] = temp[i];
        }
    }

    // transformando las letras a posiciones del arreglo
    public static int getDigito(int position,
                                String value,
                                int radix) {
        int nos = value.length() - 1;
        char c = value.toLowerCase().charAt(nos - position);
        return (int) c - 97;
    }

    // Ejemplo de prueba
    public static void main(String[] args) {
        String arr[] = {"BCDEF", "dbaqc", "abcde", "bbbbb"};
        System.out.println("Input:"
                + Arrays.toString(arr));

        radixSort(arr, 26, arr[0].length());
        System.out.println("Output:"
                + Arrays.toString(arr));
    }
}

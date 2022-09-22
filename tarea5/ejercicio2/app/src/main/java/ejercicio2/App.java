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

    // Function to perform Radix sort
    // on String array
    public static void radixSort(String input[],
            int radix,
            int width) {
        for (int i = 0; i < width; i++) {
            performRadixSort(input, i, radix);
        }
    }

    public static void performRadixSort(String input[],
            int position,
            int radix) {

        // Creating a temporary count array
        int countArray[] = new int[radix];
        int nos = input.length;

        // Populating the count array
        for (String value : input) {
            countArray[getDigit(position,
                    value, radix)]++;
        }

        // Normalizing count array
        for (int i = 1; i < radix; i++) {
            countArray[i] = countArray[i]
                    + countArray[i - 1];
        }

        String tempArray[] = new String[nos];
        // Building the final temporary array
        for (int i = nos - 1; i >= 0; i--) {
            tempArray[--countArray[getDigit(
                    position, input[i], radix)]] = input[i];
        }
        // Copying into the actual array
        for (int i = 0; i < nos; i++) {
            input[i] = tempArray[i];
        }
    }

    // Hashing the input value, radix = 26
    // It takes the character at
    // (length - position) location
    // and convert it to ascii value and
    // return the ascii value
    public static int getDigit(int position,
            String value,
            int radix) {
        int nos = value.length() - 1;
        char c = value.toLowerCase().charAt(nos - position);
        return (int) c - 97;
    }

    // Driver Code
    public static void main(String[] args) {
        String arr[] = { "BCDEF", "dbaqc", "abcde", "bbbbb" };
        System.out.println("Input:"
                + Arrays.toString(arr));

        // Radix is the maximum value from
        // the input array
        // For String maximum value is 26
        radixSort(arr, 26, arr[0].length());
        System.out.println("Output:"
                + Arrays.toString(arr));
    }
}

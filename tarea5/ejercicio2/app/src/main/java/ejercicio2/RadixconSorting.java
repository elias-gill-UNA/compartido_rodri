package ejercicio2;
 
import java.util.*;
 
class RadixconSorting {
 
    // funcion para determinar el elemento mas grande del array
    static int getMax(int arr[], int n)
    {
        int max = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }
 
    // Funcion para hacer counting sort del array dependiendo
    // del digito representado por exp
    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // array de salida
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
 
        // contador de ocurrencias
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;
 
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        // prepara el array de salida
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
 
        // copiar el array de salida a arr[] para que ahora arr[]
        // contenga los digitos ordenados en ese exp
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
 
    static void radixsort(int arr[], int n)
    {
        // buscar el maximo numero
        int m = getMax(arr, n);

        // hacer counting sort por cada digito (base 10)
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
 
    // funcion para imprimir un array
    static void print(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    // ejemplo de funcionamiento
    public static void main(String[] args)
    {
        int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
        int n = arr.length;

        print(arr, n);
        System.out.println("ordenando...\n");
        radixsort(arr, n);
        print(arr, n);
    }
}

<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busqueda;

import static javafx.scene.input.KeyCode.M;

/**
 *
 * @author Admin
 */
public class Busqueda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i = 1;
        while (i <= 20) {
            int N = i * 50000;
            
            double media1 = 0, media2 = 0;
            
                double vector[] = new double[N];
                for (int x = 0; x < vector.length; x++) {
                    double valorEntero = (Math.floor(Math.random() * (1000000 - 10000 + 1) + 10000));// Valor entre M y N, ambos incluidos.
                    vector[x] = valorEntero;
                }
                int elemento = (int) (Math.floor(Math.random() * (N - 1)));
                double valor = vector[elemento];
                double t1, t2;//Para la busqueda Lineal
                t1 = System.currentTimeMillis();
                buscar.lineal(vector, valor);
                t2 = System.currentTimeMillis();
                media1 = t2-t1;

                // Para la busqueda Binaria
                quickSort(vector);
                double b1, b2;
                b1 = System.currentTimeMillis();
                buscar.busquedabinaria(vector, valor);
                b2 = System.currentTimeMillis();
                media2 = (b2 - b1);
            
            System.out.printf("%10d | %10f | %10f | %10f | %10f | %10f | %10f | %10f | %10f\n",
                    N, media1, media1 / N, media1 / (N * (Math.log(media1) / Math.log(2))), media1 / (N * N),
                    media2, media2 / N, media2 / (N * (Math.log(media2) / Math.log(2))), media2 / (N * N));
            
            i++;
        }

    }

    public static void quickSort(double[] intArray) {
        recQuickSort(intArray, 0, intArray.length - 1);
    }

    public static void recQuickSort(double[] intArray, int left, int right) {
        int size = right - left + 1;
        if (size <= 3) {
            manualSort(intArray, left, right);
        } else {
            double median = medianOf3(intArray, left, right);
            int partition = partitionIt(intArray, left, right, median);
            recQuickSort(intArray, left, partition - 1);
            recQuickSort(intArray, partition + 1, right);
        }
    }

    public static double medianOf3(double[] intArray, int left, int right) {
        int center = (left + right) / 2;

        if (intArray[left] > intArray[center]) {
            swap(intArray, left, center);
        }

        if (intArray[left] > intArray[right]) {
            swap(intArray, left, right);
        }

        if (intArray[center] > intArray[right]) {
            swap(intArray, center, right);
        }

        swap(intArray, center, right - 1);
        return intArray[right - 1];
    }

    public static void swap(double[] intArray, int dex1, int dex2) {
        double temp = intArray[dex1];
        intArray[dex1] = intArray[dex2];
        intArray[dex2] = temp;
    }

    public static int partitionIt(double[] intArray, int left, int right, double pivot) {
        int leftPtr = left;
        int rightPtr = right - 1;

        while (true) {
            while (intArray[++leftPtr] < pivot)
        ;
            while (intArray[--rightPtr] > pivot)
        ;
            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(intArray, leftPtr, rightPtr);
            }
        }
        swap(intArray, leftPtr, right - 1);
        return leftPtr;
    }

    public static void manualSort(double[] intArray, int left, int right) {
        int size = right - left + 1;
        if (size <= 1) {
            return;
        }
        if (size == 2) {
            if (intArray[left] > intArray[right]) {
                swap(intArray, left, right);
            }
            return;
        } else {
            if (intArray[left] > intArray[right - 1]) {
                swap(intArray, left, right - 1);
            }
            if (intArray[left] > intArray[right]) {
                swap(intArray, left, right);
            }
            if (intArray[right - 1] > intArray[right]) {
                swap(intArray, right - 1, right);
            }
        }
    }

}
=======
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
public class Busqueda {
    public static void main(String[] args) {
        double vector[] = {1,978.1, 3.3, 9, 44, 2, 4, 5};
        double aux[] = buscar.sort(vector);
        for (double var : aux) {
            System.out.println(var);
        }
    }
}
>>>>>>> e3035f2 (no funciona fibbo)

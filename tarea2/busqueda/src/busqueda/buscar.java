<<<<<<< HEAD
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
public class buscar {
    public static void lineal(double vector[],double valor){
        int i=0;
        int posicion=-1;
        while(i<vector.length){
            if (vector[i]==valor){
                posicion=i;
            }
            i++;
        }
    }
   
public static void busquedabinaria(double vector[],double valor){
        int low_indice=0;
        int high_indice=vector.length-1;
        int posicion=-1;
        while(low_indice<=high_indice){
            int medio_indice=(low_indice+high_indice)/2;
            if(valor==vector[medio_indice]){
                posicion=medio_indice;
                break;
            }else if(valor<vector[medio_indice]){
                high_indice=medio_indice-1;
            }else if(valor>vector[medio_indice]){
                low_indice=medio_indice+1;
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
public class buscar {
    public static int lineal(double vector[], double valor) {
        int i = 0;
        while (i < vector.length) {
            if (vector[i] == valor) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static double[] sort(double vector[]) {
        double[] vect = quicksort(vector, 0, vector.length - 1);
        return vect;
    }

    private static double[] quicksort(double vector[], int low, int higt) {
        if (low > higt)
            return vector;

        // Seleccion del elemento Pivote
        int medio = low + (higt - low) / 2;
        double pivote = vector[medio];
        while (low <= higt) {
            while (vector[low] < pivote) {
                low++;
            }
            while (vector[higt] > pivote) {
                higt--;
            }
            // hacer el swap
            if (low <= higt) {
                double temp = vector[low];
                vector[low] = vector[higt];
                vector[higt] = temp;
                low++;
                higt--;
            }
            // Volvemos a llamar al ordenamiento si aun sigue desordenado
            if (low < higt)
                return quicksort(vector, 0, vector.length-1);
        }
        return vector;
    }

    public static  void busquedabinaria(double vector[], double valor) {
        double[] vect = sort(vector);// Recibimos el Vector Ordenado para Busqueda Binaria
        int low_indice = 0;
        int high_indice = vect.length - 1;

        while (low_indice <= high_indice) {
            int medio_indice = (low_indice + high_indice) / 2;
            if (valor == vect[medio_indice]) {
                break;
            } else if (valor < vect[medio_indice]) {
                high_indice = medio_indice - 1;
            } else if (valor > vect[medio_indice]) {
                low_indice = medio_indice + 1;
            }
        }
    }
}
>>>>>>> e3035f2 (no funciona fibbo)

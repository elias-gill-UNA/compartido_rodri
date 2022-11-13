package ej8_4;

/*
Grupo g22
    Gill Quintana, Elias Sebastian            CI: 5.223.284       Seccion TR
    Alvarenga Coronel, Rodrigo                CI: 5.711.576       Seccion TR

    Tarea 5-U3 - Ejercicio I

  DECLARACIÓN DE HONOR
  • Nosotros Elias Gill y Rodrigo Alvarenga:

  • No hemos discutido el código fuente de nuestra tarea con ningún otro
  grupo, solo con el Profesor o el AER.

  • No hemos usado código obtenido de otro estudiante o de cualquier otra
  fuente no autorizada, modificada o no modificada.

  • Cualquier código o documentación utilizada en nuestro programa
  obtenido de fuentes, tales como libros o notas de curso, han sido claramente
  indicada en nuestra tarea.
  Traducción hecha del libro del cornet tal cual como pidió el ejercicio

 */
class ej8_4 {

    static char name = 'A'; 
    static void PRINT_OPTIMAL_PARENS(int i, int j, int n, int[][] bracket) {
        if (i == j) {
            System.out.print(name++);
        } else {
            System.out.print('(');
            
            PRINT_OPTIMAL_PARENS(i, bracket[j][i], n, bracket);
            PRINT_OPTIMAL_PARENS(bracket[j][i] + 1, j, n, bracket);
            System.out.print(')');
        }

    }

    
    static void MATRIX_CHAIN_ORDER(int[] p, int n) { 
        int[][] m = new int[n][n];
        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        m[j][i] = k;
                    }
                }
            }
        }
        
        System.out.print("\nEl costo minimo del producto es:" + m[1][n - 1]);
        System.out.println("");
        PRINT_OPTIMAL_PARENS(1, n - 1, n, m);
       
    }

    public static void main(String[] args) {
        int[] arr = {10,35,15,5,20,30,40};
        int n = arr.length;
        MATRIX_CHAIN_ORDER(arr, n);
    }
}

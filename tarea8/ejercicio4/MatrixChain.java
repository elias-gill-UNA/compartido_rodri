class MatrixChain {

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

    
    static void MATRIX_CHAIN_ORDER(int n, Matriz[] listaMatriz) { 
        int[][] m = new int[n][n];
        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    
                    int q = m[i][k] + m[k + 1][j] + listaMatriz[i - 1].getFilas()* listaMatriz[k].getColumnas()* listaMatriz[j].getColumnas();
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        m[j][i] = k;
                    }
                }
            }
        }
        
       
        System.out.print("\nEl costo minimo del producto es:" + m[1][n - 1]);
        System.out.println("");
        
        // imprime la parentizacion optima de la multiplicacion 
        PRINT_OPTIMAL_PARENS(1, n - 1, n, m);
       
    }


    public static void main(String[] args) {
        Matriz[] listaMatriz = new Matriz[6];
        
        listaMatriz[0] = new Matriz(10,35);
        listaMatriz[1] = new Matriz(35,15);
        listaMatriz[2] = new Matriz(15,5);
        listaMatriz[3] = new Matriz(5,20);
        listaMatriz[4] = new Matriz(20,30);
        listaMatriz[5] = new Matriz(30,40);
        
        int len = listaMatriz.length;
        MATRIX_CHAIN_ORDER(len, listaMatriz);
    }
}

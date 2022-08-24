package busqueda;

/*
 * Un ejemplo de uso sencillo de uso de la clase BST
 */
public class Arbol {
    public static void main(String[] args) {
        BST<Integer> t = new BST<>();
        Integer[] A = { 10, 15, 7, 8, 6, 2, 11, 12 };
        for (int k = 0; k < A.length - 1; k++)
            t.agregar(A[k]);

        t.imprimir();

        Integer k = (Integer) t.buscar(81);

        if (k != null)
            System.out.println("Si existe!!" + k);
    }
}

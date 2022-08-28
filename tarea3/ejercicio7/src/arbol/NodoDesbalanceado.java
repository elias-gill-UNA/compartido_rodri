package arbol;
/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS III - Seccion TQ - Prof. Cristian Cappo / Prof. Luis More
 * Ing. Informatica
 * 2021-1er Periodo
 *
 * Implementa la clase BST (Arbol Binario de Busqueda)
 * El dato cuya referencia se almacena en cada nodo
 * es un Comparable o derivado. 
 */

class NodoDesbalanceado extends NodoAbstracto {
    int value;
    NodoAbstracto left;
    NodoAbstracto right;

    public NodoDesbalanceado(int value) {
        super(value);
    }

    // Cómo agregar nodos
    public void add(NodoAbstracto node) {
        if (node == null) {
            return;
        }

        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                // Deje que el nodo hijo izquierdo del nodo ejecute de forma recursiva el método
                // add
                this.left.add(node);
            }
        }

        if (node.value > this.value) {
            if (this.right == null) {
                this.right = node;
            } else {
                // Permita que el nodo hijo derecho del nodo ejecute de forma recursiva el
                // método add
                this.right.add(node);
            }
        }
    }
}

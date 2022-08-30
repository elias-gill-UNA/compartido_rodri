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

class NodoBalanceado extends NodoAbstracto {
    int value;
    NodoAbstracto left;
    NodoAbstracto right;

    public NodoBalanceado(int value) {
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

        if (rightHeight() - leftHeight() > 1) {
            leftRotated();
        }
    }

    // Método para zurdos
    private void leftRotated() {
        // Crea un nuevo nodo para que el valor del nuevo nodo sea igual al valor del
        // nodo raíz actual
        NodoBalanceado newNode = new NodoBalanceado(value);
        // Deje que el nodo hijo izquierdo del nuevo nodo apunte al nodo hijo izquierdo
        // del nodo raíz actual
        newNode.left = left;
        // Deje que el nodo hijo derecho del nuevo nodo apunte al nodo hijo izquierdo
        // del subárbol derecho del nodo raíz actual
        newNode.right = right.left;
        // Establece el valor del nodo seguidor actual al valor del nodo hijo derecho
        // del nodo seguidor actual
        value = right.value;
        // Conecta el subárbol derecho del nodo hijo derecho del nodo actual al nodo
        // raíz actual
        right = right.right;
        // Establecer el nodo hijo izquierdo del nodo actual como un nuevo nodo
        left = newNode;
    }
}

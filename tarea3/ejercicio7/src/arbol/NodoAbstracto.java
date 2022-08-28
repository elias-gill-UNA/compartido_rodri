package arbol;

public abstract class NodoAbstracto {
    int value;
    NodoAbstracto left;
    NodoAbstracto right;

    public NodoAbstracto(int value) {
        this.value = value;
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

    // Resultados de salida transversal en orden
    public void inorder() {
        if (this.left != null) {
            this.left.inorder();
        }
        // System.out.printthis.value + "\t");
        if (this.right != null) {
            this.right.inorder();
        }
    }

    // Devuelve la altura del árbol con este nodo como nodo raíz (incluido este
    // nodo)
    public int heigth() {
        return Math.max(left == null ? 0 : left.heigth(), right == null ? 0 : right.heigth()) + 1;
    }

    // Devuelve la altura del subárbol izquierdo
    public int leftHeight() {
        if (left == null) {
            return 0;
        } else {
            return left.heigth();
        }
    }

    // Devuelve la altura del subárbol derecho
    public int rightHeight() {
        if (right == null) {
            return 0;
        } else {
            return right.heigth();
        }
    }
}

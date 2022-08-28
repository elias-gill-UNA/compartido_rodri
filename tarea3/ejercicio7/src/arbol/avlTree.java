package arbol;

class AVLTree {
    private NodoAbstracto root;

    public NodoAbstracto getRoot() {
        return root;
    }

    public void add(NodoAbstracto node) {
        if (root == null) {
            root = node;
        } else {
            // Cada nodo debe compararse con la raíz
            root.add(node);
        }
    }

    public void inorder() {
        if (root != null) {
            root.inorder();
        }
    }
}

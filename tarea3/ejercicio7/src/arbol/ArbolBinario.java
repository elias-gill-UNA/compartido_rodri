package arbol;

class ArbolBinario {
    private NodoNormal root;

    public NodoNormal getRoot() {
        return root;
    }

    public void add(NodoNormal node) {
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

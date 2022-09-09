package hash;

public class Nodos<T> {
    Nodos<T> padre;
    Nodos<T> hijo;
    T value;

    public Boolean search(T element) {
        Nodos<T> actual = this;

        while (true) {
            if (element == actual.value) {
                return true;
            }

            if (actual.hijo == null) {
                return false;
            }

            actual = actual.hijo;
        }
    }

    // functions for adding new elements to the list
    public void add(T value2) {
        if (this.value == null) {
            this.value = value2;
        }

        if (!search(value2)) {
            this.hijo = addPrivate(value2, this.hijo, this);
        }
    }

    private Nodos<T> addPrivate(T value2, Nodos<T> nodo, Nodos<T> padre) {
        if (nodo == null) {
            Nodos<T> aux = new Nodos<T>(value2);
            aux.padre = padre;
            return aux;
        }
        return addPrivate(value2, nodo.hijo, padre.hijo);
    }


    // functions for deleting element from the list
    public void delete(T value2) {
        if (this.value == value2) {
            this.hijo = 
        }

        if (search(value2)) {
            this.hijo = deletePrivate(value2, this.hijo, this);
        }
    }

    private Nodos<T> deletePrivate(T value2, Nodos<T> nodo, Nodos<T> padre) {
        if (nodo == null) {
            Nodos<T> aux = new Nodos<T>(value2);
            aux.padre = padre;
            return aux;
        }
        return addPrivate(value2, nodo.hijo, padre.hijo);
    }

    public Nodos(T value){
        this.value = value;
    }
}

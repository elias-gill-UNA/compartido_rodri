package arbol;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS III - Seccion TQ - Prof. Cristian Cappo / Prof. Luis More
 * Ing. Informatica
 * 2021-1er Periodo
 *
 * Implementa la clase BST (Arbol Binario de Busqueda)
 * El dato cuya referencia se almacena en cada nodo
 * es un Comparable o derivado. 
 */

public class arbol<T extends Comparable<T>> implements Iterable<Object> {
    // raiz del arbol
    private NodoBST<T> raiz = null;
    private ArrayList<T> lista = new ArrayList<>();

    // clase que representa un nodo del arbol
    private class NodoBST<E> {
        E dato = null;
        NodoBST<E> izq = null;
        NodoBST<E> der = null;

        public NodoBST(E dato) {
            this.dato = dato;
        }

        public NodoBST<E> buscarSucesor() {
            if (this.izq != null) {
                return this.izq.buscarSucesor();
            }
            return this;
        }

        public NodoBST<E> buscarPredecesor() {
            if (this.der != null) {
                return this.der.buscarPredecesor();
            }
            return this;
        }

    }

    // ----- desde aca son metodos del arbol ----------
    /* Agregar un dato al arbol */
    public void agregar(T dato) {
        raiz = priv_agregar(raiz, dato);
    }

    // Retorna el "nodo" donde se encuentra la primera ocurrencia del dato buscado
    public NodoBST<T> buscar(T dato) {
        NodoBST<T> nodo = priv_buscar(raiz, dato);
        if (nodo != null)
            return nodo;
        else { /* Reemplazar por manejo de excepcion!! */
            System.out.println("No existe en el arbol!!! " + dato);
            return null;
        }
    }

    // Imprime el arbol en inorden.
    public void imprimir() {
        System.out.println();
        priv_imprimir(raiz);
    }

    // Longitud del camino interno (ni idea de que hace)
    public int longitudCaminoInterno() {
        return priv_lci(raiz, 0);
    }

    // --- Metodos privados ---
    private NodoBST<T> priv_agregar(NodoBST<T> n_actual, T dato) {
        if (n_actual == null)
            return (new NodoBST<T>(dato));

        int comparacion = n_actual.dato.compareTo(dato);

        if (comparacion > 0)
            n_actual.izq = priv_agregar(n_actual.izq, dato);
        else
            n_actual.der = priv_agregar(n_actual.der, dato);

        return n_actual;
    }

    // Imprime en in-orden
    private void priv_imprimir(NodoBST<T> n_actual) {
        if (n_actual != null) {
            priv_imprimir(n_actual.izq);
            System.out.print(n_actual.dato + " ");
            priv_imprimir(n_actual.der);
        }
    }

    // busca un elemento dato en el arbol
    private NodoBST<T> priv_buscar(NodoBST<T> n_actual, T dato) {
        if (n_actual == null) // dato no se encuentra en el arbol
            return null;

        int comparacion = n_actual.dato.compareTo(dato);

        if (comparacion == 0) // dato == n_actual.dato
            return n_actual;
        else if (comparacion < 0) // dato < n_actual.dato, puede estar a la izquierda
            return priv_buscar(n_actual.izq, dato);
        else // dato > n_actual.dato, puede estar a la derecha
            return priv_buscar(n_actual.der, dato);
    }

    // Longitud de camino interno
    private int priv_lci(NodoBST<T> nodo, int nivel) {
        if (nodo == null)
            return 0;
        else
            return nivel + priv_lci(nodo.izq, nivel + 1) + priv_lci(nodo.der, nivel + 1);
    }

    // recorre inorden y guarda los nodos en el atributo "lista"
    private void inorden(NodoBST<T> nodo) {
        if (nodo.izq != null) {
            inorden(nodo.izq);
        }

        if (nodo != null) {
            lista.add(nodo.dato);
        }

        if (nodo.der != null) {
            inorden(nodo.der);
        }
    }

    public class iteratorImplem implements Iterator<Object> {
        int count = 0;

        public boolean hasNext() {
            if (lista.size() > count) {
                return true;
            }
            return false;
        }

        public Object next() {
            Object aux = lista.get(count);
            count++;
            return aux;
        }
    }

    public Iterator<Object> iterator() {
        lista = new ArrayList<>();
        inorden(raiz);
        return new iteratorImplem();
    }

    public ArrayList<T> claves(Integer min,Integer max) throws Exception{
        if (min > max) {
            throw new Exception("Claves invalidas");
        }

        if (min < 0 && max < 0 ) {
            throw new Exception("Claves invalidas");
        }

        lista = new ArrayList<>();
        inorden(raiz);

        ArrayList<T> aux = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            aux.add(lista.get(i));
        } 
        return aux;
    }

    public static void main(String[] args) {
        arbol<Integer> nuevo = new arbol<>();

        nuevo.agregar(5);
        nuevo.agregar(2);
        nuevo.agregar(1);
        nuevo.agregar(4);
        nuevo.agregar(8);
        nuevo.agregar(7);
        nuevo.agregar(9);

        // nuevo.imprimir();

        for (Object var : nuevo) {
            System.out.print(var);
        }
    }
}

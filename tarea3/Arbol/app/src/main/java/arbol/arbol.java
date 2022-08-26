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

import java.util.ArrayList;
import java.util.Iterator;

public class arbol<T extends Comparable<T>> implements Iterable<Object> {

    // clase que representa un nodo del arbol
    private class NodoBST<E> {
        Comparable<E> dato = null;
        NodoBST<E> izq = null;
        NodoBST<E> der = null;

        public NodoBST(Comparable<E> dato) {
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

    // raiz del arbol
    private NodoBST<T> raiz = null;

    // ----- desde aca son metodos del arbol ----------
    /* Agregar un dato al arbol */
    public void agregar(T dato) {
        raiz = priv_agregar(raiz, dato);
    }

    // eliminar elemento del arbol
    public void eliminar(T dato) {
        raiz = eliminar_privado(raiz, dato);
    }

    // eliminar elemento del arbol
    private NodoBST<T> eliminar_privado(NodoBST<T> actual, T dato) {
        if (actual.dato.compareTo(dato) == 0) { // el dato corresponde
            // ningun hijo
            if (actual.izq == null && actual.der == null) {
                return null;

                // un hijo
            } else if (actual.izq != null && actual.der == null) { // por izquierda
                return actual.izq;
            } else if (actual.der != null && actual.izq == null) { // por derecha
                return actual.der;

                // dos hijos
            } else {
                NodoBST<T> der = actual.der;
                NodoBST<T> temp = der.buscarSucesor();

                // reamplazar el dato con el sucesor
                temp = eliminar_privado(actual, dato);
                temp.izq = actual.izq;

                return temp;
            }

        } else {
            int comp = actual.dato.compareTo(dato);
            if (comp < 0) {
                actual.izq = eliminar_privado(actual.izq, dato);
            } else {
                actual.der = eliminar_privado(actual.der, dato);
            }
        }
        return actual;
    }

    // Retorna el "nodo" donde se encuentra la primera ocurrencia del dato buscado
    public Comparable<T> buscar(T dato) {
        NodoBST<T> nodo = priv_buscar(raiz, dato);
        if (nodo != null)
            return nodo.dato;
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

    // altura
    public int altura(int count, NodoBST<T> nodo) {
        if (nodo == null) {
            return count;
        }
        int izq = altura(count + 1, nodo.izq);
        int der = altura(count + 1, nodo.der);

        if (izq > der) {
            return izq;
        }
        return der;
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

        if (comparacion < 0)
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

    // imprimir el arbol tabulado
    public void imprimirTabulado(NodoBST<T> n_actual) {
        
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

    public class iteratorImplem implements Iterator<Object> {
        NodoBST<T> actual = raiz;
        ArrayList<NodoBST<T>> lista = inorden(raiz, new ArrayList<NodoBST<T>>());
        int count = 0;

        public boolean hasNext() {
            if (lista.size() - 1 > count) {
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
        return new iteratorImplem();
    }


    // recorrido inorden
    private ArrayList<NodoBST<T>> inorden(NodoBST<T> n_actual, ArrayList<NodoBST<T>> res) {
        if (n_actual != null) {
            res = inorden(n_actual.izq, res);
            res = inorden(n_actual.der, res);
        }
        res.add(n_actual);
        return res;
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

        for (Object var : nuevo) {
            System.out.println(var);
        }

    }
}

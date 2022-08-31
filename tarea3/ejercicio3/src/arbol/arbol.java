package arbol;

import java.util.ArrayList;

/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS III - Seccion TQ - Prof. Cristian Cappo / Prof. Luis More
 * Ing. Informatica
 * 2021-1er Periodo
 *
 * Implementa la clase BST (Arbol Binario de Busqueda)
 * El dato cuya referencia se almacena en cada nodo
 * es un Comparable o derivado. 
 */

public class arbol {
    // raiz del arbol
    private NodoBST raiz = null;

    // clase que representa un nodo del arbol
    private class NodoBST {
        Integer dato = null;
        NodoBST izq = null;
        NodoBST der = null;

        public NodoBST(Integer dato) {
            this.dato = dato;
        }

        public NodoBST buscarSucesor() {
            if (this.izq != null) {
                return this.izq.buscarSucesor();
            }
            return this;
        }

        public NodoBST buscarPredecesor() {
            if (this.der != null) {
                return this.der.buscarPredecesor();
            }
            return this;
        }

    }

    // ----- desde aca son metodos del arbol ----------
    /* Agregar un dato al arbol */
    public void agregar(Integer dato) {
        raiz = priv_agregar(raiz, dato);
    }

    // Retorna el "nodo" donde se encuentra la primera ocurrencia del dato buscado
    public NodoBST buscar(Integer dato) {
        NodoBST nodo = priv_buscar(raiz, dato);
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
    private NodoBST priv_agregar(NodoBST n_actual, Integer dato) {
        if (n_actual == null)
            return (new NodoBST(dato));

        int comparacion = n_actual.dato.compareTo(dato);

        if (comparacion > 0)
            n_actual.izq = priv_agregar(n_actual.izq, dato);
        else
            n_actual.der = priv_agregar(n_actual.der, dato);

        return n_actual;
    }

    // Imprime en in-orden
    private void priv_imprimir(NodoBST n_actual) {
        if (n_actual != null) {
            priv_imprimir(n_actual.izq);
            System.out.print(n_actual.dato + " ");
            priv_imprimir(n_actual.der);
        }
    }

    // busca un elemento dato en el arbol
    private NodoBST priv_buscar(NodoBST n_actual, Integer dato) {
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
    private int priv_lci(NodoBST nodo, int nivel) {
        if (nodo == null)
            return 0;
        else
            return nivel + priv_lci(nodo.izq, nivel + 1) + priv_lci(nodo.der, nivel + 1);
    }

    private void inorden(NodoBST nodo, ArrayList<NodoBST> lista) {
        if (nodo.izq != null) {
            inorden(nodo.izq, lista);
        }

        if (nodo != null) {
            lista.add(nodo);
        }

        if (nodo.der != null) {
            inorden(nodo.der, lista);
        }
    }

    // retorna el k esimo mas pequeno
    static public arbol Acc_greater(arbol arbol) {
        // arbol viejo a lista
        ArrayList<NodoBST> aux = new ArrayList<>();
        arbol.inorden(arbol.raiz, aux);

        ArrayList<Integer> aux2 = new ArrayList<>();
        for (int i = 0; i < aux.size(); i++) {
            aux2.add(aux.get(i).dato);
        }

        // recorro el array auxiliar
        for (int i = 0; i < aux.size(); i++) {
            // realizo la sumatoria
            int sumatoria = 0;
            for (int j = i; j < aux.size(); j++) {
                sumatoria += aux.get(j).dato;
            }
            aux2.set(i, sumatoria);
        }

        arbol copia = new arbol();
        for (int i = 0; i < aux2.size(); i++) {
            copia.agregar(aux2.get(i));
        }

        return copia;
    }

    public static void main(String[] args) {
        arbol nuevo = new arbol();
        arbol navidad = new arbol();

        nuevo.agregar(5);
        nuevo.agregar(2);
        nuevo.agregar(1);
        nuevo.agregar(4);
        nuevo.agregar(8);
        nuevo.agregar(7);
        nuevo.agregar(9);
        navidad.agregar(10);
        navidad.agregar(9);
        navidad.agregar(87);
        navidad.agregar(25);
        navidad.agregar(15);
        navidad.agregar(12);

        nuevo.imprimir();
        navidad.imprimir();

        arbol aux = arbol.Acc_greater(nuevo);
        arbol aux2 = arbol.Acc_greater(navidad);

        aux2.imprimir();
        aux.imprimir();

    }
}

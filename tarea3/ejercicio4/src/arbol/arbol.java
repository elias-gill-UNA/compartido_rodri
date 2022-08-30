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
    static public int compararArboles(arbol arbolA, arbol arbolB) throws Exception {
        // determinar que no sean la misma instancia
        if (arbolA == arbolB) { 
            throw new Exception("Es la misma instancia");
        } 

        // cargar el arbol A como lista con inorden
        ArrayList<NodoBST> a = new ArrayList<>(); // 1
        arbolA.inorden(arbolA.raiz, a); // n1

        // cargar el arbol B
        ArrayList<NodoBST> b = new ArrayList<>(); // 1
        arbolB.inorden(arbolB.raiz, b); // n2

        // arrays de diferente tamano implica arboles distintos
        if (b.size() != a.size()) { // 3
            return 3; 
        }
        
        // Ya tenemos la seguridad de que n1 y n2 tienen el mismo largo, por ende 
        // en el peor de los casos n1+n2 = 2n
        boolean forma = true; // 1
        for (int i = 0; i < a.size(); i++) { // n+1
            NodoBST aux = a.get(i); // n 
            NodoBST aux2 = b.get(i); // n
            // distintos es valor
            if (aux.dato != aux2.dato) { // n
                // retorna el caso 3
                return 3;
            }

            // si sus hijos no son iguales, distintos en forma
            if (aux.izq != null && aux2.izq != null) { // 2n
                if (aux.izq.dato != aux2.izq.dato) { // n
                    forma = false; // n
                }
            }

            // comparar hijos por derecha (forma)
            if (aux.der != null && aux2.der != null) { // 2n
                if (aux.der.dato != aux2.der.dato) { // n
                    forma = false; // n
                }
            }
        }
        // retorna el caso 1 si son iguales y 2 si son diferentes de forma
        return forma == true ? 1 : 2; // 1
        
        // CALCULO FINAL: PEOR CASO
        // t(n) = 13n + 6, en terminos de O grande: O(n) donde n es la cantidad de nodos de cualquiera
        // de los dos arboles
        
        // CALCULO FINAL: Mejor caso
        // Ignorando el caso donde la referencia es la misma, el mejor caso es cuando los tamanos son distintos,
        // Es decir, los arboles son distintos
        // t(n) = n1+n2 + 5, en terminos de O grande: O(h) donde h = n1+n2
    }

    public static void main(String[] args) {
        arbol nuevo = new arbol();
        nuevo.agregar(5);
        nuevo.agregar(2);
        nuevo.agregar(4);
        nuevo.agregar(8);
        nuevo.agregar(1);
        nuevo.agregar(7);
        nuevo.agregar(9);

        arbol nuevo2 = new arbol();
        nuevo2.agregar(5);
        nuevo2.agregar(2);
        nuevo2.agregar(1);
        nuevo2.agregar(4);
        nuevo2.agregar(8);
        nuevo2.agregar(7);
        nuevo2.agregar(9);

        try {
            System.out.println(arbol.compararArboles(nuevo2, nuevo));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

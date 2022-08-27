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
        if (nodo != null) {
            return nodo;
        } else {
            /* Reemplazar por manejo de excepcion!! */
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
        if (n_actual == null) {
            return (new NodoBST<T>(dato));
        }

        int comparacion = n_actual.dato.compareTo(dato);

        if (comparacion > 0) {
            n_actual.izq = priv_agregar(n_actual.izq, dato);
        } else {
            n_actual.der = priv_agregar(n_actual.der, dato);
        }

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
        {
            return null;
        }

        int comparacion = n_actual.dato.compareTo(dato);

        if (comparacion == 0) // dato == n_actual.dato
        {
            return n_actual;
        } else if (comparacion < 0) // dato < n_actual.dato, puede estar a la izquierda
        {
            return priv_buscar(n_actual.izq, dato);
        } else // dato > n_actual.dato, puede estar a la derecha
        {
            return priv_buscar(n_actual.der, dato);
        }
    }

    // Longitud de camino interno
    private int priv_lci(NodoBST<T> nodo, int nivel) {
        if (nodo == null) {
            return 0;
        } else {
            return nivel + priv_lci(nodo.izq, nivel + 1) + priv_lci(nodo.der, nivel + 1);
        }
    }

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
            return lista.size() > count;
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

    /*
    public ArrayList<NodoBST<T>> claves(Integer min,Integer max) throws Exception{
        if (min > max) {
            throw new Exception("Claves invalidas");
        }

        if (min < 0 && max < 0 ) {
            throw new Exception("Claves invalidas");
        }

        lista = new ArrayList<>();
        inorden(raiz);

        ArrayList<Integer> aux = new ArrayList<>();
        
        for (T var : lista) {
            if (var.compareTo(max) && var.compareTo(min) == 1 || var.compareTo(min) == 0 || var.compareTo(max) == 0) {
                
            }
        }
        return null;
    }
    */
  

    public void agregar_nodo_iterable(T dato) {
        NodoBST<T> nuevo = new NodoBST(dato);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            NodoBST aux = raiz;
            NodoBST padre;
            while (true) {
                padre = aux;
                int comprobar = dato.compareTo((T) aux.dato);
                if (comprobar < 0) {
                    aux = aux.izq;
                    if (aux == null) {
                        padre.izq = nuevo;
                        return;
                    }
                } else {
                    aux = aux.der;
                    if (aux == null) {
                        padre.der = nuevo;
                        return;
                    }
                }
            }

        }
    }
    public void eliminar_iterable(T dato){
        NodoBST<T> nuevo = new NodoBST(dato);
        NodoBST aux=raiz;
        NodoBST padre=raiz;
        boolean esHijoIzq=true;
        while (aux.dato!=dato){
            padre=aux;
             int comprobar = dato.compareTo((T) aux.dato);
            if(comprobar<0){
                esHijoIzq=true;
                aux=aux.izq;
            }else{
                esHijoIzq=false;
                aux=aux.der;
            }//Fin del Mientras que Busca el dato a Eliminar
        }
        //Comprobacion de los casos de eliminacion
        if(aux.izq==null && aux.der==null){
            if(aux==raiz){
                raiz=null;
            }else if(esHijoIzq){
                padre.izq=null;
            }else{
                padre.der=null;
            }
        }else if(aux.der==null){
            if(aux==raiz){
                raiz=aux.izq;
            }else if(esHijoIzq){
                padre.izq=aux.izq;
            }else{
                padre.der=aux.izq;
            }
        }else if(aux.izq==null){
            if(aux==raiz){
                raiz=aux.der;
            }else if(esHijoIzq){
                padre.der=aux.der;
            }else{
                padre.izq=aux.der;
            }
        }else{
            NodoBST reemplazo=obtener_reemplazo(aux);
            if(aux==raiz){
                raiz=reemplazo;
            }else if(esHijoIzq){
                padre.izq=reemplazo;
            }else{
                padre.der=reemplazo;
            }
            reemplazo.izq=aux.der;
        }
        //Metodo para buscar el reemplazo
       
    }
     public NodoBST obtener_reemplazo(NodoBST nod){
        NodoBST reemplazarPadre=nod;
        NodoBST reemplazo=nod;
        NodoBST auxiliar=nod.der;
        while(auxiliar!=null){
            reemplazarPadre=reemplazo;
            reemplazo=auxiliar;
            auxiliar=auxiliar.izq;
        }
        if(reemplazo!=nod.der){
            reemplazarPadre.izq=reemplazarPadre.der;
            reemplazo.der=nod.der;
        }
        return reemplazo;
    }
    public static void main(String[] args) {
        arbol<Integer> nuevo = new arbol<>();
        
        nuevo.agregar(5);
        nuevo.agregar(1);
        nuevo.agregar(2);
        nuevo.agregar(4);
        nuevo.agregar(8);
        nuevo.agregar(7);
        nuevo.agregar(9);
        nuevo.imprimir();
        nuevo.eliminar_iterable(2);
        nuevo.imprimir();
        
        
        /*
        
        for (Object var : nuevo) {
            System.out.print(var);
        }
        */
      
    }
}

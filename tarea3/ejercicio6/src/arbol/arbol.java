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
    private int cantidad_nodos=0;
    // clase que representa un nodo del arbol
    private class NodoBST<E> {

        E dato = null;
        NodoBST<E> izq = null;
        NodoBST<E> der = null;

        public NodoBST(E dato) {
            this.dato = dato;
        }

        public NodoBST<E> buscarSucesor(){//N(h)
            if (this.izq != null) {
                return this.izq.buscarSucesor();
            }
            return this;
        }

        public NodoBST<E> buscarPredecesor() {//N(h)
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
        cantidad_nodos++;
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
    public void agregar_nodo_iterable(T dato) {//6n+5 O(n)
        NodoBST<T> nuevo = new NodoBST(dato);//
        
        if (raiz == null) {//1
            raiz = nuevo;
        } else {
            NodoBST aux = raiz;//1
            NodoBST padre;
            while (true) {//n+1
                padre = aux;//1
                int comprobar = dato.compareTo((T) aux.dato);//1
                if (comprobar < 0) {//1
                    aux = aux.izq;//1
                    if (aux == null) {//1
                        padre.izq = nuevo;//1
                        break;
                    }
                } else {
                    aux = aux.der;
                    if (aux == null) {
                        padre.der = nuevo;
                        break;
                    }
                }
            }
        }
        cantidad_nodos++;//2
    }
    
    public void cant_hojas(){//6n+2 O(n)
        int c=0;//1
        for(Object elemento:this){//n+1
            NodoBST<T> aux=new NodoBST(elemento);//1
            if(aux.der==null && aux.izq==null){//2
                c++;//2
            }
        }
        System.out.println("Cantidad nodo hojas del arbol");
        System.out.println(c);
    }
    private int altura_arbol(NodoBST nodo){
        if (nodo==null){
            return 0;
        }
        return 1+Math.max(altura_arbol(nodo.izq),altura_arbol(nodo.der));
    }
    public int altura_del_arbol(){
        int h=altura_arbol(raiz);
        return h;
    }
    public void eliminar_iterable(T dato) { //12n+10 O(n)
        NodoBST<T> nuevo = new NodoBST(dato);//1
        NodoBST aux = raiz;//1
        NodoBST padre = raiz; //1  // para tener referencia al nodo padre
        boolean esHijoIzq = true;//1
        while (aux != null && aux.dato != dato) {//n+1
            padre = aux;
            int comprobar = dato.compareTo((T) aux.dato);//2
            if (comprobar < 0) {//1
                esHijoIzq = true;//1
                aux = aux.izq;//1
            } else {
                esHijoIzq = false;
                aux = aux.der;
            }//Fin del Mientras que Busca el dato a Eliminar
        }
        
        //Comprobacion de los casos de eliminacion
        if (aux.izq == null && aux.der == null) {//1 // es una hoja
            if (esHijoIzq) {//1
                padre.izq = null;//1
            } else {
                padre.der = null;
            }
        } else if (aux.der == null) {//1 // tiene un hijo a la izquierda
            NodoBST nodoBSTAux = aux.izq;// nodo sustituto
            // actualizamos los datos del nodo 
            aux.dato = nodoBSTAux.dato;
            aux.izq = nodoBSTAux.izq;
            aux.der = nodoBSTAux.izq;
        } else if (aux.izq == null) {  // tiene un hijo a la derecha
            NodoBST nodoBSTAux = aux.der; // nodo sustituto
            // actualizamos los datos del nodo 
            aux.dato = nodoBSTAux.dato;
            aux.izq = nodoBSTAux.izq;
            aux.der = nodoBSTAux.izq;
        } else { // el nodo que queremos eliminar tiene dos hijos :(

            NodoBST reemplazo = aux.der;//1

            while (reemplazo.izq != null) {//n+1
                padre = reemplazo;//1
                reemplazo = reemplazo.izq;//1
            }
  
            aux.dato = reemplazo.dato;//1
            if (reemplazo == aux.der) {//1
                aux.der = reemplazo.der;//1
            } else {
                padre.izq = reemplazo.der;
            }

        }
        cantidad_nodos--;
    }
    public boolean esLLeno(){//4n O(n)
        int k=altura_del_arbol();//1
        if ((2*k)-1==cantidad_nodos) {//1
            return true;//1
        } else {
            return false;//1
        }
    }
    public boolean esCompleto(){//6n O(n)
        int k=altura_del_arbol();//1
        if (((Math.pow(2, k))-1)==cantidad_nodos){//2+1
            return true;//1
        } else{
            return false;//1
        }
    }
     
    public static void main(String[] args) {
        arbol<Integer> nuevo = new arbol<>();
        
        nuevo.agregar(5);
        nuevo.agregar(1);
        nuevo.agregar(2);
        nuevo.agregar(4);
        nuevo.agregar(9);
        nuevo.agregar(8);
        nuevo.agregar(7);
        nuevo.imprimir();
        nuevo.cant_hojas();
       System.out.println(nuevo.esLLeno());
       System.out.println(nuevo.esCompleto());
       
        
        
        /*
        
        for (Object var : nuevo) {
            System.out.print(var);
        }
        */
      
    }
}

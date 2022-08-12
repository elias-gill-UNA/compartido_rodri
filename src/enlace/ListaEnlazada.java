/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enlace;

import java.util.Iterator;

/**
 *
 * @author Admin
 */
public class ListaEnlazada implements interfaz, Iterable<Object> {
    // Toda Lista enlazada cuenta con su nodo cabeza
    Nodo cabeza;

    public ListaEnlazada() {
        this.cabeza = null;// El Nodo Cabeza es Nulo por Defecto
    }

    // Metodo para añadir elementos de cualquier tipo a la lista enlazada
    public void anhadir(Object elemento) {
        if (cabeza == null) {
            cabeza = new Nodo(elemento);
        } else {
            Nodo temp = cabeza;
            Nodo nuevo = new Nodo(elemento);
            nuevo.agregar_nodo(temp);
            this.cabeza = nuevo;
        }
    }

    // meotodo para mostrar todos los elementos de la lista enlazada
    public void listar() {
        imprimir(cabeza);
    }

    private void imprimir(Nodo aux) {
        Nodo temporal = aux;
        while (temporal != null) {
            if (temporal.obtener_valor() instanceof ListaEnlazada) {
                Nodo a = ((ListaEnlazada) temporal.obtener_valor()).cabeza;
                imprimir(a);
            } else {
                System.out.println(temporal.obtener_valor());
            }
            temporal = temporal.obtenerSiguiente();
        }

    }

    public class iteratorImplem implements Iterator<Object> {
        Nodo actual = cabeza;

        public boolean hasNext() {
            if (actual.obtenerSiguiente() == null) {
                return false;
            }
            return true;
        }

        public Object next() {
            Object aux = actual.obtenerSiguiente();
            actual = actual.siguiente;
            return aux;
        }
    }

    public Iterator<Object> iterator() {
        return new iteratorImplem();
    }
}

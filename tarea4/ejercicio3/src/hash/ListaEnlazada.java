/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;

/**
 *
 * @author Admin
 */
public class ListaEnlazada<T> {
    // Toda Lista enlazada cuenta con su nodo cabeza
    Nodo<T> cabeza;

    public ListaEnlazada() {
        this.cabeza = null;// El Nodo<T> Cabeza es Nulo por Defecto
    }

    // Anadir un nuevo elemento a la lista enlazada
    public void add(T elemento) {
        if (cabeza == null) {
            cabeza = new Nodo<T>(elemento);
        } else {
            Nodo<T> temp = cabeza;
            Nodo<T> nuevo = new Nodo<>(elemento);
            nuevo.agregar_nodo(temp);
            this.cabeza = nuevo;
        }
    }

    // Eliminar un elemento de la lista enlazada
    private Nodo<T> delete(T elemento, Nodo<T> nodo) {
        if (elemento == nodo.valor) {
            return nodo.siguiente;
        }
        if (nodo.siguiente != null) {
            nodo.siguiente = delete(elemento, nodo.siguiente);
        }
        return nodo;
    }

    public ListaEnlazada<T> deletePublic(T elemento) {
        if (cabeza != null) {
            this.cabeza = delete(elemento, this.cabeza);
        }
        return this;
    }

    public void imprimir() {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.println(actual.valor);
            actual = actual.siguiente;
        }
    }

    public Boolean search(T value) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.valor == value) {
                return true;
            }
            actual = actual.siguiente;
        }

        return false;
    }
}

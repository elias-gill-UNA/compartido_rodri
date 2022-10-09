/*
    Grupo g22
    Gill Quintana, Elias Sebastian            CI: 5.223.284       Seccion TR
    Alvarenga Cavallero, Rodrigo              CI: 5.711.576       Seccion TR

    Tarea 6-U4 - Ejercicio II.1

  DECLARACIÓN DE HONOR
  • Nosotros Elias Gill y Rodrigo Alvarenga:

  • No hemos discutido el código fuente de nuestra tarea con ningún otro
  grupo, solo con el Profesor o el AER.

  • No hemos usado código obtenido de otro estudiante o de cualquier otra
  fuente no autorizada, modificada o no modificada.

  • Cualquier código o documentación utilizada en nuestro programa
  obtenido de fuentes, tales como libros o notas de curso, han sido claramente
  indicada en nuestra tarea.
*/

package programacion1;

/**
 * The {@code BTree} class represents an ordered symbol table of generic
 * key-value pairs.
 * It supports the <em>put</em>, <em>get</em>, <em>contains</em>,
 * <em>size</em>, and <em>is-empty</em> methods.
 * A symbol table implements the <em>associative array</em> abstraction:
 * when associating a value with a key that is already in the symbol table,
 * the convention is to replace the old value with the new value.
 * Unlike {@link java.util.Map}, this class uses the convention that
 * values cannot be {@code null}—setting the
 * value associated with a key to {@code null} is equivalent to deleting the key
 * from the symbol table.
 * <p>
 * This implementation uses a B-tree. It requires that
 * the key type implements the {@code Comparable} interface and calls the
 * {@code compareTo()} and method to compare two keys. It does not call either
 * {@code equals()} or {@code hashCode()}.
 * The <em>get</em>, <em>put</em>, and <em>contains</em> operations
 * each make log<sub><em>m</em></sub>(<em>n</em>) probes in the worst case,
 * where <em>n</em> is the number of key-value pairs
 * and <em>m</em> is the branching factor.
 * The <em>size</em>, and <em>is-empty</em> operations take constant time.
 * Construction takes constant time.
 * <p>
 * For additional documentation, see
 * <a href="https://algs4.cs.princeton.edu/62btree">Section 6.2</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 */
public class BTree<Key extends Comparable<Key>, Value> {
    // max children per B-tree node = M-1
    // (must be even and greater than 2)
    private static final int M = 4;

    private Node root; // root of the B-tree
    private int height; // height of the B-tree
    private int n; // number of key-value pairs in the B-tree

    // helper B-tree node data type
    private static final class Node {
        private int numChildrens; // number of children
        private Entry[] children = new Entry[M]; // the array of children

        // create a node with k children
        private Node(int k) {
            numChildrens = k;
        }
    }

    // internal nodes: only use key and next
    // external nodes: only use key and value

    private static class Entry {
        private Comparable key;
        private Object val;
        private Node next; // helper field to iterate over array entries

        public Entry(Comparable key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Initializes an empty B-tree.
     */
    public BTree() {
        root = new Node(0);
    }

    /**
     * Returns true if this symbol table is empty.
     * 
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * 
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }

    /**
     * Returns the height of this B-tree (for debugging).
     *
     * @return the height of this B-tree
     */
    public int height() {
        return height;
    }

    /**
     * Returns the value associated with the given key.
     *
     * @param key the key
     * @return the value associated with the given key if the key is in the symbol
     *         table
     *         and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to get() is null");
        return search(root, key, height);
    }

    @SuppressWarnings("unchecked")
    private Value search(Node x, Key key, int ht) {
        Entry[] children = x.children;

        // external node
        if (ht == 0) {
            for (int j = 0; j < x.numChildrens; j++) {
                if (eq(key, children[j].key))
                    return (Value) children[j].val;
            }
        }

        // internal node
        else {
            for (int j = 0; j < x.numChildrens; j++) {
                if (j + 1 == x.numChildrens || less(key, children[j + 1].key))
                    return search(children[j].next, key, ht - 1);
            }
        }
        return null;
    }

    /**
     * Inserts the key-value pair into the symbol table, overwriting the old value
     * with the new value if the key is already in the symbol table.
     * If the value is {@code null}, this effectively deletes the key from the
     * symbol table.
     *
     * @param key the key
     * @param val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val) {
        if (key == null)
            throw new IllegalArgumentException("argument key to put() is null");
        Node u = insert(root, key, val, height);
        n++;
        if (u == null)
            return;

        // need to split root
        Node t = new Node(2);
        t.children[0] = new Entry(root.children[0].key, null, root);
        t.children[1] = new Entry(u.children[0].key, null, u);
        root = t;
        height++;
    }

    private Node insert(Node actual, Key key, Value val, int ht) {
        int j;
        Entry tmp = new Entry(key, val, null);

        // si ya es nodo hoja
        if (ht == 0) {
            for (j = 0; j < actual.numChildrens; j++) {
                if (less(key, actual.children[j].key))
                    break;
            }
        }

        // buscar donde meter
        else {
            for (j = 0; j < actual.numChildrens; j++) {
                // insertar si es el penultimo elemento o la key es menor que el hijo siguiente
                if ((j + 1 == actual.numChildrens) || less(key, actual.children[j + 1].key)) {
                    Node u = insert(actual.children[j++].next, key, val, ht - 1);
                    if (u == null)
                        return null;
                    tmp.key = u.children[0].key;
                    tmp.val = null;
                    tmp.next = u;
                    break;
                }
            }
        }

        // correr los hijos a la izquierda desde donde se quedo
        for (int i = actual.numChildrens; i > j; i--)
            actual.children[i] = actual.children[i - 1];
        actual.children[j] = tmp;
        actual.numChildrens++;
        // si se lleno debemos partir el nodo
        if (actual.numChildrens < M)
            return null;
        else
            return split(actual);
    }

    // split node in half
    private Node split(Node nodo) {
        Node tmp = new Node(M / 2);
        nodo.numChildrens = M / 2;
        // rellenar con la mitad de nodos
        for (int j = 0; j < M / 2; j++)
            tmp.children[j] = nodo.children[M / 2 + j];
        return tmp;
    }

    /**
     * Returns a string representation of this B-tree (for debugging).
     *
     * @return a string representation of this B-tree.
     */
    public String toString() {
        return toString(root, height, "") + "\n";
    }

    private String toString(Node h, int ht, String indent) {
        StringBuilder s = new StringBuilder();
        Entry[] children = h.children;

        if (ht == 0) {
            for (int j = 0; j < h.numChildrens; j++) {
                s.append(indent + children[j].key + " " + children[j].val + "\n");
            }
        } else {
            for (int j = 0; j < h.numChildrens; j++) {
                if (j > 0)
                    s.append(indent + "(" + children[j].key + ")\n");
                s.append(toString(children[j].next, ht - 1, indent + "        "));
            }
        }
        return s.toString();
    }

    // metodo requerido por el ejercicio 1
    public void rangePrint(Key value1, Key value2) throws Exception {
        // determinar si el rango es valido
        if (less(value2, value1) || eq(value1, "") || eq(value2, "")) {
            throw new Exception("Valores de key invalidos");
        }

        // comprobar que los valores se encuentren en el arbol
        if (get(value1) == "" || get(value2) == "") {
            throw new Exception("Valores de key invalidos");
        }

        String s = rangePrint(root, height, "", value1, value2) + "\n";
        // demostrar que si se encontro un valor
        if (s.split("\n").length == 0) {
            throw new Exception("Valores vacios");
        }
        System.out.println(s);
    }

    private String rangePrint(Node h, int ht, String indent, Key value1, Key value2) {
        StringBuilder s = new StringBuilder();
        Entry[] children = h.children;

        if (ht == 0) {
            for (int j = 0; j < h.numChildrens; j++) {
                // si el valor esta en el rango lo imprimo
                if ((less(children[j].key, value2) && less(value1, children[j].key))
                        || eq(value1, children[j].key)
                        || eq(value2, children[j].key)) {

                    s.append(indent + children[j].key + " " + children[j].val + "\n");
                }
            }
        } else {
            for (int j = 0; j < h.numChildrens; j++) {
                if ((less(children[j].key, value2) && less(value1, children[j].key))
                        || eq(value1, children[j].key)
                        || eq(value2, children[j].key)) {

                    if (j > 0)
                        s.append(indent + "(" + children[j].key + ")\n");
                    s.append(rangePrint(children[j].next, ht - 1, indent + "     ", value1, value2));
                }
            }
        }
        return s.toString();
    }

    // comparison functions - make Comparable instead of Key to avoid casts
    @SuppressWarnings("unchecked")
    private boolean less(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) < 0;
    }

    @SuppressWarnings("unchecked")
    private boolean eq(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) == 0;
    }
}

/******************************************************************************
 * Copyright 2002-2022, Robert Sedgewick and Kevin Wayne.
 *
 * This file is part of algs4.jar, which accompanies the textbook
 *
 * Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne,
 * Addison-Wesley Professional, 2011, ISBN 0-321-57351-X.
 * http://algs4.cs.princeton.edu
 *
 *
 * algs4.jar is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * algs4.jar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with algs4.jar. If not, see http://www.gnu.org/licenses.
 ******************************************************************************/

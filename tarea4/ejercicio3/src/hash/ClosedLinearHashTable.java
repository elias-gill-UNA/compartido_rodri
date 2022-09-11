package hash;

import java.util.ArrayList;

public class ClosedLinearHashTable<E> {
    private int tableSize = 100;
    private int elements = 0;
    private ArrayList<El<E>> table = new ArrayList<>(tableSize);
	private double factorDeCarga;

    public int getTableSize() {
        return tableSize;
    }

    // crear la tabla de hash vacia
    public ClosedLinearHashTable(double factorDeCarga) {
        for (int i = 0; i < tableSize; i++) {
            table.add(null);
        }
        this.factorDeCarga = factorDeCarga;
    }

    // crear la tabla de hash vacia
    public ClosedLinearHashTable(double factorDeCarga, int size) {
        for (int i = 0; i < tableSize; i++) {
            table.add(null);
        }
        this.factorDeCarga = factorDeCarga;
        this.tableSize = size;
    }

    // anadir nuevo elemento
    public void add(E value) {
        // si el elemento ya existe no hacer nada
        if (search(value).status)
            return;

        // exploracion lineal
        for (int i = 0; i < tableSize; i++) {
            int hash = Math.abs(value.hashCode() + i) % tableSize;
            if (table.get(hash) == null || table.get(hash).status == false) {
                table.set(hash, new El<E>(value));
                elements++;
                break;
            }
        }

        // si pasamos el factor de carga debemos realizar un rehash
        if (elements / tableSize > factorDeCarga) {
            reHash();
        }
    }

    // buscar un elemento dentro de la tabla
    // Retornar una clase "Res" la cual cuenta con el status de la busqueda (boolean)
    // y el indice de haber sido encontrado. Ejemplo Res{status: true, index: 20}
    public Res search(E value) {
        for (int i = 0; i < tableSize; i++) {
            int hash = Math.abs(value.hashCode() + i) % tableSize;
            if (table.get(hash) == null) {
                return new Res(false);
            }

            if (table.get(hash) == value) {
                return new Res(true, hash);
            }
        }
        return new Res(false);
    }

    // anadir nuevo elemento
    public void delete(E value) {
        Res s = search(value);
        if (s.status == true) {
            // pone el elemento en modo "libre" para que pueda sobreescrito por otro
            table.set(s.index, new El<>(false));
            elements--;
        }
    }

    private void reHash() {
        ClosedLinearHashTable<E> aux = new ClosedLinearHashTable<>(factorDeCarga, tableSize * 2);

        // anadir uno por uno a la nueva tabla hash
        for (El<E> var : table) {
            if (var != null && var.status != false) {
                aux.add(var.value);
            }
        }

        // actualizar los valores de nuestra tabla hash original
        tableSize = aux.tableSize;
        table = aux.table;
    }

    // clase interna que simboliza el resultado de la operacion search
    private class Res {
        boolean status;
        int index;

        public Res(boolean status, int index) {
            this.status = status;
            this.index = index;
        }

        public Res(boolean status) {
            this.status = status;
            this.index = -1;
        }
    }
    private class El<T>{
        E value;
        boolean status = true; // borrado o disponible

        public El (E value) {
            this.value = value;
        }

        public El (boolean value) {
            this.status = value;
        }
    }
}

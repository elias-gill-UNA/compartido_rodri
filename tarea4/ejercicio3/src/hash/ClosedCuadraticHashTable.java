package hash;

import java.util.ArrayList;

public class ClosedCuadraticHashTable<E> {
    private int tableSize = 100;

    public int getTableSize(){
        return tableSize;
    }

    // ay java, todos te odian ... Yo tambien
    private ArrayList<ListaEnlazada<E>> table = new ArrayList<>();

    public ClosedCuadraticHashTable(){
        for (int i = 0; i < tableSize; i++) {
            table.add(new ListaEnlazada<>());
        } 
    }

    public ClosedCuadraticHashTable(int size){
        this.tableSize = size;
        for (int i = 0; i < tableSize; i++) {
            table.add(new ListaEnlazada<>());
        } 
    }

}

package hash;

import java.util.ArrayList;

public class ClosedDoubleHashTable<E> {
    private int tableSize = 100;

    public int getTableSize(){
        return tableSize;
    }

    // ay java, todos te odian ... Yo tambien
    private ArrayList<ListaEnlazada<E>> table = new ArrayList<>();

    public ClosedDoubleHashTable(){
        for (int i = 0; i < tableSize; i++) {
            table.add(new ListaEnlazada<>());
        } 
    }

    public ClosedDoubleHashTable(int size){
        this.tableSize = size;
        for (int i = 0; i < tableSize; i++) {
            table.add(new ListaEnlazada<>());
        } 
    }

}

package hash;

import java.util.ArrayList;

public class OpenHashTable<E> {
    private int tableSize = 100;

    public int getTableSize(){
        return tableSize;
    }

    // ay java, todos te odian ... Yo tambien
    private ArrayList<ListaEnlazada<E>> table = new ArrayList<>();

    public OpenHashTable(){
        for (int i = 0; i < tableSize; i++) {
            table.add(new ListaEnlazada<>());
        } 
    }

    public OpenHashTable(int size){
        this.tableSize = size;
        for (int i = 0; i < tableSize; i++) {
            table.add(new ListaEnlazada<>());
        } 
    }

    /**
     * @param value
     * @return
     *         Retorna true si el elemento ha sido encontrado, en caso contrario
     *         retorna falso
     */
    public Boolean searchElement(E value) {
        return table.get(Math.abs(value.hashCode()) % tableSize).search(value);
    }

    /**
     * @param value
     * @return
     *         Anade un nuevo elemento dentro de la tabla solo si no se encunetra
     *         repetido
     */
    public void addElement(E value) {
        if (!this.searchElement(value)) {
            table.get(Math.abs(value.hashCode()) % tableSize).add(value);
        }
    }

    public void deleteElement(E value) {
        int hash = Math.abs(value.hashCode()) % tableSize;
        table.set(hash, table.get(hash).deletePublic(value));
    }

    public static void main(String[] args) {
        OpenHashTable<Integer> foo = new OpenHashTable<>();

        for (int i = 0; i < foo.getTableSize(); i++) {
            foo.addElement(i * 1098/(i+1));
        }

        System.out.println(foo.searchElement(3));
        foo.deleteElement(1098);
        System.out.println(foo.searchElement(3));
    }
}

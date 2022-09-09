package hash;

public class OpenHashTable<E> {

    // ay java, todos te odian ... Yo tambien
    @SuppressWarnings("unchecked") 
    private Nodos<E>[] table = (Nodos[]) new Object[100];

    public Boolean searchElement(E value){
        return table[Math.abs(value.hashCode()) % 100].search(value);
    }

    public void addElement(E value){
        table[Math.abs(value.hashCode()) % 100].add(value);
    }

    public static void main(String[] args) {
    }
}

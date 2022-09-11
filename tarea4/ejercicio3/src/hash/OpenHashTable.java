package hash;

import java.util.ArrayList;

public class OpenHashTable<E> {

	private int tableSize = 100;

	public int getTableSize() {
		return tableSize;
	}

	// ay java, todos te odian ... Yo tambien
	private ArrayList<ListaEnlazada<E>> table = new ArrayList<>();

	public OpenHashTable() {
		for (int i = 0; i < tableSize; i++) {
			table.add(new ListaEnlazada<>());
		}
	}

	public OpenHashTable(int size) {
		this.tableSize = size;
		for (int i = 0; i < tableSize; i++) {
			table.add(new ListaEnlazada<>());
		}
	}

	/**
	 * @param value
	 * @return Retorna true si el elemento ha sido encontrado, en caso contrario retorna falso
	 */
	public Boolean search(E value) {
		return table.get(Math.abs(value.hashCode()) % tableSize).search(value);
	}

	/**
	 * @param value
	 * @return Anade un nuevo elemento dentro de la tabla solo si no se encunetra repetido
	 */
	public void add(E value) {
		if (!this.search(value)) {
			table.get(Math.abs(value.hashCode()) % tableSize).add(value);
		}
	}

	public void delete(E value) {
		int hash = Math.abs(value.hashCode()) % tableSize;
		table.set(hash, table.get(hash).deletePublic(value));
	}
}

package busqueda;

public class Main {
    public static void main(String[] args) {
        Integer prueba[] = { 1,2,3,4,5 };
        Repetidos<Integer> desrepetidor = new Repetidos<>();

	for (Object e: desrepetidor.eliminarRepetidos(prueba)) {
		System.out.print(e + " ");
	}
    }
}

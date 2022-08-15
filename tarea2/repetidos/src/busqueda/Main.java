package busqueda;

public class Main {
    public static void main(String[] args) {
        Integer prueba[] = { 1, 2, 3, 4, 5 };
        Repetidos<Integer> desrepetidor = new Repetidos<>();

        for (Object e : desrepetidor.eliminarRepetidos(prueba)) {
            System.out.print(e + " ");
        }

        String p[] = {"hola", "nombre", "nombre",  "nombre",  "nombre",  "nombre"};
        Repetidos<String> des = new Repetidos<>();

        for (Object e : des.eliminarRepetidos(p)) {
            System.out.print(e + " ");
        }
    }
}

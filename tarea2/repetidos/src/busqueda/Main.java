package busqueda;

/*
	Grupo g10
	Díaz Barrio, Abel Moisés            CI: 5.404.806       Seccion TR
	Román Medina ,Andrés Moisés         CI: 5.436.434       Seccion TR

	Tarea 2-U2 - Ejercicio II.1
 */

public class Main {
    public static void main(String[] args) {
        Integer prueba[] = { 1, 2, 3, 4, 5};
        Repetidos<Integer> desrepetidor = new Repetidos<>();

        for (Object e : desrepetidor.eliminarRepetidos(prueba)) {
            System.out.print(e + " ");
        }

        String p[] = {"hola", "nombre", "nombre",  "nombre",  "nombre",  "nombre"};
        Repetidos<String> des = new Repetidos<>();

        System.out.println("");
        for (Object e : des.eliminarRepetidos(p)) {
            System.out.print(e + " ");
        }
    }
}

 /*
    DECLARACIÓN DE  HONOR
• Nosotros Abel Díaz y Andrés Román:

• No hemos discutido el código fuente de nuestra tarea con ningún otro 
  grupo, solo con el Profesor o el AER.

• No hemos usado código obtenido de otro estudiante o de cualquier otra 
  fuente no autorizada, modificada o no modificada.

• Cualquier código o documentación utilizada en nuestro programa 
  obtenido de fuentes, tales como libros o notas de curso, han sido claramente 
  indicada en nuestra tarea.
 */

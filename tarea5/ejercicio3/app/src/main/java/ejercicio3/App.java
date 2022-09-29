/*
    Grupo g22
    Gill Quintana, Elias Sebastian            CI: 5.223.284       Seccion TR
    Alvarenga Cavallero, Rodrigo              CI: 5.711.576       Seccion TR

    Tarea 2-U2 - Ejercicio II.1

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
package ejercicio3;

class App<T> {
    // Funcion para encontrar un elemento en un arreglo circular
    public int searchCircularArray(Comparable[] nums, Comparable<T> buscado) {
        int izquierda = 0;
        int derecha = nums.length - 1;

        // ciclar hasta llegar a la mitad
        while (izquierda <= derecha) {
            // encontrar el valor del medio del arreglo
            int medio = (izquierda + derecha) / 2;

            // comparar si es que es igual al valor buscado
            // si el valor es encontrado entonces retorna el indice
            if (buscado == nums[medio]) {
                return medio;
            }

            // Si no se ha encontrado el elemento y la mitad derecha esta arreglada
            if (nums[medio].compareTo(nums[derecha]) == -1 || nums[medio].compareTo(nums[derecha]) == 0 ) {
                // comparar con el elemento mas a la derecha para ver si el valor se encuentra
                // en esa parte
                if (nums[medio].compareTo(buscado) == -1 && (nums[derecha].compareTo(buscado) == 1 || nums[derecha].compareTo(buscado) == 0)) {
                    // buscar a la derecha
                    izquierda = medio + 1;
                } else {
                    // sino buscar a la izquierda
                    derecha = medio - 1;
                }
            }

            // si la mitad derecha no esta ordenada entonces buscamos en la mitad izquierda
            else {
                // comparar con el elemento mas a la izquierda para ver si el valor se encuentra
                // en esa parte
                if ((nums[derecha].compareTo(buscado) == -1 || nums[derecha].compareTo(buscado) == 0) && nums[medio].compareTo(buscado) == 1) {
                    // buscar a la izquierda
                    derecha = medio - 1;
                } else {
                    // sino buscar a la derecha
                    izquierda = medio + 1;

                }
            }
        }

        // retorna -1 si no se encontro
        return -1;
    }

    public static void main(String[] args) {
        Integer[] nums = { 9, 10, 2, 5, 6, 8 };
        int bus = 9;

        App app = new App();
        int indice = app.searchCircularArray(nums, bus);

        if (indice != -1) {
            System.out.println("Encontrado en el indice: " + indice);
        } else {
            System.out.println("Elemento no encontrado");
        }
    }
}

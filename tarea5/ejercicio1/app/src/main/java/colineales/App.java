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
package colineales;

public class App {

    public class punto {
        int x;
        int y;

        public punto(int x, int y) {
            this.y = y;
            this.x = x;
        }
    }

    public punto[] valoresPrueba() {
        punto[] res = { new punto(2, 3), new punto(1, 2), new punto(3, 4), new punto(4, 5), new punto(5, 6) };
        return res;
    }

    // este metodo tiene eficiencia O(N^3)
    public static punto[][] getAllPosibilities(punto valores[]) {
        int filas_necesarias = (int) Math.pow(2, valores.length); // 1
        punto aux[][] = new punto[filas_necesarias][valores.length]; // 1
        int intercalar = (int) Math.pow(2, valores.length); // 1

        // Para hallar las combinaciones posibles, cargamos los valores como si se
        // tratase de una tabla de verdad
        for (int columna = 0; columna < (valores.length); columna++) { // n+1
            intercalar = intercalar / 2; // n
            boolean state = true; // n

            int counter = 1; // n
            for (int fila = 0; fila < (filas_necesarias); fila++) { // n (n^2), ya que necesitamos n^2 filas para
                                                                    // conseguir todas las posibilidades
                // cargamos el valor si state == true
                if (state) {
                    aux[fila][columna] = valores[columna];
                } else {
                    aux[fila][columna] = null;
                }

                // realizamos el cambio de estado
                counter++;
                if (counter > intercalar) {
                    counter = 1;
                    state = !state;
                }
            }
        }
        return aux;
    }

    // este metodo tiene coste O(n), ya que lo unico que realiza
    // es recorrer una fila entera de la matriz de posibilidades, la cual es de
    // largo N, comparando uno a uno las pendientes para determinar su colinealidad
    public static boolean sonColineales(punto valores[]) {
        // buscar y contar aquellos elementos del array de combinatoria que no son nulos
        int cont = 0;
        for (punto var : valores) { // n
            if (var != null) {
                cont++;
            }
        }

        // si no son 4 puntos no hagas nada
        if (cont < 4) { // 1
            return false;
        }

        // crear un arreglo auxiliar SOLO con los puntos que no son nulos
        punto aux[] = new punto[cont];
        int i = 0;
        for (punto var : valores) { // n
            if (var != null) {
                aux[i] = var;
                i++;
            }
        }

        // calcular las pendientes una a una
        int pendiente = (aux[0].y - aux[1].y) / (aux[0].x - aux[1].x);
        for (i = 1; i < cont - 1; i++) { // n
            if (pendiente != (aux[i].y - aux[i + 1].y) / (aux[i].x - aux[i + 1].x)) {
                return false;
            }
        }
        // ecuacion final n + n + n = O(n)
        return true;
    }

    // funcion que recibe un arreglo de puntos
    static public void programa(punto valores[]) {
        // Primero obtenemos todas las combinaciones posibles del arreglo de puntos
        // Esto lo realizamos usando la tecnica de la "tabla de verdad"

        // instanciar la matriz auxiliar usando
        punto posibilidades[][] = getAllPosibilities(valores); // O(n^3)
        int filas_necesarias = (int) Math.pow(2, valores.length); // 1
        System.out.println("Las combinaciones de puntos colineales son:");

        // por cada combinacion de puntos calculamos su pendiente
        for (int i = 0; i < (filas_necesarias); i++) { // n^2
            if (sonColineales(posibilidades[i])) { // n^2 * O(n)
                for (int k = 0; k < (valores.length); k++) { // n^2 * n
                    if (posibilidades[i][k] != null) {
                        System.out.print("(" + posibilidades[i][k].x + "," + posibilidades[i][k].y + ") ");
                    }
                }
                System.out.println();
            }
        }
        // el ciclo completo cuenta con un tiempo de ejecucion de O(n^3), por ende
        // nuestra ecuacion
        // queda: O(n^3) + O(n^3) + 4 = O(n^3) , siendo este el coste algoritmico del
        // programa en cuestion
    }

    // main
    public static void main(String[] args) {
        // generar nuevos valores de prueba
        App foo = new App();
        punto aux[] = foo.valoresPrueba();

        programa(aux);
    }
}

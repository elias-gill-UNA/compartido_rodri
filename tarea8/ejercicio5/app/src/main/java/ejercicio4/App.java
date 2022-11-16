/*
    Grupo g22
    Gill Quintana, Elias Sebastian            CI: 5.223.284       Seccion TR
    Alvarenga Coronel, Rodrigo                CI: 5.711.576       Seccion TR

    Tarea 5-U3 - Ejercicio I

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
class AsignacionCombustible {
    static int MEJORBENEFICIO(int H, int[][] G) {
        int[] pilah = new int[G.length]; // asignacion de combustible por maquina
        int[] beneficios = new int[G.length]; // beneficion obtenido por maquina

        int maq = 0;
        int beneficio = 0;
        int MejorBeneficio = 0;
        int BeneficioActual = 0;
        int sumah = 0;

        pilah[maq] = -1; // inicializacion a -1 combustible,se da un valor valido dentro del ciclo
        while (maq >= 0) {
            pilah[maq]++; // aumentar la asingación de combustible a la maquina actual con un valor valido
            // si existe suficiente combustible para dicha asignación
            if (sumah + pilah[maq] <= H) {
                // calcula del beneficio por la última asignación
                beneficio = pilah[maq] > 0 ? G[maq][pilah[maq] - 1] : 0;
                BeneficioActual += beneficio; // acumulación al total de beneficio
                beneficios[maq] += beneficio; // acumulacion al total de beneficio de la maquina

                // si no es la última maquina
                // avanza para asignar a una maquina siguiente
                if (maq < G.length - 1) {
                    // inicializa lo asignado, se da un valor valido en la primera iteración. Si es
                    // la ultima maquina y utilizo todo el combustible posible además de tener un
                    // mejor beneficio
                    sumah += pilah[maq]; // aumenta el valor del combustible asignado a los anteriores
                    maq++; // se dirige a la siguiente maquina
                    pilah[maq] = -1;
                } else if (sumah + pilah[maq] == H && BeneficioActual > MejorBeneficio) {
                    MejorBeneficio = BeneficioActual; // actualiza el valor del MejorBeneficio
                }
            } else {
                BeneficioActual -= beneficios[maq]; // quitar el beneficio de la ultima maquina
                beneficios[maq] = 0; // quitar el beneficio de la última maquina
                sumah = maq > 0 ? sumah - pilah[maq - 1] : 0; // quitar el beneficio de la maquina anterior
                maq--; // disminuir el numero de la maquina actual
            }
        }
        return MejorBeneficio;
    }

    public static void main(String[] args) {
        int[][] beneficios; // tabla de beneficio de los behiculos por unidades de combustible asignado.
        int combustible; // total de combustible disponible

        combustible = 3;
        beneficios = new int[][] { { 70, 10, 20 }, { 30, 70, 0 }, { 35, 40, 25 } };
        System.out.print("El mejor beneficio es: " + MEJORBENEFICIO(combustible, beneficios));
    }
}

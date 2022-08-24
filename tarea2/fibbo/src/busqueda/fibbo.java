package busqueda;
/*
	Grupo g10
	Díaz Barrio, Abel Moisés            CI: 5.404.806       Seccion TR
	Román Medina ,Andrés Moisés         CI: 5.436.434       Seccion TR

	Tarea 2-U2 - Ejercicio II.1
 */
public class fibbo {

    // serie de fibbonacci por recursividad
    static public int fibboRecursivo(int goal) {
        if (goal == 1) {
            return 1;
        } else if (goal == 0) {
            return 0;
        } else {
            return fibboRecursivo(goal - 1) + fibboRecursivo(goal - 2);
        }
    }

    // serie de fibbonacci ciclica
    static public int fibboCiclico(int goal) {
        goal = goal + 1;
        int[] aux = new int[goal];
        aux[0] = 0;

        // evitar error cuando se pide fibbo de 0
        if (goal > 1){
            aux[1] = 1;
        }

        // buscar el numero de fibbo
        for (int i = 2; i < goal; i++) {
            aux[i] = aux[i-1] + aux[i-2];
        }
        return aux[goal-1];
    }
}

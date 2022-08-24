/*
	Grupo g10
	Díaz Barrio, Abel Moisés            CI: 5.404.806       Seccion TR
	Román Medina ,Andrés Moisés         CI: 5.436.434       Seccion TR

	Tarea 2-U2 - Ejercicio II.1
 */

package busqueda;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * metodo resive un array de objetos y retorna Object[] con los elementos sin
 * repetir
 */
public class Repetidos<T> {
    public ArrayList<T> eliminarRepetidos(T algo[]) {
        // tabla que guarda los elementos repetidos
        HashMap<T, Boolean> repetidos = new HashMap<>();

        // Utilizando Arraylist, creamos un array que contiene el resultado
        ArrayList<T> res = new ArrayList<>();

        // internamente es un for de 0 a n
        for (T e : algo) {

            // si el elemento no esta repetido lo agrega
            if (!repetidos.containsKey(e)) {

                res.add(e);
                repetidos.put(e, true);
            }
        }
        return res;
    }
}

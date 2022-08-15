package busqueda;

import java.util.ArrayList;
import java.util.HashMap;

public class Repetidos<T> {

    /*
     * metodo resive un array de objetos y retorna Object[] con los elementos sin
     * repetir
     */
    public Object[] eliminarRepetidos(T algo[]) {
        /*
         * El analisis de este algoritmo se va a hacer tomando el peor de los casos
         * posibles,
         * el cual es que no exista elemento repetido
         */

        // tabla que guarda los elementos repetidos
        HashMap<T, Boolean> repetidos = new HashMap<>();

        // Utilizando Arraylist, creamos un array que contiene el resultado
        ArrayList<T> res = new ArrayList<>(); // 1

        // internamente es un for de 0 a n
        for (T e : algo) { // n+1

            // si el elemento no esta repetido lo agrega al array resultado
            // Una tabla hash es de acceso en tiempo constante y se realizan 2 operaciones
            // (if y search)
            if (!repetidos.containsKey(e)) { // 2n

                // segun la documentacion oficial de java, la operacion "add" de Arraylist
                // es de tiempo constante O(1)
                res.add(e); // n
                repetidos.put(e, true); // n
            }
        }
        // parcial: 4n+6 -> O(n)

        return res.toArray(); // O(n)

        // por tanto el tiempo final de ejecucion es de O(n)
    }
}

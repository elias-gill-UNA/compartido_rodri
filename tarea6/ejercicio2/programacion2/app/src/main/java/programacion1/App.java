/*
    Grupo g22
    Gill Quintana, Elias Sebastian            CI: 5.223.284       Seccion TR
    Alvarenga Cavallero, Rodrigo              CI: 5.711.576       Seccion TR

    Tarea 6-U4 - Ejercicio II.2

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

package programacion1;

public class App {

    /**
     * Unit tests the {@code BTree} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        BTree<String, String> st;
        try {
            if (args.length > 0) {
                st = new BTree<String, String>(Integer.parseInt(args[0]));
            } else { // poner valor por defecto
                st = new BTree<String, String>(4);
            }

            st.put("www.cs.princeton.edu", "128.112.136.12");
            st.put("www.cs.princeton.edu", "128.112.136.11");
            st.put("www.princeton.edu", "128.112.128.15");
            st.put("www.yale.edu", "130.132.143.21");
            st.put("www.simpsons.com", "209.052.165.60");
            st.put("www.apple.com", "17.112.152.32");
            st.put("www.amazon.com", "207.171.182.16");
            st.put("www.ebay.com", "66.135.192.87");
            st.put("www.cnn.com", "64.236.16.20");
            st.put("www.google.com", "216.239.41.99");
            st.put("www.nytimes.com", "199.239.136.200");
            st.put("www.microsoft.com", "207.126.99.140");
            st.put("www.dell.com", "143.166.224.230");
            st.put("www.slashdot.org", "66.35.250.151");
            st.put("www.espn.com", "199.181.135.201");
            st.put("www.weather.com", "63.111.66.11");
            st.put("www.yahoo.com", "216.109.118.65");

            System.out.println("cs.princeton.edu:  " + st.get("www.cs.princeton.edu"));
            System.out.println("hardvardsucks.com: " + st.get("www.harvardsucks.com"));
            System.out.println("simpsons.com:      " + st.get("www.simpsons.com"));
            System.out.println("apple.com:         " + st.get("www.apple.com"));
            System.out.println("ebay.com:          " + st.get("www.ebay.com"));
            System.out.println("dell.com:          " + st.get("www.dell.com"));
            System.out.println();

            System.out.println("size:    " + st.size());
            System.out.println("height:  " + st.height());
            System.out.println("M value: " + st.getM());
            System.out.println(st);
            System.out.println();

            // excepcion
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

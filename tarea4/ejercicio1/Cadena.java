package cadena;
import java.util.ArrayList;
import java.util.HashMap;

public class Cadena {

    public static void main(String[] args) {
        HashMap<String, Boolean> diccionario = new HashMap<>();
        diccionario.put("Holamundo", true);
        diccionario.put("Holamundo", true);
        diccionario.put("Hola2mundo", true);
        diccionario.put("hola5", true);
        diccionario.put("hola", true);
        String pal = "y1Holamundo";

        int a = 0;
        if (pal.length() < 8) {
            System.out.println("La Contraseña no es segura");
            a = 1;
        } else if (true) {
            for (String b : pal.split("[0-9]", 0)) {
                if (!b.isEmpty() && diccionario.containsKey(b) == true) {
                    System.out.println("La Contraseña no es segura");
                    a = 1;
                    break;
                }
            }
            if (a == 0) {
                System.out.println("La Contraseña es segura");
            }
        }

    }

}

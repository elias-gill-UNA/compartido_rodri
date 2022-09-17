import java.util.ArrayList;
import java.util.HashMap;

public class Cadena {

    public static void main(String[] args) {
        HashMap<String, Boolean> diccionario = new HashMap<>();

        try {
            BufferedReader file = new BufferedReader(
                    new FileReader("/home/elias/Documentos/compartido_rodri/tarea4/es_ES.dic"));

            // leer las lineas del archivo
            try {
                String currentLine = file.readLine().split("/")[0];
                while (currentLine != null) {
                    diccionario.put(currentLine);
                    currentLine = file.readLine().split("/")[0];
                }
            } catch (Exception e) {
                System.out.println(e);
            }

            file.close();

        } catch (Exception e) {
            System.out.println("No se puede leer el archivo");
        }

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

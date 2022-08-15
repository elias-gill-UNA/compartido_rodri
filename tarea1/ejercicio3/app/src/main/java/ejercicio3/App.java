package ejercicio3;

public class App {
    public static void main(String[] args) {
        System.out.println("Polinomios originales");
        Polinomio pol1 = new Polinomio("1x^2 + 1x^0");
        Polinomio pol2 = new Polinomio("1x^1 + 2x^2 + 1x^0");

        System.out.println(pol1.toString());
        System.out.println(pol2.toString());

        Polinomio suma = pol1.sumar(pol2);
        System.out.println("\nSuma de polinomios: " + suma.toString());

        Polinomio multiplicacion = pol1.multiplicarPolinomio(pol2);
        System.out.println("Multiplicacion de polinomios: " + multiplicacion.toString());

        Polinomio derivada = pol1.derivar();
        System.out.println("Derivada de polinomios: " + derivada.toString());

        Polinomio derivada2 = pol2.derivar();
        System.out.println("Derivada de polinomios: " + derivada2.toString());
    }
}

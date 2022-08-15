package ejercicio3;

import java.math.BigDecimal;

/*
 * Clase que representa a un monomio de un polinomio mas grande
 */
public class Monomio {
    int exponente;
    BigDecimal coeficiente;

    public Monomio(int exponente, BigDecimal coeficiente) {
        this.coeficiente = coeficiente;
        this.exponente = exponente;
    }

    public Monomio(int exponente) {
        this.coeficiente = new BigDecimal(0);
        this.exponente = exponente;
    }

    // permite derivar el monomio independientemente
    public Monomio derivada() {
        // la derivada de un termino con parte algebraica
        if (exponente > 0) {
            this.coeficiente = this.coeficiente.multiply(new BigDecimal(this.exponente));
            this.exponente -= 1;
            return this;
        }
        // la derivada de la constante (exponente de x igual a 0) devuelve nulo (0)
        return null;
    }

    // metodo que realiza la suma de otro monomio al monomio "padre"
    // Retorna el monomio sumado
    public Monomio sumar(Monomio sumando) {
        this.coeficiente.add(sumando.coeficiente);
        return this;
    }

    // metodo que realiza la suma de otro monomio al monomio "padre"
    // Retorna el monomio sumado
    public Monomio multiplicar(Monomio multiplicando) {
        this.coeficiente.multiply(multiplicando.coeficiente);
        this.exponente += multiplicando.exponente;
        return this;
    }
}

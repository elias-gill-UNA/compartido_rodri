package ejercicio3;

import java.math.BigDecimal;
import java.util.InputMismatchException;

public class Polinomio {
    // un polinomio es una lista de monomios
    Monomio[] contenido;
    int largo;

    // constructor para generar un polinomio vacio de grado n-1
    // Recibe el LARGO del polinomio ([grado-1], no olvidar el termino
    // independiente)
    public Polinomio(int size) {
        this.contenido = new Monomio[size];
        this.largo = size;
        // rellenar con el exponente que le corresponde
        for (int i = 0; i < size; i++) {
            this.contenido[i] = new Monomio(i);
            this.contenido[i].exponente = i;
        }
    }

    // constructor para cargar el polinomio a partir de una cadena de texto
    public Polinomio(String cadena) throws InputMismatchException {
        // eliminar espacios y guardar un arreglo de subcadenas (monomios)
        cadena = cadena.replaceAll("\\s+", "");
        String[] aux = cadena.split("\\+");

        // hacer la comprobacion de exponentes y sacar grado del polinomio
        int grado = 0;
        for (String var : aux) {
            // aislar exponente
            int l = Integer.parseInt(var.split("\\^")[1]);
            // comprobar que no sea exponente negativo
            if (l < 0) {
                throw new InputMismatchException("El formato invalido. Exponente negativo");
            }
            if (grado < l) {
                grado = l;
            }
        }

        // un polinomio con un largo igual al termino de mayor exponente
        Polinomio pol = new Polinomio(grado + 1);

        // cada elemento del split corresponde a un monomio
        // Insertar de manera invertida para poder sumar mas facilmente
        for (String i : aux) {
            // separar conforme a la x
            String[] desgloce = i.split("x");

            // crear un monomio de la expresion generada
            try {
                Monomio monomio = new Monomio(
                        Integer.parseInt(desgloce[1].replaceAll("\\^", "")),
                        new BigDecimal(desgloce[0]));
                // asignar el monomio a la posicion de su exponente
                pol.contenido[monomio.exponente] = monomio;
            } catch (Exception e) {
                throw new InputMismatchException("El formato del polinomio es invalido");
            }
        }
        // asignar el polinomio final (lista de monomios)
        this.contenido = pol.contenido;
        this.largo = pol.largo;
    }

    // constructor a partir de una lista de monomios
    public Polinomio(Monomio[] lista) throws Exception {

        if (lista == null) {
            throw new Exception("La lista de inicializacion no puede estar vacia");
        }

        int largo = 0;
        // sacar el grado del polinomio
        for (Monomio i : lista) {
            if (largo < i.exponente) {
                largo = i.exponente;
            }
        }
        Polinomio pol = new Polinomio(largo + 1);

        // cada elemento del split corresponde a un monomio
        // Insertar de manera invertida para poder sumar mas facilmente
        for (Monomio i : lista) {
            // crear un monomio de la expresion generada
            pol.contenido[i.exponente] = i;
        }
        // asignar el polinomio final (lista de monomios)
        this.contenido = pol.contenido;
        this.largo = pol.largo;
    }

    // representar polinomio en formato cadena
    public String toString() {
        String res = "";

        for (int i = this.largo - 1; i > 0; i--) {
            Monomio a = this.contenido[i];
            if (a.coeficiente.floatValue() != 0) {
                if (a.coeficiente.floatValue() != 1) {
                    res += a.coeficiente.toString();
                }
                res += "x";
                if (a.exponente != 1) {
                    res += "^" + a.exponente;
                }
                res += " + ";
            }
        }

        res += this.contenido[0].coeficiente.toString();
        return res;
    }

    // Realiza la suma de un polinomio por otro
    // Retorna la suma de polinomios (no modifica el polinomio original)
    public Polinomio sumar(Polinomio sumando) {
        // el grado es igual al grado del polinomio mayor
        int mayor = (sumando.largo > this.largo) ? sumando.largo : this.largo;
        Polinomio res = new Polinomio(mayor);

        for (int i = 0; i < mayor; i++) {
            // realiza la suma sin mayor inconveniente
            if (i < this.largo && i < sumando.largo) {
                // suma de coeficientes
                res.contenido[i].coeficiente = res.contenido[i].coeficiente.add(
                        sumando.contenido[i].coeficiente.add(this.contenido[i].coeficiente));
            } else {
                // en caso de no tener mas elementos en un sumando
                // entonces asignamos el valor del otro sumando
                if (i < this.largo) {
                    res.contenido[i].coeficiente.add(this.contenido[i].coeficiente);
                } else {
                    res.contenido[i].coeficiente = sumando.contenido[i].coeficiente;
                }
            }
        }
        return res;
    }

    // funcion para multiplicar dos polinomios
    // Retorna un el polinomio multiplicado (no modifica el polinomio original)
    public Polinomio multiplicarPolinomio(Polinomio multiplicando) {
        // el resultante es de grado [grado(a) + grado(b)]
        int grado = multiplicando.contenido[this.largo - 1].exponente + this.contenido[this.largo - 1].exponente;
        Polinomio res = new Polinomio(grado + 1); // polinomio resultante

        // realizar la distributiva
        for (Monomio a : multiplicando.contenido) {
            for (Monomio b : this.contenido) {
                // la posicion es igual a la suma de exponenetes
                int posicion = b.exponente + a.exponente;

                // si el termino en ese punto es nulo entonces cargar 0
                if (a.coeficiente.intValue() != 0 && b.coeficiente.intValue() != 0) {
                    // Cargar en la posicion correcta el coeficiente de la multiplicacion
                    // luego sumar al coeficiente la multiplicacion de los coeficiente de a y b
                    res.contenido[posicion].coeficiente = res.contenido[posicion].coeficiente.add(
                            b.coeficiente.multiply(a.coeficiente));
                }
            }
        }
        return res;
    }

    public Polinomio multiplicarEscalar(int escalar) {
        Polinomio res = new Polinomio(this.largo);
        for (Monomio element : res.contenido) {
            element.coeficiente = new BigDecimal(escalar);
        }
        return res;
    }

    // metodo para derivar el polinomio
    // Retorna un el polinomio derivado (no modifica el polinomio original)
    public Polinomio derivar() {
        Polinomio res = new Polinomio(this.largo);

        // empieza desde 1 porque el termino independiente es siempre 0 al derivar
        for (int i = 1; i < this.largo; i++) {
            // en la posicion con el exponente -1 guarda la derivada
            res.contenido[i - 1].coeficiente = res.contenido[i - 1].coeficiente.add(
                    this.contenido[i].coeficiente = this.contenido[i].coeficiente.multiply(
                            new BigDecimal(this.contenido[i].exponente)));
        }
        return res;
    }
}

package ejercicio1;

import java.math.BigInteger;

public class App {
    public static BigInteger calculok(BigInteger x, BigInteger y) {
        x = x.abs();
        y = y.abs();
        // Obtencion de la longitud de los numeros para dividirlos
        int xb = x.bitLength();
        int yb = y.bitLength();

        // Condiciones de terminacion del calculo del Karatsuba
        if (xb == 0 || yb == 0)
            return (BigInteger.ZERO);
        if (xb == 1)
            return y;
        if (yb == 1)
            return x;

        // Division de los numeros
        int n = Math.max(xb, yb);
        int m = n / 2;
        BigInteger x1 = x.shiftRight(m);
        BigInteger x0 = x.xor(x1.shiftLeft(m));
        BigInteger y1 = y.shiftRight(m);
        BigInteger y0 = y.xor(y1.shiftLeft(m));

        // Las 3 multiplicaciones
        BigInteger z2 = calculok(x1, y1); // z2=x1*x2
        BigInteger z1 = calculok(x1.add(x0), y1.add(y0)); // z1=(x1+x0)*(y1*y0)
        BigInteger z0 = calculok(x0, y0); // z0=x0*y0

        // x*y=(z2)B^2m + (z1-z2-z0)B^m + (k0)
        BigInteger k2 = z2.shiftLeft(2 * m);
        BigInteger k1 = z1.subtract(z2).subtract(z0).shiftLeft(m);
        BigInteger k0 = z0;

        // Resultado
        return k2.add(k1).add(k0); // TODO: suma iterativa
    }

    public static void main(String[] args) {
        BigInteger n1 = new BigInteger("12561");
        BigInteger n2 = new BigInteger("61");
        System.out.println(calculok(n1, n2));
    }
}

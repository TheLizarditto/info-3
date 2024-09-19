package recursividad;

public class Potencia {
    public int pot (int base, int exp) {
        if (exp == 1) {
            return base;
        } else {
            return base * pot(base, exp - 1);
        }
    }
}
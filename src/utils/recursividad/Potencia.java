package recursividad;

public class Potencia {
    public int pot (int base, int exponente) {
        if (exponente == 1) {
            return base;
        } else {
            return base * pot(base, exponente - 1);
        }
    }
}
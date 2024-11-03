package recursividad;

public class Multiplicar {
    public int multiplicar(int FactorA, int FactorB) {
        if (FactorB == 1) {
            return FactorA;
        }

        return FactorA + multiplicar(FactorA, FactorB - 1);
    }
}

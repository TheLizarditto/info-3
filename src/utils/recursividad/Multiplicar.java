package recursividad;

public class Multiplicar {
    public int multiplicar(int a, int b) {
        if (b == 1) {
            return a;
        }

        return a + multiplicar(a, b - 1);
    }
}

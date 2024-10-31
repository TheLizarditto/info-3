package recursividad;

public class Invertir {
    public String invertir(int[] x) {
        return invertir(x, x.length);
    }
    public String invertir(int[] x, int n) {
        if (n == 1) {
            return String.valueOf(x[0]);
        }

        return String.valueOf(x[n - 1]) + " " + invertir(x, n - 1);
    }
}

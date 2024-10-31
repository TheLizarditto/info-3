package recursividad;

public class Conteo {
    public String conteo(int x) {
        if (x == 1) {
            return "1";
        }

        return String.valueOf(x) + "," + conteo(x - 1);
    }
}

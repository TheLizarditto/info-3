package recursividad;

public class Conteo {
    public String conteo(int numero) {
        if (numero == 1) {
            return "1";
        }

        return String.valueOf(numero) + "," + conteo(numero - 1);
    }
}

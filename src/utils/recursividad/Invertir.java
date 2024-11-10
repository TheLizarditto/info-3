package recursividad;

public class Invertir {
    public String invertir(int[] numero) {
        return invertir(numero, numero.length);
    }

    public String invertir(int[] numero, int cantidadNumeros) {
        if (cantidadNumeros == 1) {
            return String.valueOf(numero[0]);
        }

        return String.valueOf(numero[cantidadNumeros - 1]) + " " + invertir(numero, cantidadNumeros - 1);
    }
}

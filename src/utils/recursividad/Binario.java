package recursividad;

public class Binario {
    public int binario(int numero) {
        if (numero == 0) {
            return 0;
        }
        
        return (numero % 2) + binario(numero / 2);
    }
}

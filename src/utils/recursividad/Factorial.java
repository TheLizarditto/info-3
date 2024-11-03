package recursividad;

public class Factorial {
    public int fact(int numero){
        if (numero == 1) {
            return 1;
        } else {
            return numero * fact(numero - 1);
        }
    }
}

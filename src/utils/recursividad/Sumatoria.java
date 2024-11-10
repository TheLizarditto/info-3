package recursividad;
public class Sumatoria {
    public int sum(int numero){
        if (numero == 1) {
            return 1;
        } else {
            return numero + sum(numero - 1);
        }
    }
}

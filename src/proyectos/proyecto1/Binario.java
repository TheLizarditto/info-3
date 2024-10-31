package proyecto1;

public class Binario {
    public int binario(int n) {
        if (n == 0) {
            return 0;
        }
        
        return (n % 2) + binario(n / 2);
    }
}

package proyecto1;

public class Factorial {
    public int fact(int x){
        if (x == 1) {
            return 1;
        } else {
            return x * fact(x - 1);
        }
    }
}

package proyecto1;
public class Sumatoria {
    public int sum(int x){
        if (x == 1) {
            return 1;
        } else {
            return x + sum(x - 1);
        }
    }
}

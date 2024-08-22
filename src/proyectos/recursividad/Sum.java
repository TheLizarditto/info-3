package recursividad;
public class Sum {
    public int sum(int x){
        if (x == 1) {
            return 1;
        } else {
            return x + sum(x - 1);
        }
    }
}

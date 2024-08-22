package recursividad;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String res, sel;
        Scanner input = new Scanner(System.in);
        Fact factorial = new Fact();
        Sum sumatoria = new Sum();
        Fib fibonacci = new Fib();

        do {
            System.out.println("Seleccione: \n1. Factorial \n2. Sumatoria \n3. Fibonacci \n0. Salir");
            sel = input.nextLine();
    
            try {
                switch (Integer.parseInt(sel)) {
                    case 1:
                        System.out.println("Ingrese un numero: ");
                        res = input.nextLine();
                        try {
                            System.out.println(factorial.fact(Integer.parseInt(res)));
                        } catch (Exception e) {
                            System.out.println("Debe ingresar un numero valido");
                        }
                        break;

                    case 2:
                        System.out.println("Ingrese un numero: ");
                        res = input.nextLine();
                        try {
                            System.out.println(sumatoria.sum(Integer.parseInt(res)));
                        } catch (Exception e) {
                            System.out.println("Debe ingresar un numero valido");
                        }
                        break;
                    case 3:
                        System.out.println("Ingrese un numero: ");
                        res = input.nextLine();
                        try {
                            System.out.println(fibonacci.fib(Integer.parseInt(res)));
                        } catch (Exception e) {
                            System.out.println("Debe ingresar un numero valido");
                        }
                        break;

                    case 0:
                        System.out.println("Au revoir");
                        break;
                    
                    default:
                        System.out.println("La opcion ingresada no existe");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Debe ingresar un numero valido");
            }
        } while (Integer.parseInt(sel) != 0);
        


    }
}

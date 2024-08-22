package recursividad;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String res, sel, exp;
        Scanner input = new Scanner(System.in);
        Fact factorial = new Fact();
        Sum sumatoria = new Sum();
        Fib fibonacci = new Fib();
        Inv invertir = new Inv();
        Pot potencia = new Pot();

        do {
            System.out.println("Menu \n1. Factorial \n2. Sumatoria \n3. Fibonacci \n4. Invertir texto \n5. Elevar \n0. Salir \nSeleccione: ");
            sel = input.nextLine();
    
            try {
                switch (Integer.parseInt(sel)) {
                    case 1:
                        System.out.println("Ingrese un numero: ");
                        res = input.nextLine();
                        try {
                            System.out.println("El resultado es: " + factorial.fact(Integer.parseInt(res)));
                        } catch (Exception e) {
                            System.out.println("Debe ingresar un numero valido");
                        }
                        break;

                    case 2:
                        System.out.println("Ingrese un numero: ");
                        res = input.nextLine();
                        try {
                            System.out.println("El resultado es: " + sumatoria.sum(Integer.parseInt(res)));
                        } catch (Exception e) {
                            System.out.println("Debe ingresar un numero valido");
                        }
                        break;

                    case 3:
                        System.out.println("Ingrese un numero: ");
                        res = input.nextLine();
                        try {
                            System.out.println("El resultado es: " + fibonacci.fib(Integer.parseInt(res)));
                        } catch (Exception e) {
                            System.out.println("Debe ingresar un numero valido");
                        }
                        break;

                    case 4:
                        System.out.println("Ingrese un texto: ");
                        res = input.nextLine();
                        System.out.println("El texto invertido es: " + invertir.inv(res));
                        break;

                    case 5:
                        System.out.println("Ingrese la base: ");
                        res = input.nextLine();
                        try {
                            System.out.println("Ingrese el exponente: ");
                            exp = input.nextLine();
                            System.out.println("El resultado es: " + potencia.pot(Integer.parseInt(res), Integer.parseInt(exp)));
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

            System.out.println("\n");
        } while (Integer.parseInt(sel) != 0);
    }
}

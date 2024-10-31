package proyecto1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String sel, res, res2;
        Scanner input = new Scanner(System.in);
        Factorial factorial = new Factorial();
        Sumatoria sumatoria = new Sumatoria();
        Potencia potencia = new Potencia();
        Conteo conteo = new Conteo();
        Multiplicar multiplicar = new Multiplicar();
        Invertir invertir = new Invertir();
        Binario binario = new Binario();
        int[] arreglo = {1,2,3,4,5};

        do {
            System.out.println("Menu \n1. Factorial \n2. Sumatoria \n3. Potencia \n4. Conteo \n5. Multiplicar \n6. Invertir \n7. Convertir a binario \n0. Salir \nSeleccione: ");
            sel = input.nextLine();
    
            switch (sel) {
                case "1":
                try {
                        System.out.println("Ingrese un numero: ");
                        res = input.nextLine(); //Usamos nextLine, porque nextInt tiene un problema en el que deja la tecla en el buffer cuando no debería
                        System.out.println("El resultado es: " + factorial.fact(Integer.parseInt(res)));
                    } catch (Exception e) {
                        System.out.println("Debe ingresar un numero valido");
                    }
                    break;

                case "2":
                try {
                        System.out.println("Ingrese un numero: ");
                        res = input.nextLine();
                        System.out.println("El resultado es: " + sumatoria.sum(Integer.parseInt(res)));
                    } catch (Exception e) {
                        System.out.println("Debe ingresar un numero valido");
                    }
                    break;

                case "3":
                try {
                        System.out.println("Ingrese la base: ");
                        res = input.nextLine();
                        System.out.println("Ingrese el exponente: ");
                        res2 = input.nextLine();
                        System.out.println("El resultado es: " + potencia.pot(Integer.parseInt(res), Integer.parseInt(res2)));
                    } catch (Exception e) {
                        System.out.println("Debe ingresar un numero valido");
                    }
                    break;

                case "4":
                    try {
                        System.out.println("Ingrese un numero: ");
                        res = input.nextLine();
                        System.out.println("El resultado es: " + conteo.conteo(Integer.parseInt(res)));
                    } catch (Exception e) {
                        System.out.println("Debe ingresar un numero valido");
                    }
                    break;

                case "5":
                    try {
                        System.out.println("Ingrese el factor a: ");
                        res = input.nextLine();
                        System.out.println("Ingrese el factor b: ");
                        res2 = input.nextLine();
                        System.out.println("El resultado es: " + multiplicar.multiplicar(Integer.parseInt(res), Integer.parseInt(res2)));
                    } catch (Exception e) {
                        System.out.println("Debe ingresar un numero valido");
                    }
                    break;

                case "6":
                    try {
                        System.out.println("El arreglo invertido es: " + invertir.invertir(arreglo, arreglo.length));
                    } catch (Exception e) {
                        System.out.println("Debe ingresar un numero valido");
                    }
                    break;
                
                case "7":
                    try {
                        System.out.println("Ingrese un numero: ");
                        res = input.nextLine();
                        System.out.println("La cantidad de unos en binario es: " + binario.binario(Integer.parseInt(res)));
                    } catch (Exception e) {
                        System.out.println("Debe ingresar un numero valido");
                    }
                    break;
                

                case "0":
                    System.out.println("Fin del programa");
                    break;
                
                default:
                    System.out.println("La opcion ingresada no existe");
                    break;
            }

            System.out.println("\n");
        } while (Integer.parseInt(sel) != 0);
    }
}
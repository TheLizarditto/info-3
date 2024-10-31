// importo el archivo que contiene las consignas de cada proyecto (se hizo así para separar y organizar mejor los ejemplos que se vieron de cada tema)
import recursividad.*;
import ordenamiento.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String sel, proyecto, res, res2;
        Factorial factorial = new Factorial();
        Sumatoria sumatoria = new Sumatoria();
        Potencia potencia = new Potencia();
        Conteo conteo = new Conteo();
        Multiplicar multiplicar = new Multiplicar();
        Invertir invertir = new Invertir();
        Binario binario = new Binario();
        int[] arreglo = {1,2,3,4,5};

        System.out.println("Bienvenido al proyecto");

        do {
            System.out.println("Elija un proyecto \n1. Recursividad \n2. Ordenamiento \n3. Pila y cola \n4. Pila y cola con lista \n5. Arbol binario \n6. Arbol binario 2 \n7. Arbol binario AVL \n8. Arbol rojinegro \n8. Monticulo binario, tablas de hash y general \n0. Salir \nSeleccione: ");
            proyecto = input.nextLine();

            switch (proyecto) {
                case "0":
                    System.out.println("Fin del programa");
                    break;

                // Recursividad
                case "1":
                    do {
                        System.out.println("Elija un ejercicio \n1. Factorial \n2. Sumatoria \n3. Potencia \n4. Conteo \n5. Multiplicar \n6. Invertir \n7. Convertir a binario \n0. Salir del proyecto \nSeleccione: ");
                        sel = input.nextLine();
                
                        switch (sel) {
                            case "0":
                                break;

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
                            
                            default:
                                System.out.println("La opcion ingresada no existe");
                                break;
                        }
            
                        System.out.println("\n");
                    } while (Integer.parseInt(sel) != 0);
                    break;
            
                default:
                    System.out.println("Debe ingresar una opcion del menu");
                    break;
            }
        } while (proyecto != "0");
    }
}

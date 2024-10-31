// importo el archivo que contiene las consignas de cada proyecto (se hizo así para separar y organizar mejor los ejemplos que se vieron de cada tema)
import recursividad.*;
import ordenamiento.*;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sel;

        // variables del proyecto 1
        String proyecto;
        Factorial factorial = new Factorial();
        Sumatoria sumatoria = new Sumatoria();
        Potencia potencia = new Potencia();
        Conteo conteo = new Conteo();
        Multiplicar multiplicar = new Multiplicar();
        Invertir invertir = new Invertir();
        Binario binario = new Binario();
        int[] arreglo = {1,2,3,4,5};
        int[] array;

        // variables del proyecto 2
        Random random = new Random();
        int n = 10; // cantidad de valores para los arreglos
        Lista<Integer> listaInt = new Lista<>();
        Lista<Double> listaDouble = new Lista<>();
        Lista<String> listaString = new Lista<>();
        Insercion insercion = new Insercion();
        Shellsort shellsort = new Shellsort();
        Quicksort quicksort = new Quicksort();
        TiempoOrdenamiento tiempo = new TiempoOrdenamiento();
        System.out.println("Bienvenido al proyecto");

        do {
            System.out.println("------------------------------------------");
            System.out.println("Elija un proyecto \n1. Recursividad \n2. Ordenamiento \n3. Pila y cola \n4. Pila y cola con lista \n5. Arbol binario \n6. Arbol binario 2 \n7. Arbol binario AVL \n8. Arbol rojinegro \n8. Monticulo binario, tablas de hash y general \n0. Salir \n\nSeleccione: ");
            proyecto = input.nextLine();

            switch (proyecto) {
                case "0":
                    System.out.println("Fin del programa");
                    break;

                // Recursividad
                case "1":
                    do {
                        sel = seleccionarInt("Elija un ejercicio \n1. Factorial \n2. Sumatoria \n3. Potencia \n4. Conteo \n5. Multiplicar \n6. Invertir \n7. Convertir a binario \n0. Salir del proyecto \nSeleccione: ");
                
                        switch (sel) {
                            case 0:
                                break;

                            case 1:
                                System.out.println("El resultado es: " + factorial.fact(seleccionarInt("Ingrese un numero: ")));
                                break;
            
                            case 2:
                                System.out.println("El resultado es: " + sumatoria.sum(seleccionarInt("Ingrese un numero: ")));
                                break;
            
                            case 3:
                                System.out.println("El resultado es: " + potencia.pot(seleccionarInt("Ingrese la base: "), seleccionarInt("Ingrese el exponente: ")));
                                break;
            
                            case 4:
                                System.out.println("El resultado es: " + conteo.conteo(seleccionarInt("Ingrese un numero: ")));
                                break;
            
                            case 5:
                                System.out.println("El resultado es: " + multiplicar.multiplicar(seleccionarInt("Ingrese el factor a: "), seleccionarInt("Ingrese el factor b: ")));
                                break;
            
                            case 6:
                                System.out.println("El arreglo invertido es: " + invertir.invertir(arreglo));
                                break;
                            
                            case 7:
                                System.out.println("La cantidad de unos en binario es: " + binario.binario(seleccionarInt("Ingrese un numero: ")));
                                break;
                            
                            default:
                                System.out.println("La opcion ingresada no existe");
                                break;
                        }
            
                        System.out.println("\n");
                    } while (sel != 0);
                    break;

                // ordenamiento
                case "2":
                do {
                        sel = seleccionarInt("Elija un ejercicio \n1. Ordenamiento de listas \n2. Mostrar array aleatorio \n3. Tiempo de ordenamiento \n0. Salir del proyecto \nSeleccione: ");
                
                        switch (sel) {
                            case 0:
                                break;

                            case 1:
                                n = seleccionarInt("Ingrese la cantidad de datos a cargar: ");
                                
                                for (int i = 0; i < n; i ++) {
                                    listaInt.add(random.nextInt(100));
                                    listaDouble.add(random.nextDouble(100));
                                    listaString.add(String.valueOf((char) ('A' +  random.nextInt(26))));
                                }
                        
                                System.out.println("Ordeno la lista de enteros:\n");
                        
                                System.out.println("Lista original");
                                listaInt.mostrar();
                                System.out.println(" ");
                        
                                insercion.ordenarInt(listaInt);
                                
                                System.out.println("Lista con insercion");
                                listaInt.mostrar();
                                System.out.println(" ");
                        
                                shellsort.ordenarInt(listaInt);
                                
                                System.out.println("Lista con shellsort");
                                listaInt.mostrar();
                                System.out.println(" ");
                        
                                quicksort.ordenarInt(listaInt);
                                
                                System.out.println("Lista con quicksort");
                                listaInt.mostrar();
                                System.out.println(" ");
                        
            
                        
                                System.out.println("Ordeno la lista de double:\n");
                                
                                System.out.println("Lista original");
                                listaDouble.mostrar();
                                System.out.println(" ");
                        
                                insercion.ordenarDouble(listaDouble);
                        
                                System.out.println("Lista con insercion");
                                listaDouble.mostrar();
                                System.out.println(" ");
                        
                                shellsort.ordenarDouble(listaDouble);
                                
                                System.out.println("Lista con shellsort");
                                listaDouble.mostrar();
                                System.out.println(" ");
                        
                                quicksort.ordenarDouble(listaDouble);
                                
                                System.out.println("Lista con quicksort");
                                listaDouble.mostrar();
                                System.out.println(" ");
                        
                        
                        
                                System.out.println("Ordeno la lista de string:\n");
                        
                                System.out.println("Lista original");
                                listaString.mostrar();
                        
                                insercion.ordenarString(listaString);
                        
                                System.out.println("Lista con insercion");
                                listaString.mostrar();
                                System.out.println(" ");
                                
                                shellsort.ordenarString(listaString);
                        
                                System.out.println("Lista con shellsort");
                                listaString.mostrar();
                                System.out.println(" ");
                        
                                quicksort.ordenarString(listaString);
                                
                                System.out.println("Lista con quicksort");
                                listaString.mostrar();
                                System.out.println(" ");
                                break;
            
                            case 2:
                                n = seleccionarInt("Seleccione la cantidad de elementos del arreglo:");
                                array = Arreglo.cargarArray(n);
                                Arreglo.mostrarArray(array);
                                break;

                            case 3:
                                System.out.println("Mido la velocidad de cada algoritmo de ordenamiento para los 3 tipos de listas");
                                System.out.println("Insercion: " + tiempo.medirInsercion(listaInt, listaDouble, listaString) + " µS");
                                System.out.println("Shellsort: " + tiempo.medirShellsort(listaInt, listaDouble, listaString) + " µS");
                                System.out.println("Quicksort: " + tiempo.medirQuicksort(listaInt, listaDouble, listaString) + " µS");                         
                                break;
                            
                            default:
                                System.out.println("La opcion ingresada no existe");
                                break;
                        }
            
                        System.out.println("\n");
                    } while (sel != 0);
                        break;
            
                default:
                    System.out.println("Debe ingresar una opcion del menu");
                    break;
            }
        } while (Integer.parseInt(proyecto) != 0);
    }

    public static int seleccionarInt(String mensaje) {
        String res;
        Scanner input2 = new Scanner(System.in);

        do {
            try {
                System.out.println(mensaje);
                res = input2.nextLine();
                
                return Integer.parseInt(res);
            } catch (Exception e) {
                System.out.println("Debe ingresar un numero valido");
            }
        } while (true);
    }
}

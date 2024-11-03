// importo el archivo que contiene las consignas de cada proyecto (se hizo así para separar y organizar mejor los ejemplos que se vieron de cada tema)
import recursividad.*;
import ordenamiento.*;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int seleccionEjercio, seleccionProyecto;

        // variables del proyecto 1
        int[] arregloNumeros = {1,2,3,4,5};
        int[] arregloRandom; // los valores se agregan después dado que la cantidad es definida por el usuario
        Factorial factorial = new Factorial();
        Sumatoria sumatoria = new Sumatoria();
        Potencia potencia = new Potencia();
        Conteo conteo = new Conteo();
        Multiplicar multiplicar = new Multiplicar();
        Invertir invertir = new Invertir();
        Binario binario = new Binario();

        // variables del proyecto 2
        Lista<Integer> listaInt = new Lista<>();
        Lista<Double> listaDouble = new Lista<>();
        Lista<String> listaString = new Lista<>();
        Insercion insercion = new Insercion();
        Shellsort shellsort = new Shellsort();
        Quicksort quicksort = new Quicksort();
        TiempoOrdenamiento tiempoOrdenamiento = new TiempoOrdenamiento();
        int nPersonalizado; // cantidad de datos para un arreglo pero definido por el usuario
        
        System.out.println("------------------------------------------");        
        System.out.println("Bienvenido al proyecto");
        System.out.println("------------------------------------------ \n");

        do {
            System.out.println("------------------------------------------");
            seleccionProyecto = seleccionarInt("Elija un proyecto \n" + //
                                "1. Recursividad \n" + //
                                "2. Ordenamiento \n" + //
                                "3. Pila y cola \n" + //
                                "4. Pila y cola con lista \n" + //
                                "5. Arbol binario \n" + //
                                "6. Arbol binario 2 \n" + //
                                "7. Arbol binario AVL \n" + //
                                "8. Arbol rojinegro \n" + //
                                "8. Monticulo binario, tablas de hash y general \n" + //
                                "0. Salir \n" + //
                                "\n" + //
                                "Seleccione: ");

            switch (seleccionProyecto) {
                case 0:
                    System.out.println("Fin del programa");
                    break;

                // Recursividad
                case 1:
                    do {
                        seleccionEjercio = seleccionarInt("Elija un ejercicio \n" + //
                                                        "1. Factorial \n" + //
                                                        "2. Sumatoria \n" + //
                                                        "3. Potencia \n" + //
                                                        "4. Conteo \n" + //
                                                        "5. Multiplicar \n" + //
                                                        "6. Invertir \n" + //
                                                        "7. Convertir a binario \n" + //
                                                        "0. Salir del proyecto \n" + //
                                                        "Seleccione: ");
                
                        switch (seleccionEjercio) {
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
                                System.out.println("El arreglo invertido es: " + invertir.invertir(arregloNumeros));
                                break;
                            
                            case 7:
                                System.out.println("La cantidad de unos en binario es: " + binario.binario(seleccionarInt("Ingrese un numero: ")));
                                break;
                            
                            default:
                                System.out.println("La opcion ingresada no existe");
                                break;
                        }
            
                        System.out.println("\n");
                    } while (seleccionEjercio != 0);
                    break;

                // ordenamiento
                case 2:
                do {
                        seleccionEjercio = seleccionarInt("Elija un ejercicio \n" + //
                                                        "1. Ordenamiento de listas \n" + //
                                                        "2. Mostrar array aleatorio \n" + //
                                                        "3. Tiempo de ordenamiento \n" + //
                                                        "0. Salir del proyecto \n" + //
                                                        "Seleccione: ");
                
                        switch (seleccionEjercio) {
                            case 0:
                                break;

                            case 1:
                                nPersonalizado = seleccionarInt("Ingrese la cantidad de datos a cargar: ");

                                for (int i = 0; i < nPersonalizado; i ++) {
                                    listaInt.add(random.nextInt(100));
                                    listaDouble.add(random.nextDouble(100));
                                    listaString.add(String.valueOf((char) ('A' +  random.nextInt(26))));
                                }
                        
                                System.out.println("Ordeno la lista de enteros:\n");
                        
                                System.out.println("Lista original");
                                listaInt.mostrarValores();
                                System.out.println(" ");
                        
                                insercion.ordenarInt(listaInt);
                                
                                System.out.println("Lista con insercion");
                                listaInt.mostrarValores();
                                System.out.println(" ");
                        
                                shellsort.ordenarInt(listaInt);
                                
                                System.out.println("Lista con shellsort");
                                listaInt.mostrarValores();
                                System.out.println(" ");
                        
                                quicksort.ordenarInt(listaInt);
                                
                                System.out.println("Lista con quicksort");
                                listaInt.mostrarValores();
                                System.out.println(" ");
                        
            
                        
                                System.out.println("Ordeno la lista de double:\n");
                                
                                System.out.println("Lista original");
                                listaDouble.mostrarValores();
                                System.out.println(" ");
                        
                                insercion.ordenarDouble(listaDouble);
                        
                                System.out.println("Lista con insercion");
                                listaDouble.mostrarValores();
                                System.out.println(" ");
                        
                                shellsort.ordenarDouble(listaDouble);
                                
                                System.out.println("Lista con shellsort");
                                listaDouble.mostrarValores();
                                System.out.println(" ");
                        
                                quicksort.ordenarDouble(listaDouble);
                                
                                System.out.println("Lista con quicksort");
                                listaDouble.mostrarValores();
                                System.out.println(" ");
                        
                        
                        
                                System.out.println("Ordeno la lista de string:\n");
                        
                                System.out.println("Lista original");
                                listaString.mostrarValores();
                        
                                insercion.ordenarString(listaString);
                        
                                System.out.println("Lista con insercion");
                                listaString.mostrarValores();
                                System.out.println(" ");
                                
                                shellsort.ordenarString(listaString);
                        
                                System.out.println("Lista con shellsort");
                                listaString.mostrarValores();
                                System.out.println(" ");
                        
                                quicksort.ordenarString(listaString);
                                
                                System.out.println("Lista con quicksort");
                                listaString.mostrarValores();
                                System.out.println(" ");
                                break;
            
                            case 2:
                                nPersonalizado = seleccionarInt("Seleccione la cantidad de elementos del arreglo:");
                                arregloRandom = Arreglo.cargarArray(nPersonalizado);
                                Arreglo.mostrarArray(arregloRandom);
                                break;

                            case 3:
                                System.out.println("Mido la velocidad de cada algoritmo de ordenamiento para los 3 tipos de listas");
                                System.out.println("Insercion: " + tiempoOrdenamiento.medirInsercion(listaInt, listaDouble, listaString) + " µS");
                                System.out.println("Shellsort: " + tiempoOrdenamiento.medirShellsort(listaInt, listaDouble, listaString) + " µS");
                                System.out.println("Quicksort: " + tiempoOrdenamiento.medirQuicksort(listaInt, listaDouble, listaString) + " µS");                         
                                break;
                            
                            default:
                                System.out.println("La opcion ingresada no existe");
                                break;
                        }
            
                        System.out.println("\n");
                    } while (seleccionEjercio != 0);
                        break;
            
                default:
                    System.out.println("Debe ingresar una opcion del menu");
                    break;
            }
        } while (seleccionProyecto != 0);
    }

    public static int seleccionarInt(String mensaje) {
        String valor;
        Scanner input = new Scanner(System.in);

        do {
            try {
                System.out.println(mensaje);
                valor = input.nextLine();
                
                return Integer.parseInt(valor);
            } catch (Exception e) {
                System.out.println("Debe ingresar un numero valido");
            }
        } while (true);
    }
}

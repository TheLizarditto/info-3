// importo el archivo que contiene las consignas de cada proyecto (se hizo así para separar y organizar mejor los ejemplos que se vieron de cada tema)
import ordenamiento.*;
import pilaCola.*;
import pilaColaLista.*;
import lista.ListaT;
import recursividad.*;
import arbolBinario.*;
import arbolAVL.*;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int seleccionEjercicio, seleccionProyecto, dato;
        String cadena;

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
        ListaT<Integer> listaInt = new ListaT<>();
        ListaT<Double> listaDouble = new ListaT<>();
        ListaT<String> listaString = new ListaT<>();
        Insercion insercion = new Insercion();
        Shellsort shellsort = new Shellsort();
        Quicksort quicksort = new Quicksort();
        TiempoOrdenamiento tiempoOrdenamiento = new TiempoOrdenamiento();
        int nPersonalizado; // cantidad de datos para un arreglo pero definido por el usuario

        // variables del proyecto 3
        PilaArreglo pila = new PilaArreglo(5); // capacidad para 5 elementos
        ColaArreglo cola = new ColaArreglo(5); // capacidad para 5 elementos
        PalindromoArreglo palindromoArreglo = new PalindromoArreglo(10);
        ParentesisArreglo parentesisArreglo = new ParentesisArreglo(20);

        // variables del proyecto 4
        Pila pilaLista = new Pila();
        PilaStr pilaListaStr = new PilaStr();
        ConversionBinario conversionBinario = new ConversionBinario();
        Parentesis parentesisLista = new Parentesis();
        Cola colaLista = new Cola();
        ColaNumeros colaNumeros = new ColaNumeros();
        Palindromo palindromo = new Palindromo();
        boolean popError;

        // variables del proyecto 5
        Arbol arbol = new Arbol();

        // variables del proyecto 7
        ArbolAVL arbolAVL = new ArbolAVL();
        boolean banderaArbolAVL = false;
        

        
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
                                "7. Arbol binario AVL \n" + //
                                "8. Arbol rojinegro \n" + //
                                "9. Monticulo binario, tablas de hash y general \n" + //
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
                        seleccionEjercicio = seleccionarInt("Elija un ejercicio \n" + //
                                                        "1. Factorial \n" + //
                                                        "2. Sumatoria \n" + //
                                                        "3. Potencia \n" + //
                                                        "4. Conteo \n" + //
                                                        "5. Multiplicar \n" + //
                                                        "6. Invertir \n" + //
                                                        "7. Convertir a binario \n" + //
                                                        "0. Salir del proyecto \n" + //
                                                        "Seleccione: ");
                
                        switch (seleccionEjercicio) {
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
            
                        System.out.println(" ");
                    } while (seleccionEjercicio != 0);
                    break;

                // ordenamiento
                case 2:
                do {
                        seleccionEjercicio = seleccionarInt("Elija un ejercicio \n" + //
                                                        "1. Ordenamiento de listas \n" + //
                                                        "2. Mostrar array aleatorio \n" + //
                                                        "3. Tiempo de ordenamiento \n" + //
                                                        "0. Salir del proyecto \n" + //
                                                        "Seleccione: ");
                
                        switch (seleccionEjercicio) {
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
                                    
                        System.out.println(" ");
                    } while (seleccionEjercicio != 0);
                        break;
            
                case 3:
                    do {
                        seleccionEjercicio = seleccionarInt("Elija un ejercicio \n" + //
                                                            "1. Probar las operaciones con pilas \n" + //
                                                            "2. Comprobacion de palindromos \n" + //
                                                            "3. Comprobar expresion matematica equilibrada \n" + //
                                                            "4. Probar las operaciones con colas \n" + //
                                                            "5. Ordenar una cola \n" + //
                                                            "0. Salir del proyecto \n" + //
                                                            "Seleccione: ");
                        
                        switch(seleccionEjercicio) {
                            case 0:
                                break;

                            case 1:
                                System.out.println("La pila puede tener solo 5 elementos (se puede cambiar en el codigo) \n");
                                System.out.println("Comprobamos que la pila esta vacia: ");
                                
                                if (pila.isEmpty() == true) {
                                    System.out.println("Correcto");
                                } else {
                                    System.out.println("Hay un problema con la pila, informe al programador");
                                    break;
                                }

                                System.out.println("Agregamos elementos");
                                pila.push('a');
                                pila.push('f');
                                pila.push('l');

                                System.out.println("El ultimo elemento agregado es: " + pila.top());

                                pila.pop();
                                System.out.println("Eliminamos el ultimo elemento y volvemos a mostrar el ultimo:" + pila.top());

                                break;

                            case 2:
                                System.out.println("Ingrese un texto de no mas de 10 caracteres: ");
                                cadena = input.nextLine();

                                palindromoArreglo.llenarPila(cadena);
                                palindromoArreglo.comparar();

                                break;
                            
                            case 3:
                                System.out.println("Ingrese una expresion matematica de no mas de 20 caracteres: ");
                                cadena = input.nextLine();

                                if(parentesisArreglo.equilibrada(cadena)) {
                                    System.out.println("La expresion esta equilibrada");
                                } else {
                                    System.out.println("La expresion no esta equilibrada");
                                }
                                break;

                            case 4:
                                System.out.println("La cola puede tener solo 5 elementos (se puede cambiar en el codigo) \n");
                                System.out.println("Comprobamos que la cola esta vacia: ");

                                if (cola.isEmpty() == true) {
                                    System.out.println("Correcto");
                                } else {
                                    System.out.println("Hay un problema con la cola, informe al programador");
                                    break;
                                }

                                System.out.println("Agregamos elementos");
                                cola.enqueue(3);
                                cola.enqueue(2);
                                cola.enqueue(5);

                                System.out.println("El ultimo elemento agregado es: " + cola.top());

                                cola.dequeue();
                                System.out.println("Eliminamos el ultimo elemento y volvemos a mostrar el ultimo: " + String.valueOf(cola.top()));
                                break;

                            case 5:
                                System.out.println("Agregue 5 elementos a la cola para ordenarlos y mostrarlos");

                                do {
                                    cola.dequeue();
                                } while (!cola.isEmpty());

                                for (int i = 0; i < 5; i++) {
                                    cola.enqueue(seleccionarInt("Ingrese un numero: "));
                                }

                                System.out.println(cola);
                                cola.ordenarAscendente();
                                System.out.println(cola);

                                break;

                            default:
                                System.out.println("Debe ingresar una opcion del menu");
                                break;
                        }

                        System.out.println(" ");
                    } while (seleccionEjercicio != 0);
                    break;

                case 4:
                    do {
                        seleccionEjercicio = seleccionarInt("Elija un ejercicio \n" + //
                                                            "1. Probar las operaciones con pilas \n" + //
                                                            "2. Pila de palabras \n" + //
                                                            "3. Verificacion de parentesis \n" + //
                                                            "4. Conversion de decimal a binario \n" + //
                                                            "5. Probar las operaciones con colas \n" + //
                                                            "6. Cola de numeros y la suma de los valores \n" + //
                                                            "7. Ordenamiento de colas \n" + //
                                                            "8. Verificacion de palindromos \n" + //
                                                            "0. Salir del proyecto \n" + //
                                                            "Seleccione: ");
                        
                        switch(seleccionEjercicio) {
                            case 0:
                                break;

                            case 1:
                                System.out.println("Comprobamos que la pila esta vacia: ");

                                if (pilaLista.isEmpty() == true) {
                                    System.out.println("Correcto");
                                } else {
                                    System.out.println("Hay un problema con la pila, informe al programador");
                                    break;
                                }

                                System.out.println("Agregamos elementos");
                                pilaLista.push(4);
                                pilaLista.push(5);
                                pilaLista.push(1);

                                System.out.println("El ultimo elemento agregado es: " + pilaLista.top());

                                popError = pilaLista.pop();
                                if(popError == true) {
                                    System.out.println("La pila esta vacia, error al eliminar");
                                }
                                System.out.println("Eliminamos el ultimo elemento y volvemos a mostrar el ultimo:" + pilaLista.top());

                                break;

                            case 2:
                                System.out.println("Ingrese palabras para agregar en la pila (deje en blanco para terminar)");

                                do {
                                    System.out.println("Ingrese una palabra: ");
                                    cadena = input.nextLine();
                                    pilaListaStr.push(cadena);

                                } while (cadena != "");

                                System.out.println(pilaListaStr.mostrarInverso());

                                break;
                            
                            case 3:
                                System.out.println("Ingrese una expresion matematica: ");
                                cadena = input.nextLine();

                                if(parentesisLista.chequearExpresion(cadena)) {
                                    System.out.println("La expresion esta equilibrada");
                                } else {
                                    System.out.println("La expresion no esta equilibrada");
                                }
                                break;

                            case 4:
                                System.out.println(conversionBinario.convertir(seleccionarInt("Ingrese un numero para convertir a binario: ")));
                                break;

                            case 5:
                                System.out.println("Comprobamos que la cola esta vacia: ");

                                if (colaLista.isEmpty() == true) {
                                    System.out.println("Correcto");
                                } else {
                                    System.out.println("Hay un problema con la cola, informe al programador");
                                    break;
                                }

                                System.out.println("Agregamos elementos");
                                colaLista.enqueue(4);
                                colaLista.enqueue(5);
                                colaLista.enqueue(1);

                                System.out.println("El ultimo elemento agregado es: " + colaLista.top());

                                popError = colaLista.dequeue();
                                if(popError == true) {
                                    System.out.println("La cola esta vacia, error al eliminar");
                                }
                                System.out.println("Eliminamos el ultimo elemento y volvemos a mostrar el ultimo: " + colaLista.top());
                                break;

                            case 6:
                                do {
                                    dato = seleccionarInt("Ingrese un numero (0 para terminar): ");
                                    colaNumeros.enqueue(dato);
                                } while (dato != 0);

                                System.out.println("La suma de los valores es: " + colaNumeros.sumatoria());
                                break;
                            
                            case 7:
                                while (!colaLista.isEmpty()) {
                                    colaLista.dequeue();
                                }

                                do {
                                    dato = seleccionarInt("Ingrese un numero (0 para terminar): ");
                                    colaLista.enqueue(dato);
                                } while (dato != 0);

                                colaLista.ordenar();
                                System.out.println(colaLista);
                                break;
                            
                            case 8:
                                do {
                                    System.out.println("Ingrese una palabra para verificar (deje vacio para terminar): ");
                                    cadena = input.nextLine();

                                    if(palindromo.esPalindromo(cadena)) {
                                        System.out.println("Es palindromo");
                                    } else {
                                        System.out.println("No es palindromo");
                                    }
                                } while (cadena != "");
                                break;
                            
                            default:
                                System.out.println("Debe ingresar una opcion del menu");
                                break;
                        }
                        
                        System.out.println(" ");
                    } while (seleccionEjercicio != 0);
                    break;

                case 5:
                    do {
                            seleccionEjercicio = seleccionarInt("Elija un ejercicio \n" + //
                                                                "1. Recorrer en orden \n" + //
                                                                "2. Revisar profundidad \n" + //
                                                                "3. Borrar elemento \n" + //
                                                                "4. Imprimir \n" + //                                                
                                                                "0. Salir del proyecto \n" + //
                                                                "Seleccione: ");
                            
                            switch(seleccionEjercicio) {
                                case 0:
                                    break;

                                case 1:
                                    System.out.println("Estos son los datos: " + arbol.inorder());
                                    break;
                                
                                case 2:
                                    System.out.println("El arbol tiene " + arbol.depth() + " niveles");
                                    break;

                                case 3:
                                    dato = seleccionarInt("Elija el valor a eliminar: ");
                                    arbol.dtree(dato);
                                    break;
                                case 4:
                                    arbol.imprimirArbol();
                                    break;
                                default:
                                    System.out.println("Debe ingresar una opcion del menu");
                                    break;
                            }

                            System.out.println(" ");
                        } while (seleccionEjercicio != 0);
                    break;

                case 7:
                    do {
                        seleccionEjercicio = seleccionarInt("Elija un ejercicio \n" + //
                                                            "1. Insertar valores \n" + //
                                                            "2. Imprimir \n" + //   
                                                            "3. Eliminar valor del arbol \n" + //                                               
                                                            "0. Salir del proyecto \n" + //
                                                            "Seleccione: ");
                        
                        switch(seleccionEjercicio) {
                            case 0:
                                break;

                            case 1:
                                arbolAVL.insertar(seleccionarInt("Ingrese el valor para insertar: "));                    
                                break;
                            
                            case 2:
                                System.out.println("Estos son los datos en orden: ");
                                arbolAVL.inOrder();
                                break;

                            case 3:
                                arbolAVL.eliminar(seleccionarInt("Ingrese el valor a eliminar: "));
                                break;

                            default:
                                System.out.println("Debe ingresar una opcion del menu");
                                break;
                        }

                        System.out.println(" ");
                    } while (seleccionEjercicio != 0);
                break;

                default:
                    System.out.println("Debe ingresar una opcion del menu");
                    break;
            }

            System.out.println(" ");
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
                System.out.println("Debe ingresar un numero");
            }
        } while (true);
    }
}

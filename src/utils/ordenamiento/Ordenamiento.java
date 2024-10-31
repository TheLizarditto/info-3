package ordenamiento;

import java.util.Random;

public class Ordenamiento {
    public static void ejercicios() {
        Random random = new Random();
        int n = 10; // cantidad de valores para los arreglos
        Lista<Integer> listaInt = new Lista<>();
        Lista<Double> listaDouble = new Lista<>();
        Lista<String> listaString = new Lista<>();
        Insercion insercion = new Insercion();
        Shellsort shellsort = new Shellsort();
        Quicksort quicksort = new Quicksort();
        TiempoOrdenamiento tiempo = new TiempoOrdenamiento();

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

        System.out.println("Cargo un array con valores aleatorios y lo muestro:");
        int[] arreglo = Arreglo.cargarArray(n);
        Arreglo.mostrarArray(arreglo);


        System.out.println("Mido la velocidad de cada algoritmo de ordenamiento para los 3 tipos de listas");
        System.out.println("Insercion: " + tiempo.medirInsercion(listaInt, listaDouble, listaString) + " µS");
        System.out.println("Shellsort: " + tiempo.medirShellsort(listaInt, listaDouble, listaString) + " µS");
        System.out.println("Quicksort: " + tiempo.medirQuicksort(listaInt, listaDouble, listaString) + " µS");
    }
}

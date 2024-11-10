package ordenamiento;

import java.util.Random;

public class Arreglo {
    // imprime los valores de un array
    public static void mostrarArray(int[] arreglo) {
        if(arreglo.length == 0) {
            return;
        }

        String cadena = String.valueOf(arreglo[0]);

        for (int valor : arreglo) {
            cadena += " " + String.valueOf(arreglo[valor]);
        }

        System.out.println(cadena);
    }
    

    // carga un array con la cantidad pedida de valores y lo retorna
    public static int[] cargarArray(int longitud) {
        
        Random random = new Random();
        int[] arreglo = new int[longitud];

        for (int valor : arreglo) {
            arreglo[valor] = random.nextInt(100);
        }

        return arreglo;
    }
}

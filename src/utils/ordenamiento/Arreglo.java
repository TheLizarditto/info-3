package ordenamiento;

import java.util.Random;

public class Arreglo {
    // imprime los valores de un array
    public static void mostrarArray(int[] array) {
        if(array.length == 0) {
            return;
        }

        String cadena = String.valueOf(array[0]);

        for(int i = 1; i < array.length; i++) {
            cadena += " " + String.valueOf(array[i]);
        }

        System.out.println(cadena);
    }
    

    // carga un array con la cantidad pedida de valores y lo retorna
    public static int[] cargarArray(int longitud) {
        
        Random random = new Random();
        int[] array = new int[longitud];

        for (int i = 0; i < longitud - 1; i++) {
            array[i] = random.nextInt(100);
        }

        return array;
    }
}

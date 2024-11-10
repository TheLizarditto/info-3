package hashTabla;

public class HashTabla {
    private int[] tabla;

    // Constructor: inicializa la tabla con ceros
    public HashTabla() {
        tabla = new int[100];
    }

    // Método para insertar un elemento i en la tabla
    public void insertar(int i) {
        if (i >= 0 && i < tabla.length) {
            tabla[i]++;
        } else {
            System.out.println("Error: el valor " + i + " está fuera del rango permitido (0 a 99).");
        }
    }

    // Método para buscar un elemento i en la tabla
    public int buscar(int i) {
        if (i >= 0 && i < tabla.length) {
            return tabla[i];
        } else {
            System.out.println("Error: el valor " + i + " está fuera del rango permitido (0 a 99).");
            return 0;
        }
    }

    // Método para eliminar un elemento i de la tabla
    public void eliminar(int i) {
        if (i >= 0 && i < tabla.length) {
            if (tabla[i] > 0) {
                tabla[i]--;
            } else {
                System.out.println("El valor " + i + " no se encuentra en la tabla.");
            }
        } else {
            System.out.println("Error: el valor " + i + " está fuera del rango permitido (0 a 99).");
        }
    }
}
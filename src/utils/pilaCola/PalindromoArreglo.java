package pilaCola;

public class PalindromoArreglo {
    private PilaArreglo pila;
    private String cadena;
    private int caracteres;

    public PalindromoArreglo(int cantidad) {
        pila = new PilaArreglo(cantidad);
    }

    public void llenarPila(String cadena) {
        if (cadena == null || cadena.isEmpty()) {
            System.out.println("La cadena está vacía o es nula.");
            return;
        }
        this.cadena = cadena.toLowerCase();  // Convertimos toda la cadena a minúsculas
        caracteres = cadena.length();

        for (int i = caracteres / 2; i < caracteres; i++) {
            pila.push(this.cadena.charAt(i));
        }
    }

    public void comparar() {
        if (cadena == null) {
            System.out.println("Error: la cadena no ha sido inicializada. Llama a llenarPila primero.");
            return;
        }

        for (int i = 0; i < caracteres / 2; i++) {
            if (cadena.charAt(i) == pila.top()) {
                pila.pop();
            } else {
                System.out.println("No es palíndromo");
                return;
            }
        }
        System.out.println("Sí es palíndromo");
    }
}

package pilaColaLista;

public class Palindromo {
    public boolean esPalindromo(String frase) {
        Cola cola = new Cola();
        String fraseLimpia = "";

        // Limpiar la frase: eliminar espacios, signos de puntuación y convierte a minúsculas
        for (char c : frase.toLowerCase().toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                fraseLimpia += c;
                cola.enqueue(c);
            }
        }

        // Verificar si es palíndromo comparando izquierda a derecha con derecha a izquierda
        int longitud = fraseLimpia.length();
        boolean popOk;
        for (int i = 0; i < longitud / 2; i++) {
            if (fraseLimpia.charAt(i) != cola.top()) {
                return false;
            }
            popOk = cola.dequeue();
        }
        return true;
    }
}

package pilaCola;

public class PilaArreglo {
    private char[] pila;
    private int tos;

    // Crea una clase que represente una pila utilizando un arreglo
    public PilaArreglo(int capacidad) {
        pila = new char[capacidad];
        tos = -1;
    }

    public void push(char x) {
        if (tos + 1 > pila.length) {
            throw new StackOverflowError("La pila esta llena");
        }

        pila[++tos] = x;
    }

    public void pop() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila esta vacia");
        }

        tos--;
    }

    public char top() {
        return pila[tos];
    }

    public boolean isEmpty() {
        return tos == -1;
    }

    public void setTos(int tos) {
        this.tos = tos;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "";
        }

        String cadena = String.valueOf(pila[0]);

        for (int i = 1; i <= tos; i++) {
            cadena += pila[i];
        }
        
        return cadena;
    }
}
package pila_cola;

public class Pila {
    private char[] pila;
    private int tos;
    // Crea una clase que represente una pila utilizando un arreglo
    public Pila() {
        tos = -1;
    }

    public void push(char x) {
        pila[++tos] = x;
    }

    public void pop() {
        tos--;
    }

    public int top() {
        return pila[tos];
    }

    public boolean isEmpty() {
        return tos == -1;
    }

    public void setTos(int tos) {
        this.tos = tos;
    }

    public int getTos() {
        return tos;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "";
        }

        String cadena = String.valueOf(pila[0]);

        for (int i = 1; i < tos; i++) {
            cadena += pila[i];
        }
        
        return cadena;
    }
}
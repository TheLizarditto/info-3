package proyecto5;

public class Nodo {
    private int dato;
    private Nodo izquierda = null;
    private Nodo derecha = null;

    public Nodo() {}
    
    public Nodo(int dato) {
        this.setDato(dato);
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }
    
    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

    public int getDato() {
        return this.dato;
    }

    public Nodo getIzquierda() {
        return this.izquierda;
    }

    public Nodo getDerecha() {
        return this.derecha;
    }
}

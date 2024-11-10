package arbolRojinegro;

public class Nodo {
    int dato;
    Nodo izquierdo, derecho, padre;
    Color color;

    public Nodo(int dato) {
        this.dato = dato;
        this.color = Color.ROJO; // Los nodos nuevos se insertan como rojos inicialmente
        this.izquierdo = this.derecho = this.padre = null;
    }
}
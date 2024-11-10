package pilaColaLista;

public class NodoStr {
    private String dato;
    private NodoStr siguiente;

    public NodoStr() {}
    
    public NodoStr(String dato) {
        setDato(dato);
        setSiguiente(null);
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getDato() {
        return dato;
    }

    public void setSiguiente(NodoStr siguiente) {
        this.siguiente = siguiente;
    }

    public NodoStr getSiguiente() {
        return siguiente;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getDato());
    }
}

package arbolAVL;

class NodoAVL {
    private int valor;
    private NodoAVL izquierdo, derecho;
    private int altura;

    public NodoAVL(int valor) {
        this.valor = valor;
        this.altura = 1;
    }

    public NodoAVL() {}
    
    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }
    public void setIzquierdo(NodoAVL izquierdo) {
        this.izquierdo = izquierdo;
    }
    
    public void setDerecho(NodoAVL derecho) {
        this.derecho = derecho;
    }

    public NodoAVL getIzquierdo() {
        return this.izquierdo;
    }

    public NodoAVL getDerecho() {
        return this.derecho;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getAltura() {
        return this.altura;
    }
}
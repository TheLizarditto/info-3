package arbolRojinegro;

public class ArbolRojinegro {
    private Nodo raiz;

    public ArbolRojinegro() {
        this.raiz = null;
    }

    // Rotación a la izquierda
    private void rotarIzquierda(Nodo nodo) {
        Nodo hijoDerecho = nodo.derecho;
        nodo.derecho = hijoDerecho.izquierdo;

        if (hijoDerecho.izquierdo != null) {
            hijoDerecho.izquierdo.padre = nodo;
        }

        hijoDerecho.padre = nodo.padre;

        if (nodo.padre == null) {
            raiz = hijoDerecho;
        } else if (nodo == nodo.padre.izquierdo) {
            nodo.padre.izquierdo = hijoDerecho;
        } else {
            nodo.padre.derecho = hijoDerecho;
        }

        hijoDerecho.izquierdo = nodo;
        nodo.padre = hijoDerecho;
    }

    // Rotación a la derecha
    private void rotarDerecha(Nodo nodo) {
        Nodo hijoIzquierdo = nodo.izquierdo;
        nodo.izquierdo = hijoIzquierdo.derecho;

        if (hijoIzquierdo.derecho != null) {
            hijoIzquierdo.derecho.padre = nodo;
        }

        hijoIzquierdo.padre = nodo.padre;

        if (nodo.padre == null) {
            raiz = hijoIzquierdo;
        } else if (nodo == nodo.padre.izquierdo) {
            nodo.padre.izquierdo = hijoIzquierdo;
        } else {
            nodo.padre.derecho = hijoIzquierdo;
        }

        hijoIzquierdo.derecho = nodo;
        nodo.padre = hijoIzquierdo;
    }

    // Método de inserción principal
    public void insertar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        raiz = insertarBST(raiz, nuevoNodo); // hace la inserción normal
        corregirViolacion(nuevoNodo); // lo ajusta al funcionamiento de un arbol rojinegro
    }

    // Inserción estilo BST (Binary Search Tree)
    private Nodo insertarBST(Nodo raiz, Nodo nodo) {
        if (raiz == null) {
            return nodo;
        }

        if (nodo.dato < raiz.dato) {
            raiz.izquierdo = insertarBST(raiz.izquierdo, nodo);
            raiz.izquierdo.padre = raiz;
        } else if (nodo.dato > raiz.dato) {
            raiz.derecho = insertarBST(raiz.derecho, nodo);
            raiz.derecho.padre = raiz;
        }

        return raiz;
    }

    // Corrección de violaciones del árbol rojinegro después de la inserción
    private void corregirViolacion(Nodo nodo) {
        Nodo padre = null;
        Nodo abuelo = null;

        while (nodo != raiz && nodo.color != Color.NEGRO && nodo.padre.color == Color.ROJO) {
            padre = nodo.padre;
            abuelo = padre.padre;

            // Caso A: El padre de 'nodo' es el hijo izquierdo del abuelo
            if (padre == abuelo.izquierdo) {
                Nodo tio = abuelo.derecho;

                // Caso 1: El tío de 'nodo' es rojo
                if (tio != null && tio.color == Color.ROJO) {
                    abuelo.color = Color.ROJO;
                    padre.color = Color.NEGRO;
                    tio.color = Color.NEGRO;
                    nodo = abuelo;
                } else {
                    // Caso 2: 'nodo' es el hijo derecho de su padre
                    if (nodo == padre.derecho) {
                        rotarIzquierda(padre);
                        nodo = padre;
                        padre = nodo.padre;
                    }

                    // Caso 3: 'nodo' es el hijo izquierdo de su padre
                    rotarDerecha(abuelo);
                    Color temp = padre.color;
                    padre.color = abuelo.color;
                    abuelo.color = temp;
                    nodo = padre;
                }
            } else { // Caso B: El padre de 'nodo' es el hijo derecho del abuelo
                Nodo tio = abuelo.izquierdo;

                // Caso 1: El tío de 'nodo' es rojo
                if (tio != null && tio.color == Color.ROJO) {
                    abuelo.color = Color.ROJO;
                    padre.color = Color.NEGRO;
                    tio.color = Color.NEGRO;
                    nodo = abuelo;
                } else {
                    // Caso 2: 'nodo' es el hijo izquierdo de su padre
                    if (nodo == padre.izquierdo) {
                        rotarDerecha(padre);
                        nodo = padre;
                        padre = nodo.padre;
                    }

                    // Caso 3: 'nodo' es el hijo derecho de su padre
                    rotarIzquierda(abuelo);
                    Color temp = padre.color;
                    padre.color = abuelo.color;
                    abuelo.color = temp;
                    nodo = padre;
                }
            }
        }

        raiz.color = Color.NEGRO;
    }
    
    public void mostrarArbol() {
        mostrarArbol(raiz, "", true);
    }

    private void mostrarArbol(Nodo nodo, String sangria, boolean esDerecho) {
        if (nodo != null) {
            System.out.println(sangria + (esDerecho ? "D---- " : "I---- ") + nodo.dato + "(" + nodo.color + ")");
            mostrarArbol(nodo.izquierdo, sangria + (esDerecho ? "     " : "|    "), false);
            mostrarArbol(nodo.derecho, sangria + (esDerecho ? "     " : "|    "), true);
        }
    }
}

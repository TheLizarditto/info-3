package arbolAVL;

public class ArbolAVL {
    private NodoAVL raiz;

    // Método para obtener la altura de un nodo
    private int altura(NodoAVL nodo) {
        return (nodo == null) ? 0 : nodo.getAltura();
    }

    // Rotación simple a la derecha
    private NodoAVL rotarDerecha(NodoAVL y) {
        NodoAVL x = y.getIzquierdo();
        NodoAVL T2 = x.getDerecho();

        x.setDerecho(y);
        y.setIzquierdo(T2);

        y.setAltura(Math.max(altura(y.getIzquierdo()), altura(y.getDerecho())) + 1);
        x.setAltura(Math.max(altura(x.getIzquierdo()), altura(x.getDerecho())) + 1);

        return x;
    }

    // Rotación simple a la izquierda
    private NodoAVL rotarIzquierda(NodoAVL x) {
        NodoAVL y = x.getDerecho();
        NodoAVL T2 = y.getIzquierdo();

        y.setIzquierdo(x);
        x.setDerecho(T2);

        x.setAltura(Math.max(altura(x.getIzquierdo()), altura(x.getDerecho())) + 1);
        y.setAltura(Math.max(altura(y.getIzquierdo()), altura(y.getDerecho())) + 1);

        return y;
    }

    // Obtener el factor de balance de un nodo
    private int obtenerBalance(NodoAVL nodo) {
        return (nodo == null) ? 0 : altura(nodo.getIzquierdo()) - altura(nodo.getDerecho());
    }

    // Método de inserción
public NodoAVL insertar(NodoAVL nodo, int valor) {
    if (nodo == null)
        return new NodoAVL(valor);

    if (valor < nodo.getValor())
        nodo.setIzquierdo(insertar(nodo.getIzquierdo(), valor));
    else if (valor > nodo.getValor())
        nodo.setDerecho(insertar(nodo.getDerecho(), valor));
    else {
        System.out.println("El valor " + valor + " ya existe en el árbol. No se insertará.");
        return nodo;
    }

    nodo.setAltura(1 + Math.max(altura(nodo.getIzquierdo()), altura(nodo.getDerecho())));

    int balance = obtenerBalance(nodo);

    // Caso de Rotación Derecha
    if (balance > 1 && valor < nodo.getIzquierdo().getValor())
        return rotarDerecha(nodo);

    // Caso de Rotación Izquierda
    if (balance < -1 && valor > nodo.getDerecho().getValor())
        return rotarIzquierda(nodo);

    // Caso de Rotación Izquierda-Derecha
    if (balance > 1 && valor > nodo.getIzquierdo().getValor())
        return rotacionDerechaIzquierda(nodo);

    // Caso de Rotación Derecha-Izquierda
    if (balance < -1 && valor < nodo.getDerecho().getValor())
        return rotacionDerechaIzquierda(nodo);

    return nodo;
}

    // Método público para insertar
    public void insertar(int valor) {
        raiz = insertar(raiz, valor);
    }

   public void eliminar(int valor) {
        if (raiz == null) {
            System.out.println("El árbol no tiene elementos.");
        } else if (!contiene(raiz, valor)) {
            System.out.println("El elemento " + valor + " no está en el árbol.");
        } else {
            raiz = eliminarNodo(raiz, valor);
        }
    }

    // Método recursivo para verificar si el árbol contiene un valor
    private boolean contiene(NodoAVL nodo, int valor) {
        if (nodo == null) {
            return false;
        }
        if (valor < nodo.getValor()) {
            return contiene(nodo.getIzquierdo(), valor);
        } else if (valor > nodo.getValor()) {
            return contiene(nodo.getDerecho(), valor);
        } else {
            return true;
        }
    }

    // Método recursivo para eliminar un nodo y reequilibrar el árbol
    private NodoAVL eliminarNodo(NodoAVL nodo, int valor) {
        // Paso 1: Realizar la eliminación normal en un BST
        if (nodo == null) return nodo;

        if (valor < nodo.getValor()) {
            nodo.setIzquierdo(eliminarNodo(nodo.getIzquierdo(), valor));
        } else if (valor > nodo.getValor()) {
            nodo.setDerecho(eliminarNodo(nodo.getDerecho(), valor));
        } else {
            // Nodo encontrado: caso con uno o sin hijos
            if ((nodo.getIzquierdo() == null) || (nodo.getDerecho() == null)) {
                NodoAVL temp = (nodo.getIzquierdo() != null) ? nodo.getIzquierdo() : nodo.getDerecho();

                if (temp == null) {
                    temp = nodo;
                    nodo = null;
                } else {
                    nodo = temp;
                }
            } else {
                // Nodo con dos hijos: obtener el sucesor en orden
                NodoAVL temp = obtenerMinimoValor(nodo.getDerecho());
                nodo.setValor(temp.getValor());
                nodo.setDerecho(eliminarNodo(nodo.getDerecho(), temp.getValor()));
            }
        }

        // Si el nodo es null después de la eliminación
        if (nodo == null) return nodo;

        // Paso 2: Actualizar la altura del nodo actual
        nodo.setAltura(1 + Math.max(altura(nodo.getIzquierdo()), altura(nodo.getDerecho())));

        // Paso 3: Obtener el balance del nodo actual y reequilibrar si es necesario
        int balance = obtenerBalance(nodo);

        // Caso de rotación simple o doble para reequilibrar
        // Izquierda-Izquierda
        if (balance > 1 && obtenerBalance(nodo.getIzquierdo()) >= 0) {
            return rotarDerecha(nodo);
        }
        // Izquierda-Derecha
        if (balance > 1 && obtenerBalance(nodo.getIzquierdo()) < 0) {
            nodo.setIzquierdo(rotarIzquierda(nodo.getIzquierdo()));
            return rotarDerecha(nodo);
        }
        // Derecha-Derecha
        if (balance < -1 && obtenerBalance(nodo.getDerecho()) <= 0) {
            return rotarIzquierda(nodo);
        }
        // Derecha-Izquierda
        if (balance < -1 && obtenerBalance(nodo.getDerecho()) > 0) {
            nodo.setDerecho(rotarDerecha(nodo.getDerecho()));
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    // Método auxiliar para obtener el nodo con el valor mínimo en un subárbol
    private NodoAVL obtenerMinimoValor(NodoAVL nodo) {
        NodoAVL actual = nodo;
        while (actual.getIzquierdo() != null) {
            actual = actual.getIzquierdo();
        }
        return actual;
    }

// Rotación doble derecha-izquierda
    private NodoAVL rotacionDerechaIzquierda(NodoAVL nodo) {
        nodo.setDerecho(rotarDerecha(nodo.getDerecho()));
        return rotarIzquierda(nodo);
    }

    public void inOrder() {
        inOrder(raiz);
    }

    private void inOrder(NodoAVL nodo) {
        if (nodo != null) {
            inOrder(nodo.getIzquierdo());
            System.out.print(nodo.getValor() + " ");
            inOrder(nodo.getDerecho());
        }
    }
}
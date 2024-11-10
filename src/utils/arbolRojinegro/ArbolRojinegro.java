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
    
        while (nodo != raiz && nodo.color != Color.NEGRO && nodo.padre != null && nodo.padre.color == Color.ROJO) {
            padre = nodo.padre;
            abuelo = padre.padre;
    
            if (abuelo == null) break; // Agrega esta línea para evitar problemas si abuelo es null
    
            if (padre == abuelo.izquierdo) {
                Nodo tio = abuelo.derecho;
    
                if (tio != null && tio.color == Color.ROJO) {
                    abuelo.color = Color.ROJO;
                    padre.color = Color.NEGRO;
                    tio.color = Color.NEGRO;
                    nodo = abuelo;
                } else {
                    if (nodo == padre.derecho) {
                        rotarIzquierda(padre);
                        nodo = padre;
                        padre = nodo.padre;
                    }
    
                    rotarDerecha(abuelo);
                    Color temp = padre.color;
                    padre.color = abuelo.color;
                    abuelo.color = temp;
                    nodo = padre;
                }
            } else {
                Nodo tio = abuelo.izquierdo;
    
                if (tio != null && tio.color == Color.ROJO) {
                    abuelo.color = Color.ROJO;
                    padre.color = Color.NEGRO;
                    tio.color = Color.NEGRO;
                    nodo = abuelo;
                } else {
                    if (nodo == padre.izquierdo) {
                        rotarDerecha(padre);
                        nodo = padre;
                        padre = nodo.padre;
                    }
    
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

    // Método principal para verificar todas las propiedades
    public boolean verificarPropiedades() {
        return verificarRaizNegra() && verificarPropiedadHijosRojos(raiz) && verificarCaminosNegros(raiz) != -1;
    }

    // Verificación de la Propiedad 2: La raíz debe ser negra
    private boolean verificarRaizNegra() {
        return raiz == null || raiz.color == Color.NEGRO;
    }

    // Verificación de la Propiedad 4: Si un nodo es rojo, ambos hijos deben ser negros
    private boolean verificarPropiedadHijosRojos(Nodo nodo) {
        if (nodo == null) return true;

        // Si el nodo actual es rojo, sus hijos deben ser negros
        if (nodo.color == Color.ROJO) {
            if ((nodo.izquierdo != null && nodo.izquierdo.color == Color.ROJO) ||
                (nodo.derecho != null && nodo.derecho.color == Color.ROJO)) {
                return false;
            }
        }

        // Verificación recursiva de los subárboles izquierdo y derecho
        return verificarPropiedadHijosRojos(nodo.izquierdo) && verificarPropiedadHijosRojos(nodo.derecho);
    }

    // Verificación de la Propiedad 5: Todos los caminos deben tener la misma cantidad de nodos negros
    private int verificarCaminosNegros(Nodo nodo) {
        if (nodo == null) return 1;

        int alturaNegraIzquierda = verificarCaminosNegros(nodo.izquierdo);
        int alturaNegraDerecha = verificarCaminosNegros(nodo.derecho);

        // Si alguna altura negra es -1 o no son iguales, retorna -1 indicando un error
        if (alturaNegraIzquierda == -1 || alturaNegraDerecha == -1 || alturaNegraIzquierda != alturaNegraDerecha) {
            return -1;
        }

        // Cuenta el nodo actual si es negro, y suma a la altura negra
        return alturaNegraIzquierda + (nodo.color == Color.NEGRO ? 1 : 0);
    }

    public int alturaNegra() {
        return alturaNegra(raiz);
    }

    private int alturaNegra(Nodo node) {
        if (node == null) {
            return 0;
        }

        // Calcula la altura negra de uno de los caminos
        int alturaNegra = alturaNegra(node.izquierdo);
        
        // Solo cuenta los nodos negros en la altura negra
        if (node.color == Color.NEGRO) {
            alturaNegra++;
        }

        return alturaNegra;
    }
}

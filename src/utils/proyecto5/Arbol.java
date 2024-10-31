package proyecto5;

import java.util.Random;

public class Arbol {
    private Nodo root = new Nodo();

    public Arbol() {
        Random random = new Random();
        root.setDato(random.nextInt(26)); // número aleatorio entre 0 y 25
        final int n = 10;
        boolean bandera;

        for(int i = 0; i < n - 1; i++) {
            Nodo nuevo = new Nodo(random.nextInt(26));
            Nodo temp = root;
            bandera = false;

            do {
                if (intree(root, nuevo.getDato())) {
                    nuevo.setDato(random.nextInt(26));
                    continue;
                }

                if(nuevo.getDato() < temp.getDato()) {
                    if(temp.getIzquierda() == null) {
                        temp.setIzquierda(nuevo);
                        bandera = true;
                    } else {
                        temp = temp.getIzquierda();
                    }
                } else {
                    if(temp.getDerecha() == null) {
                        temp.setDerecha(nuevo);
                        bandera = true;
                    } else {
                        temp = temp.getDerecha();
                    }
                }
            } while (bandera == false);
            
        }
    }

    public boolean intree(Nodo base, int dato) {
        if (base == null) {
            return false;
        }
    
        // Verificar si el nodo actual tiene el dato buscado
        if (base.getDato() == dato) {
            return true;
        }
    
        // Buscar en el subárbol izquierdo o derecho
        return intree(base.getIzquierda(), dato) || intree(base.getDerecha(), dato);
    }
    

    public int depth() {
        return this.depth(this.getRoot());
    }

    public int depth(Nodo base) {
        // Si el nodo es nulo, la profundidad es 0
        if (base == null) {
            return 0;
        }

        // La profundidad del árbol es el máximo entre los dos subárboles más 1
        return 1 + Math.max(depth(base.getIzquierda()), depth(base.getDerecha()));
    }

    public String inorder() {
        return inorder(this.getRoot());
    }

    public String inorder(Nodo base) {
        if (base == null) {
            return "";
        }

        String retorno = String.valueOf(base.getDato());

        if (base.getIzquierda() != null) {
            retorno = inorder(base.getIzquierda()) + " " + retorno;
        }
        if (base.getDerecha() != null) {
            retorno = retorno + " " + inorder(base.getDerecha());
        }

        return retorno;
    }
    

    public Nodo getRoot() {
        return this.root;
    }
}
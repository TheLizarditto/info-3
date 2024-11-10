package arbolBinario;

import java.util.Random;

public class Arbol {
    private Nodo root;

    public Arbol() {
        root = new Nodo();
        this.generarValores();
    }

    public void generarValores() {
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

    public boolean isEmpty() {
        return root == null;
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

    public void dtree(int dato) {
        root = borrar(root, dato);
        if (root != null) {
            System.out.println("Recorrido inorder después de borrar el nodo:");
            inorder(root);
        }
    }

    private Nodo borrar(Nodo root, int dato) {
        // Si el árbol está vacío
        if (root == null) {
            System.out.println("El valor " + dato + " no se encuentra en el árbol.");
            return root;
        }

        // Buscar el nodo a eliminar
        if (dato < root.getDato()) {
            root.setIzquierda(borrar(root.getIzquierda(), dato));
        } else if (dato > root.getDato()) {
            root.setDerecha(borrar(root.getDerecha(), dato));
        } else {
            // Nodo encontrado: caso de nodo con un solo hijo o sin hijos
            if (root.getIzquierda() == null)
                return root.getDerecha();
            else if (root.getDerecha() == null)
                return root.getIzquierda();

            // Nodo con dos hijos: obtener el sucesor en el recorrido inorder
            root.setDato(min(root.getDerecha()));

            // Eliminar el sucesor inorder
            root.setDerecha(borrar(root.getDerecha(), root.getDato()));
        }
        return root;
    }

    private int min(Nodo root) {
        int min = root.getDato();
        while (root.getIzquierda() != null) {
            min = root.getIzquierda().getDato();
            root = root.getIzquierda();
        }
        return min;
    }

    // Método para imprimir el árbol en forma vertical mejorada
    public void imprimirArbol() {
        System.out.println(" ");
        imprimirArbol(root, "", true);
        System.out.println(" ");
    }

    private void imprimirArbol(Nodo nodo, String prefijo, boolean isLeft) {
        if (nodo != null) {
            System.out.println(prefijo + (isLeft ? "├── " : "└── ") + nodo.getDato());
            
            // Si el nodo actual tiene un hijo izquierdo, usamos "│   " como prefijo, de lo contrario, espacios en blanco
            String prefijoActual = prefijo + (isLeft ? "│   " : "    ");
            
            // Llamada recursiva para el subárbol izquierdo y derecho
            imprimirArbol(nodo.getIzquierda(), prefijoActual, true);
            imprimirArbol(nodo.getDerecha(), prefijoActual, false);
        }
    }

    public Nodo getRoot() {
        return this.root;
    }
}
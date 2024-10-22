package proyecto5;

import java.util.Random;

public class ArbolDuplicados {
    private Nodo root = new Nodo();
    
    public ArbolDuplicados() {
        Random random = new Random();
        root.setDato(random.nextInt(26)); // número aleatorio entre 0 y 25
        final int n = 10;
        boolean bandera;

        for(int i = 0; i < n; i++) {
            Nodo nuevo = new Nodo(random.nextInt(26));
            Nodo temp = root;
            bandera = false;

            do {
                if(nuevo.getDato() < temp.getDato()) {
                    if(temp.getIzquierda() == null) {
                        temp.setIzquierda(nuevo);
                        bandera = true;
                    } else {
                        temp = temp.getIzquierda();
                    }
                } else {
                    if(nuevo.getDato() >= temp.getDato()) { // agregamos el igual para admitir los valores repetidos
                        if(temp.getDerecha() == null) {
                            temp.setDerecha(nuevo);
                            bandera = true;
                        } else {
                            temp = temp.getDerecha();
                        }
                    }
                }
            } while (bandera == false);
            
        }
    }
}
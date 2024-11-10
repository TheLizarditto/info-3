package monticuloBinario;

import java.util.ArrayList;

public class MonticuloMinimo {
    private ArrayList<Integer> monticulo;

    public MonticuloMinimo() {
        monticulo = new ArrayList<>();
    }

    public void insertar(int elemento) {
        monticulo.add(elemento);
        subir(monticulo.size() - 1); // Acomoda el elemento subiendo desde el último índice
    }

    // Extrae el elemento de menor prioridad (en un montículo mínimo, es el mínimo elemento)
    public int extraerMinimo() {
        if (monticulo.isEmpty()) {
            throw new IllegalStateException("El monticulo esta vacio");
        }

        int minimo = monticulo.get(0); // El mínimo está en la raíz
        int ultimoElemento = monticulo.remove(monticulo.size() - 1);

        if (!monticulo.isEmpty()) {
            monticulo.set(0, ultimoElemento);
            bajar(0);
        }

        return minimo;
    }

    private void subir(int indice) {
        while (indice > 0) {
            int indicePadre = (indice - 1) / 2;
            if (monticulo.get(indice) >= monticulo.get(indicePadre)) {
                break;
            }
            
            intercambiar(indice, indicePadre);
            indice = indicePadre;
        }
    }

    private void bajar(int indice) {
        int tamaño = monticulo.size();
        while (true) {
            int indiceIzquierdo = 2 * indice + 1;
            int indiceDerecho = 2 * indice + 2;
            int indiceMenor = indice;

            // Encuentra el hijo menor
            if (indiceIzquierdo < tamaño && monticulo.get(indiceIzquierdo) < monticulo.get(indiceMenor)) {
                indiceMenor = indiceIzquierdo;
            }
            if (indiceDerecho < tamaño && monticulo.get(indiceDerecho) < monticulo.get(indiceMenor)) {
                indiceMenor = indiceDerecho;
            }

            if (indiceMenor == indice) {
                break;
            }

            intercambiar(indice, indiceMenor);
            indice = indiceMenor;
        }
    }

    public boolean isEmpty() {
        return monticulo.isEmpty();
    }

    private void intercambiar(int i, int j) {
        int temp = monticulo.get(i);
        monticulo.set(i, monticulo.get(j));
        monticulo.set(j, temp);
    }

    @Override
    public String toString() {
        return monticulo.toString();
    }
}

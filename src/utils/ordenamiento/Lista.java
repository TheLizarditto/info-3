package ordenamiento;

import java.util.ArrayList;

public class Lista<T> {
    private ArrayList<T> lista;

    public Lista() {
        lista = new ArrayList<>();
    }

    public void add(T valor) {
        lista.add(valor);
    }

    public void set(int indice, T valor) {
        if (indice >= 0 && indice < lista.size()) {
            lista.set(indice, valor);
        } else {
            throw new IndexOutOfBoundsException("Indice fuera de rango: " + indice);
        }
    }

    public void mostrar() {
        System.out.println(mostrar(0));
    }

    public String mostrar(int n) {
        if (n == lista.size()) {
            return "";
        }

        return lista.get(n) + " " + mostrar(n + 1);
    }

    public T get(int i) {
        return lista.get(i);
    }

    public int size() {
        return lista.size();
    }
}

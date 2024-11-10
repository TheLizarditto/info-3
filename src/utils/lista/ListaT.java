package lista;

import java.util.ArrayList;

// permite tener datos de cualquier tipo
public class ListaT<T> {
    private ArrayList<T> lista;

    public ListaT() {
        lista = new ArrayList<>();
    }

    public void add(T valor) {
        lista.add(valor);
    }

    public void set(int indice, T valor) {
        if (indice >= 0 && indice < lista.size()) {
            lista.set(indice, valor);
        } else {
            throw new IndexOutOfBoundsException("Indice fuera de rango, hay " + lista.size() + " elementos");
        }
    }

    public void mostrarValores() {
        System.out.println(mostrarValores(0));
    }

    public String mostrarValores(int n) {
        if (n == lista.size()) {
            return "";
        }

        return lista.get(n) + " " + mostrarValores(n + 1);
    }

    public T get(int i) {
        return lista.get(i);
    }

    public int size() {
        return lista.size();
    }
}

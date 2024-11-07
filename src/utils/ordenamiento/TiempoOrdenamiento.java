package ordenamiento;

import lista.ListaT;

public class TiempoOrdenamiento {
    private Insercion insercion = new Insercion();
    private Shellsort shellsort = new Shellsort();
    private Quicksort quicksort = new Quicksort();

    public long medirInsercion(ListaT<Integer> listaInt, ListaT<Double> listaDouble, ListaT<String> listaString) {
        long inicio = System.nanoTime();
        insercion.ordenarInt(listaInt);
        insercion.ordenarDouble(listaDouble);
        insercion.ordenarString(listaString);
        
        return (System.nanoTime() - inicio) / 1000;
    }

    public long medirShellsort(ListaT<Integer> listaInt, ListaT<Double> listaDouble, ListaT<String> listaString) {
        long inicio = System.nanoTime();
        shellsort.ordenarInt(listaInt);
        shellsort.ordenarDouble(listaDouble);
        shellsort.ordenarString(listaString);

        return (System.nanoTime() - inicio) / 1000;
    }

    public long medirQuicksort(ListaT<Integer> listaInt, ListaT<Double> listaDouble, ListaT<String> listaString) {
        long inicio = System.nanoTime();
        quicksort.ordenarInt(listaInt);
        quicksort.ordenarDouble(listaDouble);
        quicksort.ordenarString(listaString);

        return (System.nanoTime() - inicio) / 1000;
    }
}

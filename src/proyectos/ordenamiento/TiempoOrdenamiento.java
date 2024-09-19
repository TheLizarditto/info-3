package ordenamiento;
import java.util.List;

public class TiempoOrdenamiento {
    private Ordenador ordenador = new Ordenador();

    public long ordenarTiempo(List<Pedido> pedidos) {
        long inicio = System.currentTimeMillis();
        ordenador.insercion(pedidos);
        
        return System.currentTimeMillis() - inicio;
    }

    public long ordenarPrecio(List<Pedido> pedidos) {
        long inicio = System.currentTimeMillis();
        ordenador.shellsort(pedidos);

        return System.currentTimeMillis() - inicio;
    }

    public long ordenarNombre(List<Pedido> pedidos) {
        long inicio = System.currentTimeMillis();
        ordenador.quicksort(pedidos, 0, pedidos.size() - 1);

        return System.currentTimeMillis() - inicio;
    }
}

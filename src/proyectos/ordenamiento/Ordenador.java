package ordenamiento;

import java.util.List;

public class Ordenador {
    public void insercion(List<Pedido> pedidos) {
        Pedido aux = new Pedido();

        for (int i = 1; i < pedidos.size(); i++) {
            if (pedidos.get(i).getTiempo() < pedidos.get(i - 1).getTiempo()) {
                aux = pedidos.get(i);
                pedidos.get(i).setPrecio(pedidos.get(i - 1).getPrecio());
                pedidos.get(i).setNombre(pedidos.get(i - 1).getNombre());
                pedidos.get(i).setPrecio(pedidos.get(i - 1).getTiempo());
                pedidos.get(i - 1).setPrecio(aux.getPrecio());
                pedidos.get(i - 1).setNombre(aux.getNombre());
                pedidos.get(i - 1).setPrecio(aux.getTiempo());

                for (int j = i - 1; j >= 0; j--) {
                    if (pedidos.get(j).getTiempo() < pedidos.get(j - 1).getTiempo()) {
                        aux = pedidos.get(j);
                        pedidos.get(j).setPrecio(pedidos.get(j - 1).getPrecio());
                        pedidos.get(j).setNombre(pedidos.get(j - 1).getNombre());
                        pedidos.get(j).setPrecio(pedidos.get(j - 1).getTiempo());
                        pedidos.get(j - 1).setPrecio(aux.getPrecio());
                        pedidos.get(j - 1).setNombre(aux.getNombre());
                        pedidos.get(j - 1).setPrecio(aux.getTiempo());
                    }
                }
            }
        }
    }
}
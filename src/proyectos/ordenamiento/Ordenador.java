package ordenamiento;

import java.util.List;

public class Ordenador {
    public void insercion(List<Pedido> pedidos) {
        Pedido aux = new Pedido();

        for (int i = 1; i < pedidos.size(); i++) {
            // ordena por tiempo
            if (pedidos.get(i).getTiempo() < pedidos.get(i - 1).getTiempo()) {
                aux = pedidos.get(i);
                pedidos.set(i, pedidos.get(i - 1));
                pedidos.set(i - 1, aux);
                
                for (int j = i - 1; j > 0; j--) {
                    if (pedidos.get(j).getTiempo() < pedidos.get(j - 1).getTiempo()) {
                        aux = pedidos.get(j);
                        pedidos.set(j, pedidos.get(j - 1));
                        pedidos.set(j - 1, aux);
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public void shellsort(List<Pedido> pedidos) {
        // ordena por precio
        for (int gap = pedidos.size()/2; gap > 0; gap /= 2) {
            for (int i = gap; i < pedidos.size(); i++) {
                Pedido temp = pedidos.get(i);
                int j;

                for (j = i; j >= gap && pedidos.get(j - gap).getPrecio() > temp.getPrecio(); j -= gap) {
                    pedidos.set(j, pedidos.get(j - gap));
                }
                pedidos.set(j, temp);
            }

        }
    }

    public void quicksort(List<Pedido> pedidos, int left, int right) {
        
        if (left >= right) {
            return;
        }
        
        Pedido pivote = pedidos.get(0);
        Pedido temp;
        int i, j = right;

        for (i = left; i < pedidos.size(); i++) {
            if (pedidos.get(i).getNombre().compareTo(pivote.getNombre()) < 0) {
                temp = pedidos.get(i);
        
                for (j = right; j > 0; j--) {
                    if (pedidos.get(j).getNombre().compareTo(pivote.getNombre()) > 0) {
                        pedidos.set(i, pedidos.get(j));
                        pedidos.set(j, pivote);
                        pedidos.set(0, temp);
                        break;
                    }
                }
                
                quicksort(pedidos, 0, j);
                quicksort(pedidos, i, pedidos.size() - 1);
                break;
            }
        }
    }
}
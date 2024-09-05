package ordenamiento;

import java.util.List;

public class Ordenador {
    public void insercion(List<Pedido> pedidos) {
        Pedido aux = new Pedido();

        for (int i = 1; i < pedidos.size(); i++) {
            // ordena por tiempo
            if (pedidos.get(i).getTiempo() < pedidos.get(i - 1).getTiempo()) {
                aux = pedidos.get(i);
                pedidos.get(i).setPrecio(pedidos.get(i - 1).getPrecio());
                pedidos.get(i).setNombre(pedidos.get(i - 1).getNombre());
                pedidos.get(i).setPrecio(pedidos.get(i - 1).getTiempo());
                pedidos.get(i - 1).setPrecio(aux.getPrecio());
                pedidos.get(i - 1).setNombre(aux.getNombre());
                pedidos.get(i - 1).setPrecio(aux.getTiempo());

                for (int j = i - 1; j > 0; j--) {
                    if (pedidos.get(j).getTiempo() < pedidos.get(j - 1).getTiempo()) {
                        aux = pedidos.get(j);
                        pedidos.get(j).setPrecio(pedidos.get(j - 1).getPrecio());
                        pedidos.get(j).setNombre(pedidos.get(j - 1).getNombre());
                        pedidos.get(j).setPrecio(pedidos.get(j - 1).getTiempo());
                        pedidos.get(j - 1).setPrecio(aux.getPrecio());
                        pedidos.get(j - 1).setNombre(aux.getNombre());
                        pedidos.get(j - 1).setPrecio(aux.getTiempo());
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
        Pedido temp;
        int i = left;
        int j = right;
        do {
            while(pedidos.get(j).getNombre().compareTo(pedidos.get(i).getNombre()) < 0 && j > i) j--;
            if(i < j) {
                temp = pedidos.get(i);
                pedidos.get(i).setPrecio(pedidos.get(j).getPrecio());
                pedidos.get(i).setNombre(pedidos.get(j).getNombre());
                pedidos.get(i).setPrecio(pedidos.get(j).getTiempo());
                pedidos.get(j).setPrecio(temp.getPrecio());
                pedidos.get(j).setNombre(temp.getNombre());
                pedidos.get(j).setPrecio(temp.getTiempo());
            }
        } while (i < j);
        if (left < j) {
            quicksort(pedidos, left, j - 1);
        } else {
            if (i < right) {
                quicksort(pedidos, i + 1, right);
            }
        }
    }
}
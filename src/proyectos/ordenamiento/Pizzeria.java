package ordenamiento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pizzeria {
    List<Pedido> pedidos = new ArrayList<Pedido>();
    Ordenador ordenador = new Ordenador();
    Pedido pedido1 = new Pedido();
    Scanner input = new Scanner(System.in);
    String selMod;
    boolean bandera;
    int indice;
    
    public void agregar() {
        // agregar pedido
        pedido1.setNombre();
        pedido1.setPrecio();
        pedido1.setTiempo();
        pedidos.add(pedido1);   
    }

    public void modificar() {
        System.out.println("Lista de pedidos ingresados:");

        for (int i = 0; i < pedidos.size(); i++) {
            System.out.println("\n" + String.valueOf(i) + "\n" + pedidos.get(i));
        }

        do {
            bandera = false;
            indice = -1;
            do {
                try {
                    System.out.println("Ingrese el indice: ");
                    indice = input.nextInt();
                    bandera = true;
                } catch (Exception e) {
                    System.out.println("Debe ingresar un numero");
                }
            } while (bandera != true);

            if (indice < 0 || indice > pedidos.size()) {
                System.out.println("Debe ingresar un indice de la lista");
            }
        } while (indice < 0 || indice > pedidos.size());

        // modificar pedido
        bandera = false;
        do {
            System.out.println("Seleccione: \n1. Precio \n2. Tiempo \n3. Nombre");
            selMod = input.nextLine();
    
            switch (selMod) {
                case "1":
                    pedidos.get(indice).setPrecio();
                    bandera = true;
                    break;
    
                case "2":
                    pedidos.get(indice).setTiempo();
                    bandera = true;
                    break;
    
                case "3":
                    pedidos.get(indice).setNombre();
                    bandera = true;
                    break;
                
                default:
                    System.out.println("Debe ingresar una opcion del menu");
                    break;
            }
        } while (bandera == false);

    }

    public void remover() {
        System.out.println("Lista de pedidos ingresados:");

        for (int i = 0; i < pedidos.size() - 1; i++) {
            System.out.println("\n\n" + String.valueOf(i) + "\n" + pedidos.get(i));
        }

        do {
            bandera = false;
            indice = -1;
            do {
                try {
                    indice = input.nextInt();
                    bandera = true;
                } catch (Exception e) {
                    System.out.println("Debe ingresar un numero");
                }
            } while (bandera != true);

            if (indice < 0 || indice > pedidos.size()) {
                System.out.println("Debe ingresar un indice de la lista");
            }
        } while (indice < 0 || indice > pedidos.size());

        pedidos.remove(indice);
    }

    public void ordenarTiempo() {
        ordenador.insercion(pedidos);
    }
}

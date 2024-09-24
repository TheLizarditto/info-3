package ordenamiento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pizzeria {
    private List<Pedido> pedidos = new ArrayList<Pedido>();
    private TiempoOrdenamiento ordenamiento = new TiempoOrdenamiento();
    private Scanner input = new Scanner(System.in);
    private boolean bandera = false;
    private int indice, selMod;
    
    public void agregar(String nombre, float precio, int tiempo) {
        Pedido pedido1 = new Pedido();
        // agregar pedido
        pedido1.setNombre(nombre);
        pedido1.setPrecio(precio);
        pedido1.setTiempo(tiempo);
        pedidos.add(pedido1);
    }

    public void agregar() {
        Pedido pedido1 = new Pedido();
        // agregar pedido
        pedido1.setNombre();
        pedido1.setPrecio();
        pedido1.setTiempo();
        pedidos.add(pedido1);
        mostrar();
    }

    public void generarPedidos() {
        int cant = 0;
        bandera = false;
        long inicio = System.currentTimeMillis();
        
        do {
            try {
                System.out.println("Ingrese la cantidad de pedidos que quiere agregar: ");
                cant = input.nextInt();
                bandera = true;
            } catch (Exception e) {
                System.out.println("Debe ingresar un numero");
            }
        } while (bandera == false);
        
        do {
            // nombre, precio, tiempo
            agregar(String.valueOf((int)(Math.random() * 10)), (float)(Math.random() * 100 + 1), (int)(Math.random() * 100 + 1));
            cant--;
        } while (cant > 0);
        
        System.out.println("Tiempo de generacion: ");
        System.out.println(System.currentTimeMillis() - inicio);
        System.out.println("ms");
        System.out.println("\n");
    }

    public void modificar() {
        System.out.println("Lista de pedidos ingresados:");

        if (pedidos.size() == 0) {
            System.out.println("No hay pedidos agregados");
        } else {
            mostrar();
    
            do {
                bandera = false;
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
            do {
                System.out.println("Seleccione: \n0. Salir \n1. Precio \n2. Tiempo \n3. Nombre");
                bandera = false;
                do {
                    try {
                        selMod = input.nextInt();
                        bandera = true;
                    } catch (Exception e) {
                        System.out.println("Debe ingresar un numero");
                    }
                } while (bandera == false);
        
                switch (selMod) {
                    case 1:
                        pedidos.get(indice).setPrecio();
                        break;
        
                    case 2:
                        pedidos.get(indice).setTiempo();
                        break;
        
                    case 3:
                        pedidos.get(indice).setNombre();
                        break;
    
                    case 0:
                        System.out.println("Orden editada");
                        break;
                    
                    default:
                        System.out.println("Debe ingresar una opcion del menu");
                        break;
                }
                System.out.println("\n");
            } while (selMod != 0);
        }
    }

    public void remover() {
        if (pedidos.size() == 0) {
            System.out.println("No hay pedidos agregados");
        } else {
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
    }

    public void ordenarTiempo() {
        System.out.println("Tiempo de ordenamiento: " + ordenamiento.ordenarTiempo(pedidos) + " ms");
        mostrar();
    }

    public void ordenarPrecio() {
        System.out.println("Tiempo de ordenamiento: " + ordenamiento.ordenarPrecio(pedidos) + " ms");
        mostrar();
    }

    public void ordenarNombre() {
        System.out.println("Tiempo de ordenamiento: " + ordenamiento.ordenarNombre(pedidos) + " ms");
        mostrar();
    }

    public void mostrar() {
        for (int i = 0; i < pedidos.size(); i++) {
            System.out.println("\n" + String.valueOf(i) + "\n" + pedidos.get(i));
        }
    }
}

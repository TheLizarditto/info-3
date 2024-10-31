package proyecto2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Pizzeria pizzeria = new Pizzeria();
        String sel = "";

        do {
            do {
                System.out.println("Seleccione: \n1. Agregar \n2. Modificar \n3. Remover \n4. Ordenar por tiempo \n5. Ordenar por precio \n6. Ordenar por nombre \n7. Mostrar \n8. Generar pedidos \n0. Salir");
                sel = input.nextLine();
            } while (sel == "");
            
            switch (sel) {
                case "1":
                    pizzeria.agregar();
                    break;

                case "2":
                    pizzeria.modificar();
                    break;
                    
                case "3":
                    pizzeria.remover();
                    break;

                case "4":
                    pizzeria.ordenarTiempo();
                    break;

                case "5":
                    pizzeria.ordenarPrecio();
                    break;

                case "6":
                    pizzeria.ordenarNombre();
                    break;

                case "7":
                    pizzeria.mostrar();
                    break;

                case "8":
                    pizzeria.generarPedidos();
                    break;

                case "0":
                    System.out.println("Chau");
                    break;

                default:
                    System.out.println("Debe ingresar una opcion valida");
                    break;
            }
            System.out.println("\n");
        } while (Integer.parseInt(sel) != 0);
    }
}

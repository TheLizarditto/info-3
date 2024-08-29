package ordenamiento;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Pizzeria pizzeria = new Pizzeria();
        String sel;

        do {
            System.out.println("Seleccione: \n1. Agregar \n2. Modificar \n3. Remover \n4. Ordenar por tiempo \n5. Ordenar por precio \n6. Ordenar por nombre \n0. Salir");
            sel = input.nextLine();
            
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
                
                    break;

                case "6":
                    
                    break;

                case "0":
                    System.out.println("Chau");
                    break;

                default:
                    System.out.println("Debe ingresar una opcion valida");
                    break;
            }

        } while (Integer.parseInt(sel) != 0);


    
    }

}

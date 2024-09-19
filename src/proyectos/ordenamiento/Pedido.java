package ordenamiento;

import java.util.Scanner;

public class Pedido {
    private float precio;
    private int tiempo;
    private String nombre;
    private Scanner input = new Scanner(System.in);


    public void setPrecio() {
        boolean bandera = false;
        do {
            try {
                System.out.println("Ingrese el precio: ");
                this.precio = Float.parseFloat(input.nextLine());
                bandera = true;
            } catch (Exception e) {
                System.out.println("Debe ingresar un numero");
            }
        } while (bandera != true);
    }

    public void setTiempo() {
        boolean bandera = false;
        do {
            try {
                System.out.println("Ingrese el tiempo: ");
                this.tiempo = Integer.parseInt(input.nextLine());
                bandera = true;
            } catch (Exception e) {
                System.out.println("Debe ingresar un numero");
            }
        } while (bandera != true);
    }

    public void setNombre() {
        System.out.println("Ingrese el nombre: ");
        this.nombre = input.nextLine();
    }

    public float getPrecio() {
        return precio;
    }

    public int getTiempo() {
        return tiempo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nPrecio: " + String.valueOf(precio) + "\nTiempo: " + String.valueOf(tiempo);
    }

}

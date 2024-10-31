package proyecto5;

public class Main {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        System.out.println("El arbol tiene " + arbol.depth() + " niveles");
        
        System.out.println("Estos son los datos: " + arbol.inorder());
    }
}

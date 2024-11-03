package pila_cola;

public class Parentesis {
    private Pila pila;

    public Parentesis(int cantidad) {
        pila = new Pila(cantidad);
    }

    public boolean equilibrada(String expresion) {
        pila.setTos(-1);
        for (int i = 0; i < expresion.length(); i++) {
            if(expresion.charAt(i) == '(') {
                try {
                    pila.push('a'); // el valor puede ser cualquiera
                } catch (Exception e) {
                    System.out.println("Cantidad maxima de caracteres excedida, el maximo definido es 20 caracteres");
                    return false;
                }
            }
            if(expresion.charAt(i) == ')') {
                try {
                    pila.pop();
                } catch (Exception e) {
                    return false; // la pila no está equilibrada
                }
            }
        }

        if (pila.isEmpty() == true) {
            return true;
        } else {
            return false;
        }
    }
}

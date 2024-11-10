package pilaCola;

public class ParentesisArreglo {
    private PilaArreglo pila;

    public ParentesisArreglo(int cantidad) {
        pila = new PilaArreglo(cantidad);
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

        return pila.isEmpty();
    }
}

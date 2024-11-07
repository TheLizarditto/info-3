package pilaColaLista;

public class PilaStr {
    private NodoStr head;

    public PilaStr() {}

    // Agrega un elemento a la pila
    public void push(String dato) {
        NodoStr nuevo = new NodoStr(dato);
        nuevo.setSiguiente(head);
        head = nuevo;
    }

    public void pop() {
        if (head == null) {
            System.out.println("La pila esta vacia");
            return;
        }
        head = head.getSiguiente();
    }

    // Devuelve el último elemento agregado sin eliminarlo
    public String top() {
        if (this.isEmpty()) {
            return ""; // valor inválido si la pila está vacía
        }
        return head.getDato();
    }

    // Verifica si la pila está vacía
    public boolean isEmpty() {
        return head == null;
    }

    // muestra los valores de la pila en orden inverso y vacía la pila
    public String mostrarInverso() {
        String cadena = this.mostrarInverso(head);
        head = null;
        return cadena;
    }

    public String mostrarInverso(NodoStr base) {
        if(base == null) {
            return "";
        }

        return base.getDato() + " " + mostrarInverso(base.getSiguiente());
    }

    // Representación en String de la pila
    @Override
    public String toString() {
        if (this.isEmpty()) return "";

        NodoStr temp = head;
        StringBuilder retorno = new StringBuilder();

        while (temp != null) {
            retorno.append(temp.getDato()).append(" ");
            temp = temp.getSiguiente();
        }
        
        return retorno.toString().trim();
    }
}

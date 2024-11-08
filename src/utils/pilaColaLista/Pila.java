package pilaColaLista;

public class Pila {
    private Nodo head; 

    public Pila() {}

    // Agrega un elemento a la pila
    public void push(int dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.setSiguiente(head);
        head = nuevo;
    }

    public boolean pop() {
        if (head == null) {
            return true;
        }
        head = head.getSiguiente();
        return false;
    }

    // Devuelve el último elemento agregado sin eliminarlo
    public int top() {
        if (this.isEmpty()) {
            throw new RuntimeException("La cola esta vacia");
        }
        return head.getDato();
    }

    // Verifica si la pila está vacía
    public boolean isEmpty() {
        return head == null;
    }

    // Representación en String de la pila
    @Override
    public String toString() {
        if (this.isEmpty()) return "";

        Nodo temp = head;
        StringBuilder retorno = new StringBuilder();

        while (temp != null) {
            retorno.append(temp.getDato()).append(" ");
            temp = temp.getSiguiente();
        }
        
        return retorno.toString().trim();
    }
}

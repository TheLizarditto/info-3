package pilaColaLista;

public class Cola {
    private Nodo front;
    private Nodo back;

    public Cola() {
        front = null;
        back = null;
    }

    // Agrega un elemento al final de la cola
    public void enqueue(int dato) {
        Nodo nuevo = new Nodo(dato);

        if (this.isEmpty()) {
            front = nuevo;
            back = nuevo;
        } else {
            back.setSiguiente(nuevo);
            back = nuevo;
        }
    }

    // Elimina el primer elemento de la cola
    public boolean dequeue() {
        if (this.isEmpty()) {
            return true;
        }

        front = front.getSiguiente();

        if (front == null) {
            back = null; // Si la cola se queda vacía, ajusta el puntero `back`
        }
        return false;
    }

    // Retorna el primer elemento de la cola sin eliminarlo
    public int top() {
        if (this.isEmpty()) {
            throw new RuntimeException("La cola esta vacia");
        }
        return front.getDato();
    }

    // Verifica si la cola está vacía
    public boolean isEmpty() {
        return front == null;
    }

    public void ordenar() {
        Pila pila = new Pila();
    
        while (!this.isEmpty()) {
            // Extraemos un elemento de la cola
            int temp = this.top();
            this.dequeue();
    
            // Mientras la pila no esté vacía y el elemento en la parte superior de la pila sea mayor que el elemento que estamos extrayendo de la cola
            while (!pila.isEmpty() && pila.top() > temp) {
                // Volver a colocar el elemento de la pila a la cola
                this.enqueue(pila.top());
                pila.pop();
            }
    
            // Colocamos el elemento extraído de la cola en la pila
            pila.push(temp);
        }
    
        // Finalmente, movemos todos los elementos de la pila de vuelta a la cola Modificación para asegurarse de que el orden se mantenga
        Pila pilaAuxiliar = new Pila(); // Creamos una pila auxiliar
        
        while (!pila.isEmpty()) {
            pilaAuxiliar.push(pila.top()); // Transferimos a la pila auxiliar
            pila.pop();
        }
    
        // Ahora transferimos de la pila auxiliar de vuelta a la cola en el orden correcto
        while (!pilaAuxiliar.isEmpty()) {
            this.enqueue(pilaAuxiliar.top());
            pilaAuxiliar.pop();
        }
    }
    

    @Override
    public String toString() {
        if (this.isEmpty()) {
            throw new RuntimeException("La cola esta vacia");
        }

        // Creamos un StringBuilder para construir la representación de la cola
        StringBuilder cadena = new StringBuilder();
        Nodo temp = front;

        // Recorremos la cola y agregamos los elementos a la cadena
        while (temp != null) {
            cadena.append(temp.getDato()).append(" ");
            temp = temp.getSiguiente();
        }

        return cadena.toString().trim();  // Eliminamos el espacio extra al final
    }
}

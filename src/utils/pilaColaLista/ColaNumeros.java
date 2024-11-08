package pilaColaLista;

public class ColaNumeros {
    private Nodo front;
    private Nodo back;

    public ColaNumeros() {
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
    
    public int sumatoria() {
        if(this.isEmpty()) {
            return 0;
        }
    
        Nodo temp = front;
        int suma = 0;
    
        do {
            if(temp.getSiguiente() != null) {
                suma += temp.getDato();
                temp = temp.getSiguiente();
            } else {
                break;
            }
        } while (temp != null);
    
        back = null;
        front = null;
    
        return suma;
    }
}


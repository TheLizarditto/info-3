package pilaCola;

public class ColaArreglo {
    private int[] cola;
    private int frente; // Índice del primer elemento en la cola
    private int fin;    // Índice donde se agregará el siguiente elemento
    private int tamanioActual; // Tamaño actual de la cola

    public ColaArreglo(int capacidad) {
        cola = new int[capacidad];
        frente = 0;
        fin = -1;
        tamanioActual = 0;
    }

    public void enqueue(int valor) {
        if (tamanioActual == cola.length) {
            System.out.println("La cola esta llena. No se puede agregar el elemento " + valor);
            return;
        }

        fin = (fin + 1) % cola.length; // Mueve fin al siguiente índice circular
        cola[fin] = valor;
        tamanioActual++;
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("La cola esta vacia. No se puede eliminar elementos");
            return;
        }
        frente = (frente + 1) % cola.length; // Mueve frente al siguiente índice circular
        tamanioActual--;
    }

    public int top() {
        if (isEmpty()) {
            return -1; // Retorna un valor inválido si la cola está vacía
        }
        return cola[frente];
    }

    public boolean isEmpty() {
        return tamanioActual == 0;
    }

    public boolean isFull() {
        return tamanioActual == cola.length;
    }

    public int size() {
        return tamanioActual;
    }

    public void ordenarAscendente() {
        for (int i = 0; i < tamanioActual - 1; i++) {
            for (int j = i + 1; j < tamanioActual; j++) {
                int indexI = (frente + i) % cola.length;
                int indexJ = (frente + j) % cola.length;
                
                if (cola[indexI] > cola[indexJ]) {
                    // Intercambiar elementos
                    int temp = cola[indexI];
                    cola[indexI] = cola[indexJ];
                    cola[indexJ] = temp;
                }
            }
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Cola vacia";
        }
        
        StringBuilder cadena = new StringBuilder();

        for (int i = 0; i < tamanioActual; i++) {
            int index = (frente + i) % cola.length;
            cadena.append(cola[index]).append(" ");
        }
        return cadena.toString();
    }
}

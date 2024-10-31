package ordenamiento;

public class Quicksort {
    // el vector tiene que recibir el tamaño del array - 1
    public void ordenarInt(Lista<Integer> lista) {
        ordenarInt(lista, 0, lista.size() - 1);
    }

    public void ordenarDouble(Lista<Double> lista) {
        ordenarDouble(lista, 0, lista.size() - 1);
    }

    public void ordenarString(Lista<String> lista) {
        ordenarString(lista, 0, lista.size() - 1);
    }

    public void ordenarInt(Lista<Integer> lista, int start, int end){
        //caso base
        if(start >= end){
            return;
        }

        // indices para recorre el arreglo
        int left = start;
        int right = end;
        int pivot = lista.get(start); //pivote
        int aux; // variable para realizar intercambios

        while (left < right) {

            while (lista.get(right) > pivot && left < right) { //busco un elemento menor
                right--;
            }

            while (lista.get(left) <=  pivot && left < right) { //busco un elemento mayor
                left++;
            }

            if(left < right){
                aux = lista.get(left);
                lista.set(left, lista.get(right));
                lista.set(right, aux);
            }
        }

        //acomodo el pivote
        lista.set(start, lista.get(left));
        lista.set(left, pivot);

        ordenarInt(lista, start, left - 1);
        ordenarInt(lista, left + 1, end);
    }

    public void ordenarDouble(Lista<Double> lista, int start, int end){
        //caso base
        if(start >= end){
            return;
        }

        // indices para recorre el arreglo
        int left = start;
        int right = end;
        double pivot = lista.get(start); //pivote
        double aux; // variable para realizar intercambios

        while (left < right) {

            while (lista.get(right) > pivot && left < right) { //busco un elemento menor
                right--;
            }

            while (lista.get(left) <=  pivot && left < right) { //busco un elemento mayor
                left++;
            }

            if(left < right){
                aux = lista.get(left);
                lista.set(left, lista.get(right));
                lista.set(right, aux);
            }
        }

        //acomodo el pivote
        lista.set(start, lista.get(left));
        lista.set(left, pivot);

        ordenarDouble(lista, start, left - 1);
        ordenarDouble(lista, left + 1, end);
    }

    public void ordenarString(Lista<String> lista, int start, int end){
        //caso base
        if(start >= end){
            return;
        }

        // indices para recorre el arreglo
        int left = start;
        int right = end;
        String pivot = lista.get(start); //pivote
        String aux; // variable para realizar intercambios

        while (left < right) {

            while (lista.get(right).compareTo(pivot) > 0 && left < right) { //busco un elemento menor
                right--;
            }

            while (lista.get(left).compareTo(pivot) <= 0 && left < right) { //busco un elemento mayor
                left++;
            }

            if(left < right){
                aux = lista.get(left);
                lista.set(left, lista.get(right));
                lista.set(right, aux);
            }
        }

        //acomodo el pivote
        lista.set(start, lista.get(left));
        lista.set(left, pivot);

        ordenarString(lista, start, left - 1);
        ordenarString(lista, left + 1, end);
    }
}
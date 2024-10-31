package ordenamiento;

public class Shellsort {
    public void ordenarInt(Lista<Integer> array) {
            // ordena por precio
        for (int gap = array.size()/2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.size(); i++) {
                int temp = array.get(i), j;

                for (j = i; j >= gap && array.get(j - gap) > temp; j -= gap) {
                    array.set(j, array.get(j - gap));
                }
                array.set(j, temp);
            }
        }
    }

    public void ordenarDouble(Lista<Double> array) {
            // ordena por precio
        for (int gap = array.size()/2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.size(); i++) {
                double temp = array.get(i);
                int j;

                for (j = i; j >= gap && array.get(j - gap) > temp; j -= gap) {
                    array.set(j, array.get(j - gap));
                }
                array.set(j, temp);
            }
        }
    }

    public void ordenarString(Lista<String> array) {
            // ordena por precio
        for (int gap = array.size()/2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.size(); i++) {
                String temp = array.get(i);
                int j;

                for (j = i; j >= gap && array.get(j - gap).compareTo(temp) > 0; j -= gap) {
                    array.set(j, array.get(j - gap));
                }
                array.set(j, temp);
            }
        }
    }
}

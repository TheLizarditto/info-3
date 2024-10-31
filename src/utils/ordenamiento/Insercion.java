package ordenamiento;

public class Insercion {
    public void ordenarInt(Lista<Integer> array) {
        int aux;

        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) < array.get(i - 1)) {
                aux = array.get(i);
                array.set(i, array.get(i - 1));
                array.set(i - 1, aux);
                
                for (int j = i - 1; j > 0; j--) {
                    if (array.get(j) < array.get(j - 1)) {
                        aux = array.get(j);
                        array.set(j, array.get(j - 1));
                        array.set(j - 1, aux);
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public void ordenarDouble(Lista<Double> array) {
        double aux;

        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) < array.get(i - 1)) {
                aux = array.get(i);
                array.set(i, array.get(i - 1));
                array.set(i - 1, aux);
                
                for (int j = i - 1; j > 0; j--) {
                    if (array.get(j) < array.get(j - 1)) {
                        aux = array.get(j);
                        array.set(j, array.get(j - 1));
                        array.set(j - 1, aux);
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public void ordenarString(Lista<String> array) {
        String aux;

        for (int i = 1; i < array.size(); i++) {
            if (array.get(i).compareTo(array.get(i - 1)) < 0) {
                aux = array.get(i);
                array.set(i, array.get(i - 1));
                array.set(i - 1, aux);
                
                for (int j = i - 1; j > 0; j--) {
                    if (array.get(j).compareTo(array.get(j - 1)) < 0) {
                        aux = array.get(j);
                        array.set(j, array.get(j - 1));
                        array.set(j - 1, aux);
                    } else {
                        break;
                    }
                }
            }
        }
    }
}

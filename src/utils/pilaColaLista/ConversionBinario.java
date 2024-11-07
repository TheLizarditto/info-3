package pilaColaLista;

public class ConversionBinario {
    PilaStr pila;

    public ConversionBinario() {
        pila = new PilaStr();
    }

    public String convertir(int dato) {
        if(dato <= 2) {
            return dato / 2 + String.valueOf(dato % 2);
        }

        return convertir(dato / 2) + String.valueOf(dato % 2);
    }
}

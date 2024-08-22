package recursividad;

public class Inv {
    public String inv(String texto){
        if (texto.length() == 1) {
            return texto;
        } else {
            return inv(texto.substring(0, texto.length() - 2)) + texto.substring(0, texto.length() - 1);
        }
    }
}

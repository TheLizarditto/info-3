package recursividad;

public class Inv {
    public String inv(String texto){
        if (texto.length() == 1) {
            return texto;
        } else {
            return texto.charAt(texto.length() - 1) + inv(texto.substring(0, texto.length() - 1));
        }
    }
}
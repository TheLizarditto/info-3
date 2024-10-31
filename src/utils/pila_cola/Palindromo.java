package pila_cola;

public class Palindromo {
    private Pila pila = new Pila();
    private String cadena;

    public void acomodar() {
        this.setCadena(this.getCadena().replace(" ", "").toLowerCase());;
    }

    public void llenarPila(String cadena) {
        for(int i = cadena.length()/2; i < cadena.length(); i++) {
            pila.push(cadena.charAt(i));
        }
    }

    public void comparar() {
        for(int i = 0; i < cadena.length()/2; i++){
            if(cadena.charAt(i) == pila.top()){
                pila.pop();
            }
            else{
                System.out.println("No es palindromo");
                return;
            }
        }
        System.out.println("Si es palindromo");
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public String getCadena() {
        return cadena;
    }
}
package pilaColaLista;

public class Parentesis {
    private Pila pilaParentesis;
 
    public Parentesis() {
        pilaParentesis = new Pila();
    }

    public boolean chequearExpresion(String expresion) {
        boolean balanceado = true;

        for(int i = 0; i < expresion.length(); i++) {
            if(expresion.charAt(i) == '(') {
                pilaParentesis.push(1);
            } else if(expresion.charAt(i) == ')') {
                balanceado = pilaParentesis.pop();
            }
        }

        return pilaParentesis.isEmpty();
    }
}

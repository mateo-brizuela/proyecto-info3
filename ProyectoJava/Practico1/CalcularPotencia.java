package ProyectoJava.Practico1;

public class CalcularPotencia {

    public static void main(String[] args) {
        int base = 2;
        int exponente = 4;

        int resultado = potencia(base, exponente);

        System.out.println("en una potencia con base "+base+" y exponente "+exponente
            + " el resultado es "+resultado);
    }

    public static  int potencia(int base, int exponente){
        if(exponente == 0){
            return 1;
        }

        return base * potencia(base, exponente - 1);
    }

}

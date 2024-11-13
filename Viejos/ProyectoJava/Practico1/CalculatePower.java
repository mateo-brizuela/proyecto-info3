package ProyectoJava.Practico1;

public class CalculatePower {

    public static void main(String[] args) {
        int base = 2;
        int exponent = 4;

        int result = power(base, exponent);

        System.out.println("en una potencia con base "+base+" y exponente "+exponent
            + " el resultado es "+result);
    }

    public static  int power(int base, int exponent){
        if(exponent == 0){
            return 1;
        }

        return base * power(base, exponent - 1);
    }

}

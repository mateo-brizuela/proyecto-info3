package ProyectoJava.Practico1;

public class GetFactorial {
    public static void main(String[] args) {
        int num = 5;
        int result;

        result = factorial(num);
        System.out.println("factorial of " + num + " is " + result);
    }

    public static int factorial(int num){
        // caso base
        if(num == 1){
            return 1;
        }

        return  num * factorial(num - 1);
    }
}

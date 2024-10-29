package ProyectoJava.Practico1;

public class SumaEnteros {
    public static void main(String[] args) {
        int numero = 5;
        int resultado = suma(numero, 1);

        System.out.println("el resultado de sumar los primeros " + numero + " numeros es " + resultado );
    }


    public static int suma(int cantidad, int numero){
        if(cantidad == 0){
            return 0;
        }
    
        return numero + suma(cantidad - 1, numero + 1);
    }
    

}
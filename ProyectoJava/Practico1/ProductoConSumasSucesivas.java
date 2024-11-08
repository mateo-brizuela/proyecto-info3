package ProyectoJava.Practico1;

public class ProductoConSumasSucesivas {

    public static void main(String[] args) {
        int a = 2;
        int b = 4;

        int resultado = producto(a, b);
        System.out.println("El producto de " + a + " y " + b + " es " + resultado);
    }

    public static int producto(int a, int b) {
        // Caso base: si b es 0, el producto es 0
        if (b == 0) {
            return 0;
        }
        
        // Si b es negativo, llamamos a la función de manera recursiva con b positivo
        if (b < 0) {
            return -producto(a, -b); // Ajuste para el signo
        }
        
        // Suma sucesiva
        return a + producto(a, b - 1);
    }
}

package ProyectoJava.Practico1;

public class ContarUnosBinarios {

    public static void main(String[] args) {
        int numero = 13; // Ejemplo de número para probar
        int cantidadUnos = contarUnos(numero);

        System.out.println("El número de unos en la representación binaria de " + numero + " es: " + cantidadUnos);
    }

    public static int contarUnos(int n) {
        // Caso base: si n es 0, no hay unos en su representación binaria
        if (n == 0) {
            return 0;
        }

        // Contar unos: si n es impar, sumamos 1
        int esImpar = (n % 2 == 1) ? 1 : 0;

        // Llamada recursiva dividiendo n entre 2
        return esImpar + contarUnos(n / 2);
    }
}

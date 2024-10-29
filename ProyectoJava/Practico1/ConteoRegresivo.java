package ProyectoJava.Practico1;

public class ConteoRegresivo {

    public static void main(String[] args) {
        int n = 4;
        System.out.print("Conteo regresivo desde " + n + ": ");
        conteoRegresivo(n);
    }

    public static void conteoRegresivo(int n) {
        if (n < 1) {
            return; // Caso base: detener la recursión cuando n es menor a 1
        }
        
        System.out.print(n + (n > 1 ? ", " : "")); // Imprime el número y agrega una coma si no es el último
        conteoRegresivo(n - 1); // Llamada recursiva con n reducido en 1
    }
}

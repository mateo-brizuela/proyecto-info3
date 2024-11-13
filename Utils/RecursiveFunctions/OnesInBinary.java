package Utils.RecursiveFunctions;

public class OnesInBinary {

    public static void main(String[] args) {
        int num = 13; // Ejemplo de número para probar
        int numOfOnes = CountOnes(num);

        System.out.println("El número de unos en la representación binaria de " + num + " es: " + numOfOnes);
    }

    public static int CountOnes(int n) {
        // Caso base: si n es 0, no hay unos en su representación binaria
        if (n == 0) {
            return 0;
        }

        // Contar unos: si n es impar, sumamos 1
        int isOdd = (n % 2 == 1) ? 1 : 0;

        // Llamada recursiva dividiendo n entre 2
        return isOdd + CountOnes(n / 2);
    }
}

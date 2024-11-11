package Utils.RecursiveFunctions;

public class PrintReverseArray {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        
        System.out.println("Elementos del array en orden inverso:");
        printReverse(array, array.length - 1);
    }

    public static void printReverse(int[] array, int index) {
        // Caso base: si el índice es menor que 0, terminamos la recursión
        if (index < 0) {
            return;
        }
        
        // Imprimir el elemento actual
        System.out.print(array[index] + " ");
        
        // Llamada recursiva con el índice anterior
        printReverse(array, index - 1);
    }
}

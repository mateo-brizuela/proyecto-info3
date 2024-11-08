package ProyectoJava.Practico1;

public class ImprimirArregloInverso {

    public static void main(String[] args) {
        int[] arreglo = {1, 2, 3, 4, 5};
        
        System.out.println("Elementos del arreglo en orden inverso:");
        imprimirInverso(arreglo, arreglo.length - 1);
    }

    public static void imprimirInverso(int[] arreglo, int indice) {
        // Caso base: si el índice es menor que 0, terminamos la recursión
        if (indice < 0) {
            return;
        }
        
        // Imprimir el elemento actual
        System.out.print(arreglo[indice] + " ");
        
        // Llamada recursiva con el índice anterior
        imprimirInverso(arreglo, indice - 1);
    }
}

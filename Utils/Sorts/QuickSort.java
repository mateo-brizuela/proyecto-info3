package Utils.Sorts;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuickSort<T extends Comparable<T>> {
    private T[] array;

    // Constructor que recibe un arreglo ya inicializado
    public QuickSort(T[] array) {
        this.array = array;
    }

    // Constructor que genera un arreglo aleatorio del tamaño especificado
    public QuickSort(int size, T example) {
        generateRandomArray(size, example);
    }

    // Método para ordenar el arreglo usando QuickSort
    public void sort() {
        quickSort(0, array.length - 1);
    }

    // Método recursivo para QuickSort
    private void quickSort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
    }

    // Método para particionar el arreglo y colocar el pivote en la posición correcta
    private int partition(int low, int high) {
        T pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    // Método para intercambiar dos elementos del arreglo
    private void swap(int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Método para mostrar el arreglo ordenado
    public void displayArray() {
        System.out.println(Arrays.toString(array));
    }

    // Genera un arreglo aleatorio de números o cadenas
    @SuppressWarnings("unchecked")
    private void generateRandomArray(int size, T example) {
        Random random = new Random();
        array = (T[]) new Comparable[size];
        if (example instanceof Number) {
            for (int i = 0; i < size; i++) {
                array[i] = (T) (Double) (random.nextDouble() * 100); // genera un número aleatorio entre 0 y 100
            }
        } else if (example instanceof String) {
            for (int i = 0; i < size; i++) {
                array[i] = (T) String.valueOf((char) (random.nextInt(26) + 'A')); // genera letras aleatorias
            }
        }
    }

    // Método estático para leer un arreglo desde la consola
    public static <T extends Comparable<T>> T[] readArrayFromConsole(int size) {
        Scanner scanner = new Scanner(System.in);
        T[] array = (T[]) new Comparable[size];
        System.out.println("Ingrese los elementos del arreglo:");
        for (int i = 0; i < size; i++) {
            array[i] = (T) scanner.next();
        }
        return array;
    }
}

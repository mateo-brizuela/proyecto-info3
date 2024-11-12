package Utils.Sorts;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class InsertionSort<T extends Comparable<T>> {
    private T[] array;

    // Constructor que recibe un arreglo ya inicializado
    public InsertionSort(T[] array) {
        this.array = array;
    }

    // Constructor que genera un arreglo aleatorio del tamaño especificado
    public InsertionSort(int size, T example) {
        generateRandomArray(size, example);
    }

    // Método para ordenar el arreglo usando Insertion Sort
    public void sort() {
        for (int i = 1; i < array.length; i++) {
            T key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
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

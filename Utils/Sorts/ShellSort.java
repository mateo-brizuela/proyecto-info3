package Utils.Sorts;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ShellSort<T extends Comparable<T>> {
    private T[] array;

    // Constructor que recibe un arreglo ya inicializado
    public ShellSort(T[] array) {
        this.array = array;
    }

    // Constructor que genera un arreglo aleatorio del tamaño especificado
    public ShellSort(int size, T example) {
        generateRandomArray(size, example);
    }

    // Método para ordenar el arreglo usando Shell Sort
    public void sort() {
        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                T key = array[i];
                int j = i;
                while (j >= gap && array[j - gap].compareTo(key) > 0) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = key;
            }
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

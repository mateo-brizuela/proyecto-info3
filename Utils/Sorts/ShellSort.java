package Utils.Sorts;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ShellSort<T extends Comparable<T>> {
    private T[] array;

    // Constructor que recibe el arreglo a ordenar
    public ShellSort(T[] array) {
        this.array = array;
    }

    // Método de ordenamiento Shell Sort
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

    // Método para mostrar el arreglo en pantalla
    public void display() {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

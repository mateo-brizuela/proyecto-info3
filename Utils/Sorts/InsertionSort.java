package Utils.Sorts;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class InsertionSort<T extends Comparable<T>> {
    private T[] array;

    // Constructor que recibe el arreglo a ordenar
    public InsertionSort(T[] array) {
        this.array = array;
    }

    // Método de ordenamiento Insertion Sort
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

    // Método para mostrar el arreglo en pantalla
    public void display() {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

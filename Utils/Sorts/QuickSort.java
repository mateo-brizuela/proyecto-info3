package Utils.Sorts;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuickSort<T extends Comparable<T>> {
    private T[] array;

    // Constructor que recibe el arreglo a ordenar
    public QuickSort(T[] array) {
        this.array = array;
    }

    // Método de ordenamiento QuickSort
    public void sort() {
        quickSort(0, array.length - 1);
    }

    // Método recursivo de QuickSort
    private void quickSort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
    }

    // Partición para QuickSort
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

    // Método para mostrar el arreglo en pantalla
    public void display() {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

package Utils.Sorts;
import Utils.Sorts.*;
import java.util.Scanner;

import Utils.Sorts.InsertionSort;
import Utils.Sorts.ShellSort;
import Utils.Sorts.QuickSort;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        
        // Variables para almacenar los arreglos y objetos de cada tipo de ordenamiento
        InsertionSort<Integer> insertionSort = null;
        ShellSort<Integer> shellSort = null;
        QuickSort<Integer> quickSort = null;
        Integer[] array = null;
        
        do {
            System.out.println("Seleccione el método de ordenamiento:");
            System.out.println("1. Insertion Sort");
            System.out.println("2. Shell Sort");
            System.out.println("3. Quick Sort");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            option = scanner.nextInt();

            if (option == 4) {
                System.out.println("Saliendo...");
                break;
            }

            System.out.println("1) Ingresar arreglo por consola");
            System.out.println("2) Generar arreglo aleatoriamente");
            System.out.println("3) Mostrar arreglo en pantalla");
            System.out.print("Seleccione una opción: ");
            int subOption = scanner.nextInt();

            // Ejecutar la opción elegida para el método de ordenamiento seleccionado
            switch (option) {
                case 1: // Insertion Sort
                    insertionSort = handleSortOption(subOption, scanner);
                    if (insertionSort != null) insertionSort.sort();
                    break;

                case 2: // Shell Sort
                    shellSort = handleSortOption(subOption, scanner);
                    if (shellSort != null) shellSort.sort();
                    break;

                case 3: // Quick Sort
                    quickSort = handleSortOption(subOption, scanner);
                    if (quickSort != null) quickSort.sort();
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (option != 4);
        
        scanner.close();
    }

    private static Integer[] generateRandomArray(int size) {
        Random random = new Random();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100); // genera números aleatorios entre 0 y 100
        }
        return array;
    }

    private static InsertionSort<Integer> handleSortOption(int subOption, Scanner scanner) {
        switch (subOption) {
            case 1: // Ingresar arreglo por consola
                System.out.print("Ingrese el tamaño del arreglo: ");
                int size = scanner.nextInt();
                Integer[] array = readArrayFromConsole(size, scanner);
                return new InsertionSort<>(array);

            case 2: // Generar arreglo aleatoriamente
                System.out.print("Ingrese el tamaño del arreglo: ");
                size = scanner.nextInt();
                array = generateRandomArray(size);
                return new InsertionSort<>(array);

            case 3: // Mostrar arreglo en pantalla
                System.out.println("Arreglo no generado o ingresado aún.");
                return null;

            default:
                System.out.println("Opción inválida. Intente nuevamente.");
                return null;
        }
    }

    private static Integer[] readArrayFromConsole(int size, Scanner scanner) {
        Integer[] array = new Integer[size];
        System.out.println("Ingrese los elementos del arreglo:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }
}

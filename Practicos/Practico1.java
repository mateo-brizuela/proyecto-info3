package Practicos;

import static Utils.RecursiveFunctions.CalculatePower.power;
import static Utils.RecursiveFunctions.Countdown.doCountdown;
import static Utils.RecursiveFunctions.GetFactorial.factorial;
import static Utils.RecursiveFunctions.OnesInBinary.CountOnes;
import static Utils.RecursiveFunctions.PrintReverseArray.printReverse;
import static Utils.RecursiveFunctions.RecursiveMultiplication.multiplication;
import static Utils.RecursiveFunctions.AddInteger.add;

public class Practico1 {
    public static void main(String[] args) {
        System.out.println("/////////////// Ejercicio 1 ///////////////");

        int num = 5;
        int result;

        result = factorial(num);
        System.out.println("factorial of " + num + " is " + result);

        System.out.println("///////////////////////////////////////////");


        System.out.println("/////////////// Ejercicio 2 ///////////////");

        num = 5;
        result = add(num, 1);

        System.out.println("el resultado de sumar los primeros " + num + " numeros es " + result);

        System.out.println("///////////////////////////////////////////");


        System.out.println("/////////////// Ejercicio 3 ///////////////");

        int base = 2;
        int exponent = 4;
        
        result = power(base, exponent);
        
        System.out.println("En una potencia con base "+base+" y exponente "+exponent
        + " el resultado es "+result);

        System.out.println("///////////////////////////////////////////");



        System.out.println("/////////////// Ejercicio 4 ///////////////");

        int n = 4;
        System.out.print("Conteo regresivo desde " + n + ": ");
        doCountdown(n);

        System.out.println("///////////////////////////////////////////");



        System.out.println("/////////////// Ejercicio 5 ///////////////");

        int a = 2;
        int b = 4;

        result = multiplication(a, b);
        System.out.println("El producto de " + a + " y " + b + " es " + result);

        System.out.println("///////////////////////////////////////////");



        System.out.println("/////////////// Ejercicio 6 ///////////////");

        int[] array = {1, 2, 3, 4, 5};
        
        System.out.println("Elementos del array en orden inverso:");
        printReverse(array, array.length - 1);

        System.out.println("///////////////////////////////////////////");



        System.out.println("/////////////// Ejercicio 7 ///////////////");

        num = 13; // Ejemplo de número para probar
        int numOfOnes = CountOnes(num);

        System.out.println("El número de unos en la representación binaria de " + num + " es: " + numOfOnes);

        System.out.println("///////////////////////////////////////////");




    }
}

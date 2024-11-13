package Practicos;

import Utils.StackAndQueue.*;

public class Practico3 {

    // Ejercicio 1: Implementación de una pila
    public static void testArrayStack() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        stack.push(10);
        stack.push(20);
        System.out.println("Elemento en la cima de la pila: " + stack.top());
        System.out.println("Eliminar elemento de la cima de la pila: " + stack.pop());
        System.out.println("Elemento en la cima después de eliminar: " + stack.top());
    }

    // Ejercicio 2: Comprobación de palíndromos
    public static boolean isPalindrome(String input) {
        input = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        int len = input.length();
        for (int i = 0; i < len / 2; i++) {
            stack.push(input.charAt(i));
        }

        for (int i = (len + 1) / 2; i < len; i++) {
            if (stack.pop() != input.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // Ejercicio 3: Verificación de expresiones matemáticas
    public static boolean areParenthesesBalanced(String expr) {
        Stack<Character> stack = new Stack<>();
        for (char ch : expr.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // Ejercicio 4: Implementación de una cola
    public static void testArrayQueue() {
        ArrayQueue<String> queue = new ArrayQueue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        System.out.println("Elemento eliminado de la cola: " + queue.dequeue());
        System.out.println("Elemento eliminado de la cola: " + queue.dequeue());
        System.out.println("¿La cola está vacía?: " + queue.isEmpty());
    }

    // Ejercicio 5: Ordenar una cola en orden ascendente
    public static void sortQueueAscending(Queue<Integer> queue) {
        Queue<Integer> auxQueue = new Queue<>();
        
        while (!queue.isEmpty()) {
            int min = queue.dequeue();
            
            // Encuentra el valor mínimo en la cola original
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.dequeue();
                if (current < min) {
                    queue.enqueue(min);
                    min = current;
                } else {
                    queue.enqueue(current);
                }
            }
            
            // Coloca el valor mínimo en la cola auxiliar
            auxQueue.enqueue(min);
        }
        
        // Pasar todos los elementos ordenados de auxQueue de vuelta a queue
        while (!auxQueue.isEmpty()) {
            queue.enqueue(auxQueue.dequeue());
        }
    }
    
    
    

    public static void main(String[] args) {
        // Ejemplo del ejercicio 1: Uso de la pila
        System.out.println("Prueba de pila con arreglo:");
        testArrayStack();

        // Ejemplo del ejercicio 2: Verificación de palíndromos
        System.out.println("\nVerificación de palíndromo para 'anilina': " + isPalindrome("anilina"));
        System.out.println("Verificación de palíndromo para 'Hola mundo': " + isPalindrome("Hola mundo"));

        // Ejemplo del ejercicio 3: Verificación de paréntesis balanceados
        System.out.println("\nVerificación de balance de paréntesis para '(1+(2*3)+((8)/4))': " +
                           areParenthesesBalanced("(1+(2*3)+((8)/4))"));
        System.out.println("Verificación de balance de paréntesis para '(1+(2*3)+(8)/4))': " +
                           areParenthesesBalanced("(1+(2*3)+(8)/4))"));

        // Ejemplo del ejercicio 4: Uso de la cola
        System.out.println("\nPrueba de cola con arreglo:");
        testArrayQueue();

        // Ejemplo del ejercicio 5: Ordenar cola en orden ascendente
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(3);
        queue.enqueue(1);
        queue.enqueue(4);
        queue.enqueue(2);
        System.out.println("\nCola antes de ordenar:");
        displayQueue(queue);

        sortQueueAscending(queue);
        System.out.println("Cola después de ordenar en orden ascendente:");
        displayQueue(queue);
    }

    // Método auxiliar para mostrar los elementos de la cola
    public static void displayQueue(Queue<Integer> queue) {
        Queue<Integer> tempQueue = new Queue<>();
        while (!queue.isEmpty()) {
            int value = queue.dequeue();
            System.out.print(value + " ");
            tempQueue.enqueue(value);
        }
        System.out.println();

        // Restaurar los elementos a la cola original
        while (!tempQueue.isEmpty()) {
            queue.enqueue(tempQueue.dequeue());
        }
    }
}

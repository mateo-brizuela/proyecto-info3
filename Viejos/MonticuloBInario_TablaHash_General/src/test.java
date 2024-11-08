import java.util.Random;
import java.util.Scanner;

public class test {
public static void main(String[] args) {
    MonticuloBinario monticulo = new MonticuloBinario(); //monticulo binario
    HashTable<Object, Object> hashTable = new HashTable<>(); // tabla hash
    Random random = new Random();
    int menu_op = 0;
    var console = new Scanner(System.in);
    boolean exit = false;

    do{
        System.out.println("Se presenta un menu de opciones:\n");
        System.out.println(
                            "-------MONTICULO BINARIO-------\n"+
                            "1-Agregar x cantidad de numeros aleatorios\n"+
                            "2-Agregar elemento manualmente\n"+
                            "3-Extraer el elemento de mayor prioridad del monticulo (Eliminar Min)\n"+
                            "\n----------TABLA HASH-----------\n"+
                            "4-Agregar elemento a tabla hash\n"+
                            "5-Buscar elemento por clave\n"+
                            "6-Eliminar un elemento por su clave.\n"+
                            "\n-----GENERAL CON LIBRERIAS-----\n"+
                            "\n-------------------------------\n"+
                            "7--Salir\n");
        System.out.println("Seleccione una opcion:");
        menu_op = console.nextInt();
    switch (menu_op) {
        case 1:
            System.out.println("¿Cuantos numeros desea agregar?:");
            int n1=console.nextInt();
        // Agregar 10 números aleatorios en el rango de 0 a 100
            for (int i = 0; i < n1; i++) {
            int numeroAleatorio = random.nextInt(100); // Genera un número aleatorio en el rango [0, 100)
            monticulo.insertar(numeroAleatorio); // Inserta el número en el montículo
            }
        // Imprimir el montículo
            System.out.println("\nContenido del montículo después de las inserciones:");
            monticulo.imprimirMonticulo();
        break;

        case 2:
            System.out.println("Ingrese el numero que desea insertar:");
            Integer nAgregar = console.nextInt();
            monticulo.insertar(nAgregar);
        // Imprimir el montículo
            System.out.println("\nContenido del montículo después de la insercion:");
            monticulo.imprimirMonticulo();
       
        break;

        case 3:
        // Extraer el mínimo
        Integer min = monticulo.eliminarMin();
        System.out.println("Elemento extraído (mínimo): " + min);

        // Imprimir el montículo después de la extracción
        System.out.println("Contenido del montículo después de extraer el mínimo:");
        monticulo.imprimirMonticulo();
        break;

        case 4:
        System.out.println("\nIngrese la clave (numero entero o cadena):");
        console.nextLine();
        String keyInput = console.nextLine();
        // Convertir el valor en número si es posible
        Object key;
            try {
                key = Integer.parseInt(keyInput);
            } catch (NumberFormatException e) {
                key = keyInput; // Si no es número, se trata como cadena
                }
 
        System.out.println("Ingrese el valor (puede ser número o cadena):");
        String valueInput = console.nextLine();

        // Convertir el valor en número si es posible
        Object value;
            try {
                value = Integer.parseInt(valueInput);
            } catch (NumberFormatException e) {
                value = valueInput; // Si no es número, se trata como cadena
            }

        hashTable.put(key, value);
        System.out.println("Elemento ingresado - Clave: " + key + ", Valor: " + value);

        // Mostrar valores ingresados por buckets
        System.out.println("\nValores ingresados en la tabla hash:");
        for (int i = 0; i < hashTable.getBucketsSize(); i++) {
            hashTable.printBucket(i); // Imprimir los contenidos de cada bucket
        }
        System.out.println();
        break;

        case 5:
         // Mostrar valores ingresados por buckets
         System.out.println("\nValores ingresados en la tabla hash:");
         for (int i = 0; i < hashTable.getBucketsSize(); i++) {
             hashTable.printBucket(i); // Imprimir los contenidos de cada bucket
         }
         System.out.println();

        System.out.println("\nIngrese la clave que desea buscar:");
        console.nextLine();  // Limpiar el buffer
        String searchKeyInput = console.nextLine();
        
        // Convertir el valor en número si es posible
        Object searchKey;
            try {
                searchKey = Integer.parseInt(searchKeyInput);
            } catch (NumberFormatException e) {
                searchKey = searchKeyInput; // Si no es número, se trata como cadena
            }

        // Buscar el elemento en la tabla hash
        Object searchResult = hashTable.search_element(searchKey);
            if (searchResult != null) {
                System.out.println("Elemento encontrado - [Clave: " + searchKey + ", Valor: " + searchResult+"]\n");
            } else {
                System.out.println("Elemento no encontrado para la clave: " + searchKey + "\n");
                }
        break;

        case 6:
          // Mostrar valores ingresados por buckets
          System.out.println("\nValores ingresados en la tabla hash:");
          for (int i = 0; i < hashTable.getBucketsSize(); i++) {
              hashTable.printBucket(i); // Imprimir los contenidos de cada bucket
          }
          System.out.println();
 
        System.out.println("\nIngrese la clave (número entero o cadena) del elemento a eliminar:");
        console.nextLine();
        String keyInput2 = console.nextLine();
        
        // Convertir la clave en número si es posible
        Object key2;
        try {
            key2 = Integer.parseInt(keyInput2); // Si es un número, se convierte
        } catch (NumberFormatException e) {
            key2 = keyInput2; // Si no es número, lo tratamos como cadena
        }
        
        // Llamar al método remove para eliminar el elemento
        hashTable.remove(key2);
        
        // Mostrar los valores por cada bucket después de la eliminación
        System.out.println("\nValores restantes en la tabla hash:");
        for (int i = 0; i < hashTable.getBucketsSize(); i++) {
            hashTable.printBucket(i); // Imprimir los contenidos de cada bucket
        }
        
        break;

        case 7:
        exit = true;
        break;
    }

    }while (exit != true);
   
    }

}

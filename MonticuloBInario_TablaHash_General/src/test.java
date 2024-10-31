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
                            "5-\n"+
                            "6-\n"+
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
        System.out.println(("\nElementos posibles de agregar en la tabla:\n1-Numero\n2-Cadena\nRespuesta:"));
        int n2 = console.nextInt();
        if(n2 == 1){
        System.out.println("\nIngrese el numero entero:");
        int input1 = console.nextInt();
        hashTable.put(input1);
        System.out.println("\nElemento ingresado: " + input1);
        }
        else{
        System.out.println("Ingrese cadena:");
        console.nextLine();  // Limpiar el buffer
        String input2 = console.nextLine();
        hashTable.put(input2);
        System.out.println("Elemento ingresado: " + input2);
        }
        // Mostrar valores ingresados por buckets
        System.out.println("\nValores ingresados en la tabla hash:");
        for (int i = 0; i < hashTable.getBucketsSize(); i++) {
            hashTable.printBucket(i); // Imprimir los contenidos de cada bucket
        }
        System.out.println();
        break;
    
        case 7:
        exit = true;
        break;
    }

    }while (exit != true);
   
    }

}

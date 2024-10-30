import java.util.Random;
import java.util.Scanner;

public class test {
public static void main(String[] args) {
    MonticuloBinario monticulo = new MonticuloBinario();
    Random random = new Random();
    int menu_op = 0;
    var consola = new Scanner(System.in);
    boolean exit = false;

    do{
        System.out.println("Se presenta un menu de opciones:\n");
        System.out.println(
                            "-------MONTICULO BINARIO-------\n"+
                            "1-Agregar x cantidad de numeros aleatorios\n"+
                            "2-Agregar elemento manualmente\n"+
                            "3-Extraer el elemento de mayor prioridad del monticulo (Eliminar Min)\n"+
                            "4-Salir\n");
        System.out.println("Seleccione una opcion:");
        menu_op = consola.nextInt();
    switch (menu_op) {
        case 1:
            System.out.println("¿Cuantos numeros desea agregar?:");
            int n=consola.nextInt();
        // Agregar 10 números aleatorios en el rango de 0 a 100
            for (int i = 0; i < n; i++) {
            int numeroAleatorio = random.nextInt(100); // Genera un número aleatorio en el rango [0, 100)
            monticulo.insertar(numeroAleatorio); // Inserta el número en el montículo
            }
        // Imprimir el montículo
            System.out.println("\nContenido del montículo después de las inserciones:");
            monticulo.imprimirMonticulo();
        break;

        case 2:
            System.out.println("Ingrese el numero que desea insertar:");
            Integer nAgregar = consola.nextInt();
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
        exit = true;
        break;
    }

    }while (exit != true);
   
    }

}

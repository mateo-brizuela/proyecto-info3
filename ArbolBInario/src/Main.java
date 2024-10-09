import java.util.*;

public class Main {
 public static void main(String[] args) {
//variables
        Tree arbol = new Tree();  // Crear el árbol
        Node raiz = null;         // Raíz del árbol inicialmente vacía
        Random rand = new Random();
        int menu_op = 0;
        var consola = new Scanner(System.in);
        boolean exit = false;
//inicio
do{
    System.out.println("Se presenta un menu de opciones:\n");
    System.out.println(
                        "1-Generar arbol con números aleatorios\n"+
                        "2-Metodo in Orden((izquierda, raíz, derecha)\n"+
                        "3-?\n"+
                        "4-Cantidad de niveles del arbol\n"+
                        "5-Borrar nodo\n"+
                        "6-Imprimir arbol binario\n"+
                        "7-Salir\n");
    System.out.println("Seleccione una opcion:");
    menu_op = consola.nextInt();

    switch (menu_op) {
        case 1:
             // Insertar 10 números aleatorios entre 0 y 25
        System.out.println("Insertando números:");
        for (int i = 0; i < 10; i++) {
            int numero = rand.nextInt(26);  // Genera un número entre 0 y 25
            System.out.print(numero + " ");
            raiz = arbol.insertar(numero, raiz);  // Insertar el número en el árbol
        }
        System.out.println("\n");
        break;

        case 2:
        // Mostrar los números en orden creciente
        System.out.println("\n\nNúmeros en el árbol (inorden):");
        arbol.inOrden(raiz);  // Realizar el recorrido inorden
        System.out.println("\n");
        break;

        case 3:
        break;

        case 4:
        System.out.println("\nLa cantidad de niveles del arbol binario es de: " + arbol.depth(raiz)+"\n");
        break;

        case 5:
        int opcion=0;
        System.out.println("\nÁrbol antes de la eliminación (Inorden):");
        arbol.inOrden(raiz);
        System.out.println();
        System.out.println("Ingrese el valor que dese borrar:");
        opcion=consola.nextInt();
        // Eliminar un nodo del árbol
        raiz = arbol.dtree(raiz, opcion);

        // Mostrar el árbol después de la eliminación
        System.out.println("Arbol después de la eliminación (Inorden):");
        arbol.inOrden(raiz);
        System.out.println("\n");
        break;

        case 6:
         System.out.println("\n\nÁrbol binario:");
         arbol.imprimirArbol(raiz, "", false);  // Imprimir el árbol
         System.out.println("\n");
        break;

        case 7:
        exit = true;
        break;
    }
}while(exit != true);      
  
    }
}

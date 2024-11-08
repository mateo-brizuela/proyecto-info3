import java.util.*;

public class Main {
 public static void main(String[] args) {
//variables
        SelfEquilTree tree = new SelfEquilTree();  // Crear el árbol
        Node root = null;         // Raíz del árbol inicialmente vacía
        Random rand = new Random();
        int menu_op = 0;
        var console = new Scanner(System.in);
        boolean exit = false;
//inicio
do{
    System.out.println("Se presenta un menu de opciones:\n");
    System.out.println(
                        "1-Generar tree con numeros aleatorios(no permite duplicados)\n"+
                        "2-Generar tree con numeros aleatorios(permite duplicados)\n"+
                        "3-Metodo in Orden((izquierda, raíz, derecha)\n"+
                        "4-Cantidad de niveles del arbol\n"+
                        "5-Borrar nodo\n"+
                        "6-Imprimir arbol binario\n"+
                        "7-Salir\n");
    System.out.println("Seleccione una opcion:");
    menu_op = console.nextInt();

    switch (menu_op) {
        case 1:
        // Insertar 10 números aleatorios entre 0 y 25
        System.out.println("\nInsertando números:");
        for (int i = 0; i < 10; i++) {
            int number = rand.nextInt(26);  // Genera un número entre 0 y 25
            System.out.print(number + " ");
            root = tree.insert(number, root);  // Insertar el número en el árbol
        }
        System.out.println("\n");
        break;

        case 2:
        // Insertar 10 números aleatorios entre 0 y 25
        System.out.println("\nInsertando números:");
        for (int i = 0; i < 10; i++) {
            int number = rand.nextInt(26);  // Genera un número entre 0 y 25
            System.out.print(number + " ");
            root = tree.insert_duplicate(number, root);  // Insertar el número en el árbol
        }
        System.out.println("\n");
        break;

        case 3:
        // Mostrar los números en orden creciente
        System.out.println("\n\nNúmeros en el árbol (inorden):");
        tree.inOrden(root);  // Realizar el recorrido inorden
        System.out.println("\n");
        break;

        case 4:
        System.out.println("\nLa cantidad de niveles del tree binario es de: " + tree.depth(root)+"\n");
        break;

        case 5:
        int option=0;
        System.out.println("\nÁrbol antes de la eliminación (Inorden):");
        tree.inOrden(root);
        System.out.println();
        System.out.println("Ingrese el valor que dese borrar:");
        option=console.nextInt();
        // Eliminar un nodo del árbol
        root = tree.dtree(root, option);

        // Mostrar el árbol después de la eliminación
        System.out.println("tree después de la eliminación (Inorden):");
        tree.inOrden(root);
        System.out.println("\n");
        break;

        case 6:
         System.out.println("\n\nÁrbol binario:");
         tree.printTree(root, "", false);  // Imprimir el árbol
         System.out.println("\n");
        break;

        case 7:
        exit = true;
        break;
    }
}while(exit != true);      
    }
}

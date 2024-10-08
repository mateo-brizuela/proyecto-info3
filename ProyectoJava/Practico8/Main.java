package ProyectoJava.Practico8;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        ArbolAVL arbol = new ArbolAVL();
        int opcion = 0;

        while (opcion != 8) {
            System.out.println("ingrese una opcion:");
            System.out.println("1) agregar un nodo al arbol");
            System.out.println("2) eliminar un nodo del arbol");
            System.out.println("3) leer el arbol en orden");
            System.out.println("8) salir");

            opcion = consola.nextInt();

            switch (opcion) {
                case 1:
                    arbol.agregar();
                    break;
                case 2:
                    arbol.eliminar();
                    break;
                case 3:
                    arbol.leerArbol(arbol.getRoot());
                    break;
            
                default:
                    break;
            }
        }

    }
}

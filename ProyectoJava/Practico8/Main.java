package ProyectoJava.Practico8;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        ArbolAVL2 arbol = new ArbolAVL2();
        int opcion = 0;

        arbol.agregarConParametro(30);
        arbol.agregarConParametro(40);
        arbol.agregarConParametro(20);
        arbol.agregarConParametro(10);
        arbol.agregarConParametro(50);
        arbol.agregarConParametro(60);
        arbol.agregarConParametro(5);

        while (opcion != 8) {
            System.out.println("ingrese una opcion:");
            System.out.println("1) agregar un nodo al arbol");
            System.out.println("2) eliminar un nodo del arbol");
            System.out.println("3) leer el arbol en orden");
            System.out.println("4) leer arbol detalladamente");
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

                case 4:
                    arbol.leerDetalleArbol(arbol.getRoot(), 1);
                    System.out.println("//////////////////////");
                    break;
            
                default:
                    break;
            }
        }

    }
}

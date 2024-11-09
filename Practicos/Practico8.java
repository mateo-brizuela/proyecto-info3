package Practicos;

public class Practico8 {
    public static void main(String[] args) {
        int[] secuence = {10,85,15,70,20,60,30,50,65,80,90,40,5,55};

        // creamos y cargamos un arbol para testear
        RBTree tree1 = new RBTree();
        for (int data : secuence) {
            tree1.insert();
        }
        tree1.printTree(tree1.getRoot(), ""); // impresion del arbol cargado
    } 
}

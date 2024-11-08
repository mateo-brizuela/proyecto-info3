import java.util.*;

public class Tree {
//atributos
private Node root;

//constructor
public Tree() {
    root = null;
}

//metodo para insertar un nodo (no permite duplicados)
Node insert(int value, Node t){
    if (t == null){
        // Si el árbol está vacío, crea un nuevo nodo con el value
        t = new Node(value);

    }else if(value < t.element){
        t.left=insert(value, t.left);

    }else if(value > t.element){
        t.right=insert(value, t.right);
    }
    return t;
}
// Método para insertar un nodo (permite duplicados)
Node insert_duplicate(int value, Node t) {
    if (t == null) {
        // Si el árbol está vacío, crea un nuevo nodo con el value
        t = new Node(value);
    } else if (value < t.element) {
        // Si el value es menor, se inserta en el subárbol izquierdo
        t.left = insert_duplicate(value, t.left);
    } else {
        // Si el value es mayor o igual, se inserta en el subárbol derecho (permitiendo duplicados)
        t.right = insert_duplicate(value, t.right);
    }
    return t; // Retorna la raíz del árbol modificado
}
//Método para imprimir el árbol de forma visual
void printTree(Node t, String prefix, boolean isLeft) {
    if (t != null) {
        System.out.println(prefix + (isLeft ? "├── " : "└── ") + t.element);
        printTree(t.left, prefix + (isLeft ? "│   " : "    "), true);
        printTree(t.right, prefix + (isLeft ? "│   " : "    "), false);
        }
}

//Método para recorrer el árbol en inorden (izquierda, raíz, derecha)
void inOrden(Node t){
    if( t != null){
        inOrden(t.left);
        System.out.print(t.element + " ");
        inOrden(t.right);
    }
}

int depth(Node t) {
    if (t == null) {//caso base
        return 0; // Si el árbol está vacío, la profundidad es 0
    } else {
        // LLamado recursivo
        if (depth(t.left)>depth(t.right)) {
            return depth(t.left)+ 1;  // Si el izquierdo es más profundo, sumamos 1
        } else {
            return depth(t.right) + 1;  // Si el derecho es más profundo o igual, sumamos 1
        }
    }
}

//ELIMINAR UN NODO
 // Método para encontrar el nodo mínimo (para el caso de dos hijos)
 Node findMin(Node t) {
    if(t != null){
        while (t.left != null) {
            t = t.left;
        }
    }
    return t;
}
//Método para eliminar el nodo mínimo en el subárbol dado
//El minimo siempre esta a la izquierda del arbol
Node eliminateMin(Node t){
    if(t==null){
    System.out.println("Arbol vacio.");
        return t;
    }
    else if(t.left != null){
        t.left = eliminateMin(t.left);
        return t;
    }
    else{
        return t.right;
    }
}
Node dtree(Node root, int value) {
    if (root == null) {//caso base:Si el arbol esta vacio
        System.out.println("El value " + value + " no se encuentra en el árbol.");
        return root;
    }
    //caso recursivo
    // Busca el nodo a eliminar
    if (value < root.element) {
        root.left = dtree(root.left, value);// Buscar en el subárbol izquierdo
    } else if (value > root.element) {
        root.right = dtree(root.right, value);// Buscar en el subárbol derecho

    //Nodo encontrado
    //caso 1:Nodo con 2 hijos
    } else if (root.left != null && root.right != null){
        root.element = findMin(root.right).element;// Reemplaza el value por el mínimo del subárbol derecho
        root.right = eliminateMin(root.right);// Elimina el nodo mínimo del subárbol derecho
    }
    else{
    //Caso 2:Nodo con uno o ningun hijo
        root = (root.left != null) ? root.left : root.right;// Reemplaza el nodo por su único hijo o null
    }
        return root;
}

}


import java.util.*;

public class Tree {
//atributos
private Node root;

//constructor
public Tree() {
    root = null;
}

//metodo para insertar un nodo
Node insertar(int valor, Node t){
    if (t == null){
        t = new Node(valor);

    }else if(valor < t.element){
        t.left=insertar(valor, t.left);

    }else if(valor > t.element){
        t.right=insertar(valor, t.right);
    }
    return t;
}

//Método para imprimir el árbol de forma visual
void imprimirArbol(Node t, String prefix, boolean isLeft) {
    if (t != null) {
        System.out.println(prefix + (isLeft ? "├── " : "└── ") + t.element);
        imprimirArbol(t.left, prefix + (isLeft ? "│   " : "    "), true);
        imprimirArbol(t.right, prefix + (isLeft ? "│   " : "    "), false);
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
 Node encontrarMin(Node t) {
    if(t != null){
        while (t.left != null) {
            t = t.left;
        }
    }
    return t;
}
//Método para eliminar el nodo mínimo en el subárbol dado
//El minimo siempre esta a la izquierda del arbol
Node eliminarMin(Node t){
    if(t==null){
    System.out.println("Arbol vacio.");
        return t;
    }
    else if(t.left != null){
        t.left = eliminarMin(t.left);
        return t;
    }
    else{
        return t.right;
    }
}
Node dtree(Node raiz, int valor) {
    if (raiz == null) {//caso base:SI el arbol esta vacio
        System.out.println("El valor " + valor + " no se encuentra en el árbol.");
        return raiz;
    }
    //caso recursivo
    // Busca el nodo a eliminar
    if (valor < raiz.element) {
        raiz.left = dtree(raiz.left, valor);// Buscar en el subárbol izquierdo
    } else if (valor > raiz.element) {
        raiz.right = dtree(raiz.right, valor);// Buscar en el subárbol derecho

    //Nodo encontrado
    //caso 1:Nodo con 2 hijos
    } else if (raiz.left != null && raiz.right != null){
        raiz.element = encontrarMin(raiz.right).element;// Reemplaza el valor por el mínimo del subárbol derecho
        raiz.right = eliminarMin(raiz.right);// Elimina el nodo mínimo del subárbol derecho
    }
    else{
    //Caso 2:Nodo con uno o ningun hijo
        raiz = (raiz.left != null) ? raiz.left : raiz.right;// Reemplaza el nodo por su único hijo o null
    }
        return raiz;
}

}


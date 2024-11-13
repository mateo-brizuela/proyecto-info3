package Utils.StackAndQueue;

 // clase generica que implementa una pila utilizando nodos
public class Stack<T> {

    private Node<T> top;

    public Stack() {
        this.top = null;
    }

    // recibe un elemento y crea un nuevo nodo
    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.setNext(top);
        top = newNode;
    }

    // retorna y elimina el elemento de la cima de la pila
    public T pop() {
        if (top == null) {
            System.out.println("Stack underflow");
            return null;
        }
        T data = top.getData();
        top = top.getNext();
        return data;
    }

    // simplemente retorna el elemento de la cima
    public T top() {
        if (top != null) {
            return top.getData();
        }
        return null;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

package Utils.StackAndQueue;

public class Node<T> {
    private T data;
    private Node<T> next;

    // constructor
    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    // getters y setters
    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}

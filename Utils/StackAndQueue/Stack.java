package Utils.StackAndQueue;


public class Stack<T> {
    private Node<T> top;

    public Stack() {
        this.top = null;
    }

    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.setNext(top);
        top = newNode;
    }

    public T pop() {
        if (top == null) {
            System.out.println("Stack underflow");
            return null;
        }
        T data = top.getData();
        top = top.getNext();
        return data;
    }

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

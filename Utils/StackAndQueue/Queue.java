package Utils.StackAndQueue;

public class Queue<T> {
    private Node<T> front, rear;
    private int size;  // Atributo para llevar el tamaño de la cola

    public Queue() {
        this.front = this.rear = null;
        this.size = 0;
    }

    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
        size++;  // Incrementar el tamaño al agregar un elemento
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
            return null;
        }
        T data = front.getData();
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        size--;  // Decrementar el tamaño al eliminar un elemento
        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void makeEmpty() {
        front = rear = null;
        size = 0;  // Reiniciar el tamaño
    }

    public int size() {
        return size;  // Retornar el tamaño actual de la cola
    }

    public T front() {
        if (isEmpty()) {
            return null;
        }
        return front.getData();
    }
}

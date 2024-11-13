package Utils.StackAndQueue;

public class ArrayQueue<T> {
    private T[] queue;
    private int front, rear, size;
    private static final int DEFAULT_SIZE = 20;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int size) {
        this.queue = (T[]) new Object[size];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public ArrayQueue() {
        this(DEFAULT_SIZE);
    }

    public void enqueue(T element) {
        if (size == queue.length) {
            System.out.println("Queue overflow");
        } else {
            rear = (rear + 1) % queue.length;
            queue[rear] = element;
            size++;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
            return null;
        } else {
            T data = queue[front];
            front = (front + 1) % queue.length;
            size--;
            return data;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void makeEmpty() {
        front = 0;
        rear = -1;
        size = 0;
    }
}

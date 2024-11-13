package Utils.StackAndQueue;

public class ArrayStack<T> {
    // arreglo generico
    private T[] stack;
    private int top;
    // esto lo hice para cambiar facilmente el tamaño del arreglo
    private static final int DEFAULT_SIZE = 20;


    @SuppressWarnings("unchecked")
    public ArrayStack(int size) {
        stack = (T[]) new Object[size];
        top = -1;
    }

    public ArrayStack() {
        this(DEFAULT_SIZE);
    }

    
    public void push(T element) {
        if (top < stack.length - 1) {
            stack[++top] = element;
        } else {
            System.out.println("Stack overflow");
        }
    }

    public T pop() {
        if (top >= 0) {
            return stack[top--];
        } else {
            System.out.println("Stack underflow");
            return null;
        }
    }

    public T top() {
        if (top >= 0) {
            return stack[top];
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

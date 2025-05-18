package Etapa4;

public class LinkedStack<T> implements Stack<T> {
    private Node<T> top;
    private int size;

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int numElements() {
        return size;
    }

    @Override
    public T top() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return top.getData();
    }

    @Override
    public T pop() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        T data = top.getData();
        top = top.getNext();
        size--;
        return data;
    }

    @Override
    public void push(T element) throws OverflowException {
        Node<T> newNode = new Node<>(element);
        newNode.setNext(top);
        top = newNode;
        size++;
    }
}

package Etapa4;

@SuppressWarnings("unchecked")
public class LinkedQueue<T> implements Queue<T> {
    private Node<T> front;  
    private Node<T> back;   
    private int size;

    public LinkedQueue() {
        front = null;
        back = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
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
    public void enqueue(T element) throws OverflowException {
        Node<T> newNode = new Node<>(element);
        
        if (isEmpty()) {
            front = newNode;
            back = newNode;
        } else {
            back.setNext(newNode);
            back = newNode;
        }
        size++;
    }

    @Override
    public T dequeue() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        
        T element = front.getData();
        front = front.getNext();
        size--;
        
        if (front == null) {
            back = null;  
        }
        
        return element;
    }

    @Override
    public T front() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return front.getData();
    }

    @Override
    public T back() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return back.getData();
    }
}

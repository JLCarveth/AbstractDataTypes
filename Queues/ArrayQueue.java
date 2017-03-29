/**
 * Implementation of a Queue ADT using a circular array
 * 2017/03/09
 * @author John L. Carveth
 * @version 1
 */
public class ArrayQueue<E> implements Queue<E> {

    /**
     * Since this is an array implementation, this queue must have a 
     * fixed size.
     */
    private int capacity = 1000;
    private int size;
    private int front, rear;
    private E[] data;

    /**
     * Constructor for default capacity of 1000.
     */
    public ArrayQueue() {
        size = 0;
        front = 0;
        rear = 0;
        data = (E[]) new Object[capacity];
    }

    /**
     * Constructor for a custom capacity
     * @param capacity the maximum number of elements that cn be added to the queue.
     */
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        size = 0;
        front = 0;
        rear = 0;
        data = (E[]) new Object[capacity];
    }

    /**
     * @return if the queue is empty
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * @return if the queue is full 
     */
    public boolean isFull() {
        return (size == capacity);
    }

    /**
     * Adds an element onto the end of the queue
     * @param e The Element to be added to the queue
     */
    public void enqueue(E e) {
        if (isFull()) {
            throw new IllegalStateException("ArrayQueue is full.");
        } else if (isEmpty()) {
            data[0] = e;
            rear = front = 0;
        } else {
            rear = (rear + 1) % capacity;
            data[rear] = e;
        }
        size++;
    }

    /**
     * Removes the 'oldest' element in the queue.
     * @return the removed element
     */
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("ArrayQueue is full");
        } else {
            E temp = data[front];
            data[front] = null;
            front = (front + 1) % capacity;
            size--;
            return temp;
        }
    }

    /**
     * @return the value of the front element without dequeuing it
     */
    public E peek() {
        return data[front];
    }

    /**
     * Removes all elements from the queue.
     */
    public void clear() {
        data = (E[]) new Object[capacity];
        front = rear = size = 0;
    }

    /**
     * Returns a string-representation of all elements in the queue.
     * @return string-representation of the queue.
     */
    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            StringBuffer s = new StringBuffer("[");
            for (int i=0; i < size; i++) {
                s.append(data[i]);
            }
            s.append("]");
            return s.toString();
        }
    }

}
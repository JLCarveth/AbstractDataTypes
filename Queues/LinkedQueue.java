/**
 * Implementation of a Queue ADT using Linked Elements
 * 2017/03/06
 * @author John L. Carveth
 * @version 1
 */

public class LinkedQueue<E> implements Queue<E> {

    /**
     * Pointer for the front of the Queue
     */
    private LinkedNode<E> front;
    /**
     * Pointer for the back of the Queue
     */
    private LinkedNode<E> back;

    /**
     * Nested node class
     */
    private static class LinkedNode<T> {
        /**
         * Points to the next node in the queue
         */
        private LinkedNode<T> next;
        /**
         * The value of the node
         */
        private T value;

        private LinkedNode(LinkedNode<T> next, T value) {
            this.next = next;
            this.value = value;
        }
    }

    public LinkedQueue() {
        front = null;
        back = null;
    }
    /**
     * @return if the stack is empty
     */
    public boolean isEmpty() {
        return (front == null);
    }
    /**
     * Adds an element onto the end of the queue
     * @param e The Element to be added to the queue
     */
    public void enqueue(E e) {
        /**
         * This implementation disallows null elements to be added to the queue
         */
        if (e == null) {
            throw new NullElementException();
        }
        if (isEmpty()) {
            LinkedNode<E> temp = new LinkedNode<E>(null, e);
            front = temp;
            back = temp;
        } else {
            LinkedNode<E> temp = new LinkedNode<E>(null, e);
            back.next = temp;
            back = back.next;
        }
    }
    /**
     * Removes the 'oldest' element in the queue.
     * @return the removed element
     */
    public E dequeue() {
        E temp;
        if (isEmpty()) {
            throw new EmptyQueueException("Cannot dequeue from an empty queue.");
        }else if (front != null && front.next == null) { // If there is only one element in the queue
            temp = front.value;
            front = null;
            back = null;
        } else {
            temp = front.value;
            front = front.next;
        }
        return temp;
    }
    /**
     * @return the value of the front element without dequeuing it
     */
    public E peek() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return front.value;
    }
    /**
     * Removes all elements from the queue.
     */
    public void clear() {
        while (!isEmpty()) {
            System.out.println(dequeue());
        }
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        LinkedNode head = front;
        StringBuffer s = new StringBuffer("[");
        while (head != null) {
            s.append(head.value);
            head = head.next;
            if (head != null) {
                s.append(",");
            }
        }
        s.append("]");
        return s.toString();
    }
}
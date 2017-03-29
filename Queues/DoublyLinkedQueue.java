public class DoublyLinkedQueue<E> implements Queue<E> {

    /**
     * For pointing to the front of the queue
     */
    private LinkedNode<E> front;

    /**
     * For pointing to the back of the queue.
     */
    private LinkedNode<E> back;

    /**
     * Private nested class. Node objects that form the
     * linked queue.
     */
    private static class LinkedNode<T> {
        private LinkedNode<T> prev;
        private LinkedNode<T> next;
        private T value;

        /**
         * LinkedNode constructor
         * @param prev the previous node
         * @param next the next node
         * @param value the value of the node
         */
        private LinkedNode(LinkedNode<T> prev, LinkedNode<T> next, T value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }

    /**
     * Doubly Linked Queue constructor
     */
    public DoublyLinkedQueue() {
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
        if (e == null) {
            throw new NullElementException();
        }
        if (isEmpty()) {
            LinkedNode<E> temp = new LinkedNode<E>(null, null, e);
            front = temp;
            back = temp;
        } else {
            LinkedNode<E> temp = new LinkedNode<E>(null, null, e);
            back.next = temp;
            temp.prev = back;
            back = temp;
        }
    }
    /**
     * Removes the 'oldest' element in the queue.
     * @return the removed element
     */
    public E dequeue() {
        E temp;
        if (isEmpty()) {
            throw new EmptyQueueException();
        } else if (front == back) {
            temp = front.value;
            front = null;
            back = null;
        } else {
            temp = front.value;
            front = front.next;
            front.prev = null;
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
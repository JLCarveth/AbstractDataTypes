/**
 * Stack implemented using a Linked List
 * @author John L. Carveth
 * @version 1
 */
public class LinkedStack<E> implements Stack<E> {
    private Elem<E> top;

    /**
     * LinkedStack constructor
     */
    public LinkedStack() {
        top = null;
    }

    /**
     * Static (private) nested classes can be accessed 
     * by their parents, but no one else
     */
    private static class Elem<T> {
        private T value;
        private Elem<T> next;

        private Elem(T value, Elem<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * Tests if the stack is empty.
     * @return if the stack is empty.
     */
    public boolean isEmpty() {
        return (top == null);
    }

    /**
     * Adds an element onto the top of the stack.
     * @param o the Element to push onto the stack
     * @return Whether the stack is empty or not.
     */
    public E push(E o) {
        Elem<E> temp = new Elem<E>(o, top);
        top = temp;
        return o;
    }

    /**
     * Removes the top element on the stack.
     * @return The element that was removed from the stack
     */
    public E pop() {
        E temp = top.value;
        top = top.next;
        return temp;
    }

    /**
     * Returns the topmost element in the stack,
     * without altering the stack.
     * @return the topmost element of the stack
     */
    public E peek() {
        return top.value;
    }

    /**
     * Returns a String representation of the data inside the stack.
     */
    public String toString() {
        Elem<E> head = top;
        String res = "[";
        if (head != null) {
            res = res + head.value;
            head = head.next;
            while (head != null) {
                res = res + "," + head.value;
                head = head.next;
            }
        }
        res = res + "]";
        return res;
    }

    /**
     * Removes everything from the stack.
     */
    public void clear() {
        top = null;
    }

}
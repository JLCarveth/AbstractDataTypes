/**
 * Stack implemented using an Array. Has limited size.
 * @author John L. Carveth
 * @version 1
 */
public class ArrayStack<E> implements Stack<E> {
    private E[] elems;
    private int top;

    /**
     * Constructor for ArrayStack implementation.
     * @param x Capacity of the stack. Cannot add more elements than this parameter.
    */
    public ArrayStack(int x) {
        elems = (E[]) new Object[x];
        top = 0;
    }

    /**
     * Tests if the stack is empty.
     * @return if the stack is empty.
     */
    public boolean isEmpty() {
        return (top == 0);
    }

    /**
     * Adds an element onto the top of the stack.
     * @param o the Element to push onto the stack
     * @return Whether the stack is empty or not.
     */
    public E push(E o) {
        elems[top] = o;
        top++;
        return o;
    }

    /**
     * Removes the top element on the stack.
     * @return The element that was removed from the stack
     */
    public E pop() {
        top--;
        E popped = elems[top];
        return popped;
    }

    /**
     * Returns the topmost element in the stack,
     * without altering the stack.
     * @return the topmost element of the stack
     */
    public E peek() {
        return elems[top-1];
    }

    /**
     * Removes everything from the stack.
     */
    public void clear() {
        while (top != 0) {
            pop();
        }
    }

}
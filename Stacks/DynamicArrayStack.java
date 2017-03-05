/**
 * ArrayStack that can resize itself dynamically as elements are 
 * pushed onto the stack.
 * @author John L. Carveth
 * @version 1
 */
public class DynamicArrayStack<E> implements Stack<E> {
    /**
     * Array to hold the contents of the stack
     */
    private E[] elems;
    /**
     * Default constant size of the array
     */
    private final int INITIAL = 25;
    /**
     * Is increased twofold everytime the array needs
     * to grow in size.
     */
    private int upperBound;
    /**
     * For keeping track of the size of the stack
     */
    private int top;

    /**
     * Constructor for DynamicArrayStack implementation
     */
    public DynamicArrayStack() {
        elems = (E[]) new Object[INITIAL];
        top = 0;
        upperBound = INITIAL;
    }

    /**
     * Tests if the stack is empty.
     * @return if the stack is empty.
     */
    public boolean isEmpty(){
        return (top == 0);
    }

    /**
     * Adds an element onto the top of the stack.
     * @param o the Element to push onto the stack
     * @return Whether the stack is empty or not.
     */
    public E push(E o) {
        if (top == elems.length) {
            expandArray();
        }
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
        for (int i=0; i < top; i++) {
            pop();
        }
    }

    /**
     * Called once the array is at capacity. 
     * A new array is created twice as large as the previous, and the
     * elements are copied over.
     */
    public void expandArray() {
        upperBound = upperBound * 2;
        E[] temp = (E[]) new Object[upperBound];

        for (int i=0; i < elems.length-1; i++) {
            temp[i] = elems[i];
        }
        elems = temp;
    }

    /**
     * @return upperBound
     */
    public int getUpperBound() {
        return upperBound;
    }
}
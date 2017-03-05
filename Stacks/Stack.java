public interface Stack<E> {
    /**
     * Tests if the stack is empty.
     * @return if the stack is empty.
     */
    public abstract boolean isEmpty();
    /**
     * Adds an element onto the top of the stack.
     * @param o the Element to push onto the stack
     * @return Whether the stack is empty or not.
     */
    public abstract E push(E o);
    /**
     * Removes the top element on the stack.
     * @return The element that was removed from the stack
     */
    public abstract E pop();
    /**
     * Returns the topmost element in the stack,
     * without altering the stack.
     * @return the topmost element of the stack
     */
    public abstract E peek();
    /**
     * Removes everything from the stack.
     */
    public abstract void clear();
}
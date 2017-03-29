public interface Queue<E> {
    /**
     * @return if the queue is empty
     */
    public abstract boolean isEmpty();
    /**
     * Adds an element onto the end of the queue
     * @param e The Element to be added to the queue
     */
    public abstract void enqueue(E e);
    /**
     * Removes the 'oldest' element in the queue.
     * @return the removed element
     */
    public abstract E dequeue();
    /**
     * @return the value of the front element without dequeuing it
     */
    public abstract E peek();
    /**
     * Removes all elements from the queue.
     */
    public abstract void clear();
}
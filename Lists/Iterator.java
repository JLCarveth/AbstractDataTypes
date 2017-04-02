public interface Iterator<E> {
    /**
     * Returns true if the iteration has more elements
     * @return true if the iteration has more elements.
     */
    public abstract boolean hasNext();
    /**
     * Returns the next element in the iteration
     * @return the next element in the iteration
     */
    public abstract E next();
}
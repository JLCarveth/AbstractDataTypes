/**
 * List interface using Generics.
 * @author John L. Carveth
 * @version 1.0
 * 2017/04/01
 */
public interface List<E> {
    /**
     * Adds the specified element to the specified index in the list.
     * @param index the specified position where the element will be added.
     * @param e the element to be added.
     */
    public abstract void add(int index, E e);
    /**
     * Appends the specified element to the end of the list.
     * @param e the element to be added.
     */
    public abstract void add(E e);

    /**
     * Removes the element at the specified index.
     * @param index the index of the element to remove.
     * @return the removed element.
     */
    public abstract E remove(int index);
    /**
     * Removes the specified element if it is in the list.
     * @param e the element to remove.
     * @return true if the list has changed as a result of the call.
     */
    public abstract boolean remove(E e);

    /**
     * Returns the element at the specified position in the list.
     * @param index the position of the required element.
     */
    public abstract E get(int index);
    /**
     * Replaces the element at the specified position in this list
     * with the specified element.
     * @param index the index of the element to replace.
     * @param e the element to be stored at the specified position.
     * @return the removed element.
     */
    public abstract E set(int index, E e);

    /**
     * Returns the index of the first occurence of the specified element in this list, or 
     * -1 if this list does not contain the element.
     * @param e the element to search for.
     * @return the index of the element or -1 if it does not exist in the list.
     */
    public abstract int indexOf(E e);
    /**
     * Returns the index of the last occurence of the specified element in this list, or 
     * -1 if this list does not contain the element.
     * @param e the element to search for.
     * @return the index of the element or -1 if it does not exist in the list.
     */
    public abstract int lastIndexOf(E e);

    /**
     * Returns true if the list contains the specified element.
     * @param e the element to search for.
     * @return true if the element is in the list.
     */
    public abstract boolean contains(E e);

    /**
     * The size of the list.
     * @return the size of the list.
     */
    public abstract int size();
    /**
     * Returns true if there are no elements in the list.
     * @return true if the list is empty.
     */
    public abstract boolean isEmpty();
}
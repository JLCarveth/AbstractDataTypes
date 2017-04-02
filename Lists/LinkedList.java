import java.util.NoSuchElementException;
public class LinkedList<E> implements List<E> {

    /**
     * Private nested class describing the Node objects used to
     * link the elements of the list together
     */
    private static class Node<T> {
        private T value;
        private Node<T> next;

        private Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * Private nexted Iterator class. Allows the user to iterate
     * over the contents of the Linked List.
     */
    private class LinkedListIterator<E> implements Iterator<E> {
        private Node<E> current;

        private LinkedList<E> list;

        public LinkedListIterator(LinkedList<E> list) {
            this.list = list;
            current = null;
        }

        /**
         * Checks if the iteration has more elements.
         * @return true if the iterator has more elements.
         */
        public boolean hasNext() {
            if (current == null) {
                return !list.isEmpty();
            } else {
                return current.next != null;
            }
        }

        /**
         * @return the next element in the iteration.
         */
        public E next() {
            if (current == null) {
                current = list.head;
            } else {
                current = current.next;
            }
            if (current == null) {
                throw new NoSuchElementException("Iterator at the end, or empty list.");
            }
            return current.value;
        }
    }

    public Iterator<E> iterator(){
        return new LinkedListIterator<E>(this);
    }

    /**
     * Number of elements in the list
     */
    private int size;
    /**
     * Head of the List
     */
    private Node<E> head;

    public LinkedList() {
        size = 0;
        head = null;
    }

    /**
     * Inserts an element into the front of the list.
     */
    private void addFirst(E e) {
        head = new Node<E>(e, head);
        size++;
    }

    /**
     * Adds the specified element to the specified index in the list.
     * @param index the specified position where the element will be added.
     * @param e the element to be added.
     */
    public void add(int index, E e) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<E> temp = head;
            for (int i=0; i < index-1; i++) {
                if (temp.next != null) {
                    temp = temp.next;
                }
            }
            temp.next = new Node<E>(e, temp.next);
            size++;
        }
    }
    /**
     * Appends the specified element to the end of the list.
     * @param e the element to be added.
     */
    public void add(E e) {
        if (isEmpty()) {
            addFirst(e);
        } else {
            Node<E> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node<E>(e, null);
            size++;
        }
    }

    /**
     * Removes the first element in the list.
     * @return the removed element.
     */
    public E removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Empty List.");
        }
        E temp = head.value;
        if (head.next == null) {
            head = null;
        } else {
            head = head.next;
        }
        size--;
        return temp;
    }

    /**
     * Not needed? 
     */
    private E removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException();
        } else if (head.next == null) {
            return removeFirst();
        } else {
            Node<E> temp = head;
            E value;
            for (int i=0; i < size-1; i++) {
                temp = temp.next;
            }
            value = temp.next.value;
            return value;
        }
    }

    /** 
     * Remove an element of the list by Index
     * @param index the index of the element to be removed
     * @return the removed element
     */
    public E remove(int index) {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove from an empty list.");
        } else if (size <= index || index < 0) {
            throw new IndexOutOfBoundsException();
        } else if (size == 1) {
            return removeFirst();
        } else if (index == size-1) {
            return removeLast();
        } else {
            Node<E> temp1 = head;
            Node<E> temp2 = head;
            for (int i=0; i <= index; i++) {
                temp1 = temp1.next;
            }
            for (int i=0; i < index; i++) {
                temp2 = temp2.next;
            }
            E value = temp1.value;

            temp1 = temp1.next;
            temp2.next = temp1;

            size--;
            return value;
        }
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     * @return true if the element was found and removed.
     */
    public boolean remove(E e) {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove from an empty list.");
        } else if (size == 1) {
            if (head.value.equals(e)) {
                head = null;
                size--;
                return true;
            } else {
                return false;
            }
        } else {
            Node<E> temp = head;
            for (int i=0; i < size; i++) {
                if (temp.value.equals(e)) {
                    remove(i);
                    return true;
                } else {
                    temp = temp.next;
                }
            }
            return false;
        }
    }

    /**
     * @param index the index of the element to be returned
     * @return the element at the specified position in this list.
     */
    public E get(int index) {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot get from an empty list.");
        } else if (size <= index || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<E> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp.value;
        }
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     * @param index index of the element to replace
     * @param e element to be store at the specified position
     * @return the element previously at the specified position
     */
    public E set(int index, E e) {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot set on an empty list.");
        } else if (size <= index || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<E> temp = head;
            for (int i=0; i < index; i++) {
                temp = temp.next;
            }
            E value = temp.value;
            temp.value = e;
            return value;
        }
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list, 
     * or -1 if this list does not contain the element. 
     * More formally, returns the lowest index i such that (e==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
     * @param e element to search for
     * @return the index of the first occurence of the specified element in this list, or -1 if this list does not contain the element.
     */
    public int indexOf(E e) {
        if (isEmpty()) {
            throw new IllegalStateException();
        } else {
            Node<E> temp = head;
            int index = 0;
            while (!(temp.value.equals(e))) {
                if (temp.next != null) {
                    temp = temp.next;
                    index++;
                }
            }
            if (temp.value.equals(e)) {
                return index;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurence of the specified element in this list, or 
     * -1 if this list does not contain the element.
     * @param e the element to search for.
     * @return the index of the element or -1 if it does not exist in the list.
     */
    public int lastIndexOf(E e) {
        if (isEmpty()) {
            throw new IllegalStateException();
        } else {
            Node<E> temp = head;
            int currentIndex = -1;
            for (int i=0; i < size; i++) {
                if (temp.value.equals(e)) {
                    currentIndex = i;
                }
                temp = temp.next;
            }
            return currentIndex;
        }
    }

    /**
     * Returns true if the list contains the specified element.
     * @param e the element to search for.
     * @return true if the element is in the list.
     */
    public boolean contains(E e) {
        if (isEmpty()) {
            return false;
        }
        else {
            Node<E> temp = head;
            while (temp.next != null) {
                if (temp.value.equals(e)) {
                    return true;
                } else {
                    temp = temp.next;
                }
            }
            return false;
        }
    }

    /**
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * @return true if the list contains no elements
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * @return a String representation of the list elements
     */
     public String toString() {
         if (isEmpty()) {
             return "[]";
         }
         StringBuffer s = new StringBuffer("[");
         Node<E> temp = head;
         s.append(temp.value + ",");
         while (temp.next != null) {
            temp = temp.next;
            s.append(temp.value);
            if (temp.next != null) {
                s.append(",");
            }
         }
         s.append("]");
         return s.toString();
     }
}
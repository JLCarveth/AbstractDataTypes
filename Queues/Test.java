public class Test {
    public static void main(String[] args) {
        LinkedQueue<Integer> lq = new LinkedQueue(); //No max-capacity
        DoublyLinkedQueue<Integer> dlq = new DoublyLinkedQueue(); //No max-capacity
        ArrayQueue<Integer> aq = new ArrayQueue(); //default capacity of 1000
        
        System.out.println("Testing isEmpty():");

        System.out.println("Linked Queue:");
        System.out.println(lq.isEmpty());
        System.out.println("Doubly-Linked Queue: ");
        System.out.println(dlq.isEmpty());
        System.out.println("Array Queue: ");
        System.out.println(aq.isEmpty());

        System.out.println("Enqueing integers 0-9...");
        for (int i=0; i < 10; i++) {
            lq.enqueue(i);
            dlq.enqueue(i);
            aq.enqueue(i);
        }

        System.out.println("Linked Queue:");
        System.out.println(lq.isEmpty());
        System.out.println("Doubly-Linked Queue: ");
        System.out.println(dlq.isEmpty());
        System.out.println("Array Queue: ");
        System.out.println(aq.isEmpty());

        for (int i=0; i < 10; i++) {
            System.out.print(lq.dequeue());
            System.out.print(dlq.dequeue());
            System.out.print(aq.dequeue());
            System.out.println();
        }

        lq.enqueue(1010);
        dlq.enqueue(1010);
        aq.enqueue(1010);

        System.out.println("Linked Queue peek():\t\t" + lq.peek());
        System.out.println("Doubly-Linked Queue peek():\t" + dlq.peek());
        System.out.println("Array Queue peek():\t\t" + aq.peek());

        System.out.println(lq);
        System.out.println(dlq);
        System.out.println(aq);

        lq.clear();
        dlq.clear();
        aq.clear();

        System.out.println(lq.isEmpty() + ", " + dlq.isEmpty() + ", " + aq.isEmpty());


    }
}
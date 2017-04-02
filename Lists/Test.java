public class Test {
    public static void main(String[] args) {
        //Create a new list of type Integer
        LinkedList<Integer> list = new LinkedList<Integer>();

        //Add 10,000 elements to the list
        for (int i = 0; i <= 10000; i++) {
            list.add(i);
        }

        System.out.println("List generated.");

        Iterator<Integer> li = list.iterator();
        Integer dummy;

        //Testing speed with the iterator
        long start = System.currentTimeMillis();
        while (li.hasNext()) {
            dummy = li.next();
        }
        long stop = System.currentTimeMillis();
        
        System.out.println("Time (ms) using Iterator: " + (stop - start));

        //Testing speed with the get() method
        start = System.currentTimeMillis();
        for (int i=0; i < list.size()-1; i++) {
            dummy = list.get(i);
        }
        stop = System.currentTimeMillis();

        System.out.println("Time (ms) using get method: " + (stop - start));

        System.out.println("Testing List operations: ");
        LinkedList<Integer> l2 = new LinkedList<Integer>();
        //Add elements to the list
        for (int i=0; i < 25; i++) {
            l2.add(i);
        }

        System.out.println(l2);
        l2.add(7, 99);//Add at a specific index
        System.out.println("L2 contains 23?\t" + l2.contains(23));//Does the list contain 23?
        l2.remove(23);//Remove an element (23)
        System.out.println("L2 contains 23?\t" + l2.contains(23));//It doesn't anymore!
        l2.set(15, 929);//Replace the element at index 15 with 929
        System.out.println(l2.get(15));//Get the element at index 15 (929)
        System.out.println(l2);//Print out the list.
    }
}
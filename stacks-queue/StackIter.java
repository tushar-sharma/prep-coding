/**
 * Implement a generic stack with Iterator
 */
import java.util.Iterator;

public class StackIter<Item> implements Iterable<Item>{

    private class Node<Item> {
        Node next;
        Item item;
    }

    public Iterator<Item> iterator() { return new ListIterator(); }

    /**
     * returns a @iterator to this stack to iterat items in LIFO order
     */
     private class ListIterator implements Iterator<Item> {

        private Node current = head;

        public boolean hasNext() { return current != null; }

        public Item next() {

            Item item = (Item) current.item;
            current = current.next;
            return item;
        }
    }

    private Node head = null;

    void push(String item) {

        Node oldhead = head;
        head = new Node();
        head.item = item;
        head.next = oldhead;
    }

    public static void main(String[] args) {

        String[] inputStr = {"back", "me", "read"};

        StackIter<String> sg = new StackIter<>();

        for (String it : inputStr) {
            sg.push(it);
        }

        Iterator<String> iter = sg.iterator();

        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}

/*
 * QueueOfStrings
 *
 * QueueOfStrings() : create an empty queue
 * void enqueue(String item) :  insert a new string onto queue
 * String dequeue()     : remove & return the string least recent added
 * boolean isEmpty() : is stack empty?
 */

public class QueueOfStrings {

    private class Node {
        String item;
        Node next;

        public Node(String item) {
            this.item = item;
        }
    }

    private Node first, last;

    public QueueOfStrings() {
        first = null;
        last = null;
    }

    public void enqueue(String item) {

       Node oldlast = last;

       last = new Node(item);
       last.next = null;

       if (oldlast != null) {
           oldlast.next = last;
       } else {
           first = last;
       }
    }

    public void printQueue() {

        Node iter = first;

        while (iter != null) {
            System.out.print(iter.item + " ");
            iter = iter.next;
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public String dequeue() {

        String popped = null;

        if (!isEmpty()) {
            popped = first.item;
            first = first.next;
        }
        return popped;
    }

    public static void main(String[] args) {
        //insert data into stack
        String[] inputDummyData = {"string1", "string2", "string3"};

        //create an empty stack
        QueueOfStrings  myqueue = new QueueOfStrings();

        for(String st : inputDummyData) {
            myqueue.enqueue(st);
        }

        myqueue.printQueue();

        myqueue.dequeue();

        myqueue.printQueue();
    }
}

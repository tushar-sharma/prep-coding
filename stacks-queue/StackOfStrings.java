/*
 * Stack of strings data type
 *
 * StackOfStrings() : create an empty stack
 * void push(String item) :  insert a new string onto stack
 * String pop()     : remove & return the string most recent string
 * boolean isEmpty() : is stack empty?
 */

public class StackOfStrings {

    private class Node {
        String item;
        Node next;

        public Node(String item) {
            this.item = item;
        }
    }

    private Node head;

    public StackOfStrings() {
        head = null;
    }

    public void push(String item) {

        Node oldhead = head;

        head = new Node(item);
        head.next = oldhead;

    }

    public void printStack() {
        Node iter = head;
        while (iter != null) {
            System.out.print(iter.item + " ");
            iter = iter.next;
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String pop() {
        String popped = null;
        if (!isEmpty()) {
            popped = head.item;
            head = head.next;
        }
        return popped;
    }

    public static void main(String[] args) {
        //insert data into stack
        String[] inputDummyData = {"string1", "string2", "string3"};

        //create an empty stack
        StackOfStrings mystack = new StackOfStrings();

        for(String st : inputDummyData) {
            mystack.push(st);
        }

        mystack.printStack();

        mystack.pop();

        mystack.printStack();
    }
}

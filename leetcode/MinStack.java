/**
 * https://leetcode.com/problems/min-stack/
 */
class Node{
    int x;
    int minimum;
    Node next;

    public Node(int x, int minimum) {
        this.x = x;
        this.minimum = minimum;
    }
}

class MinStack {

    Node head;

    public MinStack() {
        head = null;

    }

    public void push(int x) {

        int minimum;

        if (head == null) {
            minimum = x;
        }else {
            minimum = Math.min(head.minimum, x);
        }

        Node curr = new Node(x, minimum);
        curr.next = head;
        head = curr;
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.x;
    }

    public int getMin() {
       return head.minimum;
    }
}

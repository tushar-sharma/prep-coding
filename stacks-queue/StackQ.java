/*
 * Implement Stack using Queue
 *
 * push(x) - push element x onto slack
 * pop()  - remove element on topof the stack
 * top() - get the top element
 * empty() return whether the stack is empty
 */

import java.util.Deque;
import java.util.LinkedList;

public class StackQ<E>  {

    private Deque<E> queue1;
    private Deque<E> queue2;

    public StackQ() {
        queue1 = new LinkedList<E>();
        queue2 = new LinkedList<E>();
    }

    public void push(E x) {
        queue2.add(x);

        while (! queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }

        Deque temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public E peek() {

        return queue1.peek();
    }

    public E pop() {

        return queue1.remove();
    }

    public boolean empty() {

        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {
        StackQ<String> mystack = new StackQ<String>();

        mystack.push("1");
        mystack.push("2");
        mystack.push("3");
        mystack.push("4");
        System.out.println(mystack.peek()); //return 4
        mystack.pop();
        mystack.pop();
        System.out.println(mystack.peek()); //return 2
    }
}

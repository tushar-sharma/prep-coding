/*
 * Implement Queue using Stack
 * details: https://leetcode.com/problems/implement-queue-using-stacks/description/
 *
 * push(x) - push element x to the back of queue
 * pop() - remove the elment from the front of queue
 * peek() - get the front element
 * empty() - return whether the queue is empty
 */

import java.util.Stack;

public class QueueS<E>  {

    private Stack<E> stack1;
    private Stack<E> stack2;

    public QueueS() {
        stack1 = new Stack<E>();
        stack2 = new Stack<E>();
    }

    public void push(E x) {
        stack1.push(x);
    }

    public E peek() {

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    public E pop() {

        while (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public boolean empty() {

        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        QueueS<String> queue = new QueueS<String>();

        queue.push("1");
        queue.push("2");
        System.out.println(queue.peek()); //return 1
        queue.pop();
        System.out.println(queue.peek()); //return 2
    }
}

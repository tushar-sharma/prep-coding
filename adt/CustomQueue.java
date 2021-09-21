/*
 * Implementation of queue
 * enqueue
 * dequeue
 * */

import java.util.NoSuchElementException;

class Node<T> {
    T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }
}

public class CustomQueue<T>{

    private Node<T> first;
    private Node<T> last;
    private int n;

    public CustomQueue() {
        this.first = null;
        this.last = null;
        this.n = 0;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public void enqueue(T value) {

        Node<T> oldLast = this.last;

        this.last = new Node<T>(value);

        this.last.next = null;

        if(isEmpty()) {
            this.first = this.last;
        } else {
            oldLast.next = this.last;
        }

        this.n++;

    }

    public int size() {
        return this.n;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue Underflow");
        }

        T value = this.first.getValue();

        this.first = this.first.next;
        this.n--;

        if(isEmpty()) {
            this.last = null;
        }

        return value;
    }

    public T peek() {

        if(isEmpty()) {
            throw new NoSuchElementException("Queue Underflow");
        }
        return this.first.getValue();
    }

    public static void main(String[] args) {

        CustomQueue queue = new CustomQueue();

        System.out.println(queue.isEmpty());

        queue.enqueue(4);

        queue.enqueue(3);

        System.out.println(queue.peek());

        System.out.println(queue.size());

        queue.enqueue(2);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());


    }
}

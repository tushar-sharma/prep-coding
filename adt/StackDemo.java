/**
 * Stack Demo
 * Stack is LIFO
 */
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class StackDemo {
    public static void main(String[] args) {
        Deque<Integer> myStack = new ArrayDeque<Integer>();

        //insert values
        System.out.println("Pushing element 20");
        myStack.push(20);
        System.out.println("Pushing element -2");
        myStack.push(-2);
        System.out.println("Pushing element 5");
        myStack.push(5);

        //peek
        System.out.println("Top element in stack " + myStack.peek());

        //pop
        System.out.println("Pop latest element " + myStack.pop());

        //peek
        System.out.println("Top element in stack " + myStack.peek());

        System.out.println("Pushing element 100");
        myStack.push(100);

        //access stack elements
        //this iterator is fail safe
        Iterator<Integer> iterator = myStack.iterator();
        System.out.println("Printing elements of stack...");
        while(iterator.hasNext()) {
            System.out.print(iterator.next()+ " ");
        }
        System.out.println();

    }
}

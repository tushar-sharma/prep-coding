/**
 * Queue Demo
 * Queue is FIFO
 */
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class QueueDemo {
    public static void main(String[] args) {
        Deque<Integer> myQueue = new ArrayDeque<Integer>();

        //enqueue values
        System.out.println("Pushing element 20");
        myQueue.offer(20);
        System.out.println("Pushing element -2");
        myQueue.offer(-2);
        System.out.println("Pushing element 5");
        myQueue.offer(5);

        //peek
        System.out.println("Front element in queue " + myQueue.peek());

        //remove front element
        System.out.println("Remove front element " + myQueue.poll());

        //peek
        System.out.println("Front element in queue " + myQueue.peek());

        System.out.println("Pushing element 100");
        myQueue.offer(100);

        //access queue elements
        //this iterator is fail safe
        Iterator<Integer> iterator = myQueue.iterator();
        System.out.println("Printing elements of queue...");
        while(iterator.hasNext()) {
            System.out.print(iterator.next()+ " ");
        }
        System.out.println();
    }
}

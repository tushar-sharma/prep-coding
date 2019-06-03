import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Iterator;
/**
 * Insert the following nodes into an initally empty min heap : 12,5,15,9,13,7,15,10,3,20,4.
 * Using built in procedure
 */

public class Ex1 {

    public void insert(Iterator<Integer> iter) {
        Queue<Integer> minHeap = new PriorityQueue<Integer>();

        while (iter.hasNext()) {
            minHeap.add(iter.next());
        }

        System.out.println(minHeap);

    }

    public static void main(String[] args) {

        Ex1 ex1 = new Ex1();

        List<Integer> testInput = new ArrayList<>();
        testInput.add(12);
        testInput.add(5);
        testInput.add(15);
        testInput.add(9);
        testInput.add(13);
        testInput.add(7);
        testInput.add(15);
        testInput.add(10);
        testInput.add(3);
        testInput.add(20);
        testInput.add(4);

        ex1.insert(testInput.iterator());
    }
}

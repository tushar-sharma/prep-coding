import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Iterator;
import java.util.Comparator;

/**
 * Insert the following nodes into an initally empty max heap : 12,5,15,9,13,7,15,10,3,20,4.
 * Using built in procedure
 */

public class Ex2 {

    public void insert(Iterator<Integer> iter) {
        Queue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer value1, Integer value2) {
                return value2.compareTo(value1);
            }
        });

        while (iter.hasNext()) {
            maxHeap.add(iter.next());
        }

        System.out.println(maxHeap);

    }

    public static void main(String[] args) {

        Ex2 ex2 = new Ex2();

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

        ex2.insert(testInput.iterator());
    }
}

import java.util.*;

public class HeapDemo {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        System.out.println("Min heap");

        int[] nums = {3, 7, 9, 8, 5, 6, 1};

        System.out.println("array is " + Arrays.toString(nums));
        for (int num : nums) {
            pq.add(num);
        }

        System.out.println("Minimum element is " + pq.peek());

        System.out.println("Extract minimum element " + pq.poll());

        System.out.println("Extract minimum element " + pq.poll());

        System.out.println("Max heap");
        
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            pqMax.add(num);
        }

        System.out.println("Maximum element is " + pqMax.peek());

        System.out.println("Extract Maximum element " + pqMax.poll());

        System.out.println("Extract Maximum element " + pqMax.poll());

    }
}
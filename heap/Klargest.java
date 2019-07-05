import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Klargest {

    /**
     *@return the k largest element in the testInput
     *using maxheap
     */
    public static int findKlargestMaxH(int[] testInput, int k) {
        //max heap
        //O(n log n)
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer value1, Integer value2) {
                return value2.compareTo(value1);
            }
        });

        for (int i = 0; i < testInput.length; i++) {
            pq.add(testInput[i]);
        }

        int klargest = 0;
        while (k-- > 0) {
            klargest = pq.remove();
        }

        return klargest;
    }

    /**
     * @return the k largest element int the testInput
     * Using min heap
     * O(k log n)
     */

    public static int findKlargestMinH(int[] testInput, int k) {
        //min heap
        Queue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k ; i++) {
            pq.add(testInput[i]);
        }

        for (int i = k ; i < testInput.length; i++) {
            if(testInput[i] > pq.peek()) {
                pq.poll();
                pq.add(testInput[i]);
            }
        }

        return pq.poll();
    }

    public static void main(String[] args) {
        assert findKlargestMaxH(new int[]{7, 4, 6, 3, 9, 1},  2) == 7;

        assert findKlargestMinH(new int[]{7, 4, 6, 3, 9, 1}, 2) == 7;
    }
}

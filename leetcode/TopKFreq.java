import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

public class TopKFreq {

    public static void findTopK(int[] testInput, int kSize) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < testInput.length; i++) {
            if (freq.containsKey(testInput[i])) {
                freq.put(testInput[i], freq.get(testInput[i]) + 1);
            } else
                freq.put(testInput[i], 1);
        }

        /*for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            System.out.println("key " + entry.getKey() + " value " + entry.getValue());
        }*/

        //create a max heap
        // new PriorityQueue<>((a,b) -> (b.getValue() - a.getValue()));

        Queue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                return b.getValue().compareTo(a.getValue());
            }
        });

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            maxHeap.add(entry);
        }

        List<Integer> result = new ArrayList<>();

        while (result.size() < kSize) {
            Map.Entry<Integer, Integer> myEntry = maxHeap.poll();
            result.add(myEntry.getKey());
        }

        System.out.println(result);


    }

    public static void main(String[] args) {
        findTopK(new int[]{1, 1, 2, 2, 3, 4, 3, 3, 1, 3}, 2);
    }
}

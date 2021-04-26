
class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        if (nums.length == k) {
            return nums;
        }

        Map<Integer, Integer> freq = new HashMap<>();

        int[] output = new int[k];

        //fill the frequencies

        for (int num : nums) {

            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // init heap 'the less frequent element first
        Queue<Integer> heap = new PriorityQueue<>(
            (n1, n2) -> freq.get(n1)- freq.get(n2));

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int key = entry.getKey();

            heap.add(key);

            if (heap.size() > k ) heap.poll();

        }

        for (int i = k -1; i >=0 ; i--) {
            output[i] = heap.poll();
        }

        return output;

    }
}

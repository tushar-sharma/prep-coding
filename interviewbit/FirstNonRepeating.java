/**
 *https://www.interviewbit.com/problems/first-non-repeating-character-in-a-stream-of-characters/
 */
class Solution {
    public String solve(String A) {
        StringBuilder sb = new StringBuilder();

        Deque<Character> queue = new ArrayDeque<>();
        Map<Character, Integer> cmap = new HashMap<>();

        for (char c : A.toCharArray()) {

            if (!cmap.containsKey(c)) {
                cmap.put(c, 1);
                queue.offer(c);
            } else {
                cmap.put(c, cmap.get(c) + 1);
            }

            while (!queue.isEmpty() && cmap.get(queue.peek()) != 1) {
                queue.poll();
            }

            if (queue.isEmpty()) {
                sb.append("#");
            } else {
                sb.append(queue.peek());
            }

        }

        return sb.toString();
    }
}


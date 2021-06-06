import java.util.*;

public class LongestSubstringKRepeatingCharacters{

    /**leetcode : https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
     * implementation
    */

    public int longestSubstring(String s, int k) {

       int n = s.length();

        if (n == 0 || n < k) {
            return 0;
        }

        if (k <=1 ) {
            return n;
        }


        Map<Character, Integer> freq = new HashMap<>();

        //O(n)
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int right = 0;
        int output = 0;

        while(right < n && freq.get(s.charAt(right)) >= k) {
            right++;
        }

        if (right >= n -1){
            return right;
        }

        int ls1 = longestSubstring(s.substring(0, right), k);

        while(right < n && freq.get(s.charAt(right)) < k ) {
            right++;
        }


        int ls2 = right < n ? longestSubstring(s.substring(right), k) : 0;


        return Math.max(ls1, ls2);

    }

    public static void main(String[] args) {

        LongestSubstringKRepeatingCharacters ls = new LongestSubstringKRepeatingCharacters();

        assert ls.longestSubstring("aaabbb", 3) == 6;

        assert ls.longestSubstring("ababacb", 3) == 0;

        assert ls.longestSubstring("bbaaacbd", 3) == 3;

    }
}

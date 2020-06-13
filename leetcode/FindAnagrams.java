import java.util.List;
import java.util.ArrayList;

class FindAnagrams {

    public static void findAnagrams(String s, String p) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<Integer>();
        }

        List<Integer> output = new ArrayList<>();

        int[] characterHash = new int[256];

        for (char ch : p.toCharArray()) {
            characterHash[ch]++;
        }

        int left = 0 , right = 0, count = p.length();

        while (right < s.length()) {

            //move right everytime, if the character exists in p's hash, decrease the count
            //currrent hash value >= 1 means that characters is existing in p
            if (characterHash[s.charAt(right)] >= 1) {
                count--;
            }

            characterHash[s.charAt(right)]--;
            right++;

            //when the count is 0, we have find the right anagram
            if (count == 0) {
                output.add(left);
            }

            // if window's size is equal to p, then we move to left to find new match
            // ++ to reset the hash because we kicked out the left
            // only increase the count if the character is in p
            // the count >= 0 indicate it was original in the hash, cos it wont go below 0
            //
            if (right - left == p.length() ) {
                if (characterHash[s.charAt(left)] >= 0) {
                    count++;
                }

                characterHash[s.charAt(left)]++;
                left++;
            }
        }

        return output;

    }

    public static void main(String[] args) {
        findAnagrams("cbaebabacd", "abc");
    }
}

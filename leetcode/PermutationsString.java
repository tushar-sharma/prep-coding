/**
 * leetcode: https://leetcode.com/problems/permutation-in-string/
 */
import java.util.List;
import java.util.ArrayList;

public class PermutationsString {

    public static void swap(char[] ch, int i , int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    public static void getPermutations(char[] s1, List<String> permutations, int n) {

        if (n == 1) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s1.length; i++) {
                sb.append(s1[i]);
            }

            permutations.add(sb.toString());

        } else {
            for (int i = 0; i < n ; i++) {
                swap(s1, i, n - 1);

                getPermutations(s1, permutations, n - 1);

                swap(s1, n - 1, i);
            }
        }
    }

    public static boolean checkInclusion(String s1, String s2) {
        //find all permutations of a string
        List<String> permutations = new ArrayList<>();

        getPermutations(s1.toCharArray(), permutations, s1.length());

        boolean result = false;

        for (String iter : permutations) {
            result = result || s2.contains(iter);
        }

        // check if permutation is substring of s2
        return result;
    }

    public static void main(String[] args) {
        assert checkInclusion("ab", "eidbaoo") == true;
    }

}

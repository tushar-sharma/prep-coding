/*
 * leetcode:  https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;
import java.util.Set;
import java.util.TreeSet;
import java.util.SortedSet;

public class MinimumValidParentheses {

    public static void main(String[] args) {

        assert minRemoveToMakeValid("a)b(c)d").equals("ab(c)d") == true;
    }


    public static String minRemoveToMakeValid(String s) {

        if (s.isEmpty()) {
            return "";
        }

        Stack<Character> braces = new Stack<>();

        SortedSet<Integer> indices = new TreeSet<>();

        Map<Character, Character> mapLetters  = new HashMap<>();
        mapLetters.put('{', '}');
        mapLetters.put('[', ']');
        mapLetters.put('(', ')');

        int prev = 0;

        for (int i = 0; i < s.length(); i++)  {
            char ch = s.charAt(i);

            if(mapLetters.containsKey(ch)) {
                braces.push(ch);
                indices.add(i);
                prev = i;
            }
            else if (mapLetters.containsValue(ch) ) {
                if (!braces.isEmpty() && mapLetters.get(braces.peek()) != null && mapLetters.get(braces.peek()) == ch )  {
                    braces.pop();

                    indices.remove(indices.last());


                }
                else {
                    braces.push(ch);
                    indices.add(i);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (!indices.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();

    }

}

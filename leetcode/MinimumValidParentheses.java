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

    class SS {
        int index;
        char ch;

        public SS(int index, char ch) {
            this.index = index;
            this.ch = ch;

        }
    }

    public static void main(String[] args) {

        assert minRemoveToMakeValid("a)b(c)d").equals("ab(c)d") == true;
    }

    public static String minRemoveToMakeValid(String s) {

    public String minRemoveToMakeValid(String s) {
        if (s.isEmpty()) {
            return "";
        }

        Stack<SS> braces = new Stack<>();

        Map<Character, Character> mapLetters  = new HashMap<>();
        mapLetters.put('{', '}');
        mapLetters.put('[', ']');
        mapLetters.put('(', ')');


        for (int i = 0; i < s.length(); i++)  {

            char ch = s.charAt(i);

            if(mapLetters.containsKey(ch)) {
                braces.push(new SS(i, ch));
            } else if (ch == ']' || ch == ')' || ch == '}' ) {

                if (!braces.isEmpty() && mapLetters.get(braces.peek().ch) != null && mapLetters.get(braces.peek().ch) == ch) {
                    braces.pop();
                }
                else {
                    braces.push(new SS(i, ch));
                }
            }
        }



        StringBuilder sb = new StringBuilder();

        boolean[] indices = new boolean[s.length()];

        Iterator<SS> iter = braces.iterator();

        while(iter.hasNext()){
            indices[iter.next().index] = true;
        }


        for (int i = 0; i < s.length(); i++) {
            if (!indices[i]) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();

    }

}

import java.util.Stack;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
/**
 * check valid parenthesis
 */
public class ValidParenth {

    /**
     * @param testString string
     * @return boolean
     */
    public static boolean isValid(String testString) {
        Stack<Character> myStack = new Stack<>();
        //TODO: remember two parameter
        Map<Character, Character> myMap = new HashMap<>();
        //TODO: remember character with single quote
        myMap.put('{', '}');
        myMap.put('[', ']');
        myMap.put('(', ')');

        for (Character ch : testString.toCharArray()) {

            if (myMap.containsKey(ch)) {
                myStack.push(ch);
            } else if (myMap.containsValue(ch)) {

                if (myStack.isEmpty()) {
                    return false;
                }

                if (myMap.get(myStack.pop()) != ch) {
                    return false;
                }
            }
        }


        /*Iterator<Character> iter = myStack.iterator();

        while (iter.hasNext() ) {
            System.out.println(iter.next());
        }*/

        if (myStack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        assert isValid("()") == true;

        assert isValid("()[]{}") == true;

        assert isValid("([") == false;

        assert isValid("{[]}") == true;
    }
}

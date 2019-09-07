import java.util.Map;
import java.util.HashMap;

/**
 * Find the first occurance of non-repeating character
 */
public class FirstUnique {

    /**
     * @param testString string
     * @return index of first occurance of non repeating character
     *         -1 if not found
     */
    public static int findFirstUnique(String testString) {

        Map<Character, Integer> myMap = new HashMap<Character, Integer>();

        //TODO :remember how to iterate over string
        for (Character ch : testString.toCharArray()) {
            //TODO: remember if key exits in hashmap
            if (myMap.containsKey(ch)) {
                myMap.put(ch, myMap.get(ch) + 1);
            } else {
                myMap.put(ch, 1);
            }
        }

        int index  = 0;
        for (Character ch : testString.toCharArray()) {
            if (myMap.get(ch) ==  1) {
                return index;
            }
            index++;
        }

        return -1;

    }

    public static void main(String[] args){

        assert findFirstUnique("leetcode") == 0;

        assert findFirstUnique("loveleetcode") == 2;

    }
}

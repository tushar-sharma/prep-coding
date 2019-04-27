/**
 * if a permutation of a string is palindrome
 */
import java.util.Map;
import java.util.HashMap;

class PermPalin {

    public static boolean ifPermPalin(String inputStr) {

        if(inputStr.length() < 1) {
            return false;
        }

        else if(inputStr.length() == 1) {
            return true;
        }

        /*else if(inputStr.length() == 2) {
            return inputStr[0] == inputStr[1];
        }*/

        else {
            HashMap<Character, Integer> hmPalin = new HashMap<>();

            for (char iter : inputStr.toCharArray()) {
                if(hmPalin.containsKey(iter)) {
                    int count = hmPalin.get(iter);
                    hmPalin.put(iter, count +1 );
                } else {
                    hmPalin.put(iter, 1);
                }
            }

            int odd_value = 0;
            for(Map.Entry<Character, Integer> entry : hmPalin.entrySet()) {
                Integer value = entry.getValue();
                if(odd_value >1) {
                    return false;
                }

                if ((value % 2) != 0) {
                    odd_value++;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {

        assert ifPermPalin("aab") == true;

        assert ifPermPalin("code") == false;

        assert ifPermPalin("carerac") == true;
    }
}

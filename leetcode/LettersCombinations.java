import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LettersCombinations {

    public static void letterCombinationsRec(String digits,
                                             StringBuilder sb,
                                             Map<Character, String> mapLetters,
                                             List<String> outputDigits) {


        if (sb.length() == digits.length()) {
            outputDigits.add(sb.toString());
            return;
        }

        for (char ch : mapLetters.get(digits.charAt(sb.length())).toCharArray()) {
            sb.append(ch);
            letterCombinationsRec(digits,
                                  sb,
                                  mapLetters,
                                  outputDigits);

            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static List<String> letterCombinations(String digits) {

        List<String> outputDigits = new ArrayList<>();

        if (digits == null || digits.isEmpty()) {
            return outputDigits;
        }

        Map<Character, String> mapLetters = new HashMap<Character, String>();

        mapLetters.put('2', "abc");
        mapLetters.put('3', "def");
        mapLetters.put('4', "ghi");
        mapLetters.put('5', "jkl");
        mapLetters.put('6', "mno");
        mapLetters.put('7', "pqrs");
        mapLetters.put('8', "tuv");
        mapLetters.put('9', "wxyz");


        StringBuilder sb = new StringBuilder();
        letterCombinationsRec(digits,
                              sb,
                              mapLetters,
                              outputDigits);


        return outputDigits;
    }

    public static void main(String[] args) {

        letterCombinations("23");
    }
}

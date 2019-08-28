/*
 * Group anagrams
 * https://leetcode.com/problems/group-anagrams/
 */
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class GroupAnagram {

    /**
     * @param strs string array
     * @return list of list of string
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<Integer>> testMap = new HashMap<>();

        int index = 0;

        for (String str : strs) {
            //TODO: remember how to sort string
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String newStr = new String(strArray);

            if (!testMap.containsKey(newStr) ) {
                //TODO: remember how to insert value in ArrayList
                testMap.put(newStr, new ArrayList<>(Arrays.asList(index)));
            } else {
                testMap.get(newStr).add(index);
            }
            index++;
        }

        //TODO: remember how to create list of list
        List<List<String>> result = new ArrayList<List<String>>();

        //TODO: remember how to iterate hashmap
        for (Map.Entry<String, List<Integer>> entry : testMap.entrySet()) {
            //TODO: remember how to get values
            List<Integer> testIndex =  entry.getValue();
            List<String> tmpString = new ArrayList<String>();

            for (int iter : testIndex) {
                tmpString.add(strs[iter]);
            }

            result.add(tmpString);
        }

        return result;
    }

    public static void main(String[] args) {

        String[] testInput = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(groupAnagrams(testInput));
    }
}

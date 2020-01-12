/**
 * Problem: Two Sum
 * See: twoSum
 * url : https://leetcode.com/problems/two-sum/description/
 */
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsDifferences = new HashMap<Integer, Integer>();
        int[] indexDifferences = new int[]{-1, -1};

        for (int i = 0; i < nums.length; i++) {
            if (numsDifferences.containsKey(target - nums[i])) {
                indexDifferences[0] = numsDifferences.get(target - nums[i]);
                indexDifferences[1] = i;
            } else {
                numsDifferences.put(nums[i], i);
            }
        }

        return indexDifferences;
    }

    public static void main(String[] args) {

        assert Arrays.equals(twoSum(new int[]{3, 2, 4}, 6), new int[]{1, 2});

        assert Arrays.equals(twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1});

    }

}


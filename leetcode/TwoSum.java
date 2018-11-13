/**
 *Problem: https://leetcode.com/problems/two-sum/description/
 */
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {



        int[] result = new int[2];
        HashMap<Integer, Integer> values = new HashMap<>();


        for (int i = 0; i < nums.length; i++){

            if (values.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = values.get(target - nums[i]);
            }

            values.put(nums[i], i);
        }

        return result;

    }

    public static boolean isConsistent(int[] foo, int[] bar) {
        return Arrays.equals(foo, bar);
    }

    public static void main(String[] args) {

        //assert isConsistent(twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1});

        //twoSum(new int[]{3, 2, 3}, 6);
        twoSum(new int[]{3, 2, 4}, 6);

    }

}


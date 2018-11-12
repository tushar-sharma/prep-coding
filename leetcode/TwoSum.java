/**
 *Problem: https://leetcode.com/problems/two-sum/description/
 */

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];


        //is nums sorted? , let me assume
        for (int i = 0; i < nums.length; i++){
            int ret = search_binary(nums, target - nums[i], 0, nums.length - 1) ;

            if(ret != - 1) {

                result[0] = i;
                result[1] = ret;
            }
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        return result;

    }

    //implement binary search
    public static int search_binary(int[] nums, int target, int left, int right) {

        //need a base case
        if (left >= right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid;
        }
        else if (nums[mid] > target) {
            return search_binary(nums, target, left, mid - 1);
        }  else {
            return search_binary(nums, target, mid + 1, right);
        }
    }

    public static void main(String[] args) {

        int[] nums = {2,7,11,15};

        twoSum(nums, 9);

    }

}


/**
 *https://leetcode.com/problems/two-sum/description/
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        ArrayList<Integer> result = new ArrayList<>();

        //is nums sorted? , let me assume
        for (int i = 0; i < nums.length; i++){
            if(search_binary(nums, target - nums[i], 0, nums.length - 1)) {
                result.add(nums[i]);
            }
        }

        return result;

    }

    //implement binary search
    public boolean search_binary(int[] nums, int target, int left, int right) {

        //need a base case
        if (left >= right) {
            return false;
        }

        mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return true;
        }
        else if (nums[mid] > target) {
            return search_binary(nums, target, left, mid - 1);
        }  else {
            return search_binary(nums, target, mid + 1, right);
        }
    }

    public static void main(String[] args) {

        int[] nums = [2,7,11,15];

        System.out.println(twoSum(nums, 9));

    }

}


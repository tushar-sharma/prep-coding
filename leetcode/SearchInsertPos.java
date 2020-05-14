/**
 * leetcode: https://leetcode.com/problems/search-insert-position/
 */

public class SearchInsertPos{

    public static int binarySearch(int[] nums, int left, int right, int target) {

        if (left > right) {
            return left;
        }

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        else if (nums[mid] > target) {
            return binarySearch(nums, left, mid - 1, target);
        } else {
            return binarySearch(nums, mid + 1, right, target);
        }
    }

    public static int searchInsert(int[] nums, int target) {

        if(nums.length == 0) {
          return 0;
        }

        return binarySearch(nums, 0, nums.length -1, target);

    }

    public static void main(String[] args) {

        assert searchInsert(new int[]{1, 3, 5, 6}, 5) == 2;

        assert searchInsert(new int[]{1, 3, 5, 6}, 2) == 1;

        assert searchInsert(new int[]{1, 3, 5, 6}, 0) == 0;

    }
}

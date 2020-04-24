import java.util.Arrays;

/*
 ** leetcode : https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDupSortArr{

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int removeDuplicates(int[] nums) {

        if (nums.length == 1) {
            return 1;
        }

        int pivot = 0;

        int i = 1, j;
        int count;

        while (i < nums.length) {

            j = i;

            while (j < nums.length && nums[j] <= nums[pivot]){
                j++;
            }

            if (j < nums.length) {
                 pivot++;
                 swap(nums, pivot, j);
            }

            i = j + 1;
        }

        return pivot + 1;

    }

    public static void main(String[] args) {

        assert removeDuplicates(new int[]{1 , 1, 2}) == 2;

        assert removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}) == 5;

    }
}

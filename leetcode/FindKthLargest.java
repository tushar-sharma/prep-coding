/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //O(n logn)
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

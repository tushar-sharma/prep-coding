/**
 * Problem url: https://leetcode.com/problems/wiggle-subsequence/
 */
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int inc = 1, dec = 1; 
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                inc = dec + 1; 
            } else if (nums[i] < nums[i - 1]) {
                dec = inc + 1;
            }
        }
        
        return Math.max(inc, dec);
        
    }
}

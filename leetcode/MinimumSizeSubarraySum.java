/**
 * url : https://leetcode.com/problems/minimum-size-subarray-sum/
 */
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int windowStart = 0; 
        int sum = 0;
        
        int minimumLength = Integer.MAX_VALUE;
        
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            
            sum += nums[windowEnd]; 
            
            while (sum >= target) {
                sum -= nums[windowStart];
                
                minimumLength =  Math.min(minimumLength, windowEnd - windowStart + 1);
                windowStart++;

              
            }
            
        }
        
        return minimumLength < Integer.MAX_VALUE ? minimumLength : 0;
    
    }
}

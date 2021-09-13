class Solution {
    public int maxSubArray(int[] nums) {
        
        if (nums.length == 1){
            return nums[0];
        }

        int cSum = nums[0];
        int oSum = nums[0];
        
        for (int i = 1; i < nums.length; i++){
            if (nums[i] > nums[i] + cSum) {
                cSum = nums[i];
                
            } else { 
                cSum += nums[i];
            }
            oSum = Math.max(oSum, cSum);
        }
        
        return oSum;
        
    }
}

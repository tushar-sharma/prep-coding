class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        double average_ratio = Integer.MIN_VALUE; 
        int windowStart = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            
            sum += nums[i];
            
            if (i >= k -1) {
                double ratio = (double) sum / k;
                
                average_ratio = Math.max(average_ratio, ratio);
                
                sum -= nums[windowStart];
                
                windowStart++;
            }
            
        }
        
        return average_ratio;
        
    }
}

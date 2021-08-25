class Solution {
    public int maxArea(int[] height) {
        
        if (height.length <= 1) {
            return 0;
        }
        
        int left = 0;

        int right = height.length - 1; 
                
        int maxArea = 0;
        
        while (true) {
            
            maxArea = Math.max(maxArea,  Math.min(height[right], height[left])  * (right - left));
        
                                                              
            if (height[right] >= height[left]) {
                left++; 
            } else {
                right--;
            } 
        
            if (left == right) {
                break;
            }
            
        }
        
        return maxArea;
        
        
    }
}

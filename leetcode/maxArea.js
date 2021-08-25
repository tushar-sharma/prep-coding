/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {
    
    if (height.length < 2) {
        return 0;
    }
    
    let left = 0;
    let right = height.length - 1;
    let maxArea = 0; 
    
    while(true) {
        maxArea = Math.max(maxArea, Math.min(height[right], height[left]) * (right - left)); 
        
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
    
};

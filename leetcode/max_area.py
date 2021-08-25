class Solution:
    def maxArea(self, height: List[int]) -> int:
        
        if len(height) < 2: 
            return 0
        
        left = 0
        right = len(height)  -1
        max_area = 0
        
        while(True):
            max_area  = max(max_area, min(height[right],  height[left]) * (right - left))
            
            if height[right] >= height[left]:
                left += 1
            else:
                right -= 1
                
            if (left == right):
                break
                
        return max_area

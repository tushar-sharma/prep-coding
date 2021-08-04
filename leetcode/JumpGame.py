class Solution:
    def canJump(self, nums: List[int]) -> bool:
        
        if (len(nums) == 1):
            return True
        
        lastPos = len(nums) - 1
        
        for i in range(len(nums)-2, -1, -1):
            
            if (i + nums[i] >= lastPos):
                lastPos = i
                
        if (lastPos == 0):
            return True
        
        else:
            return False
            
        
class Solution:
    def findKDistantIndices(self, nums: List[int], key: int, k: int) -> List[int]:
        
        indicies = [] 
        
        for x in range(0, len(nums)):
            if nums[x] == key:
                indicies.append(x)
                
        output = [ ]
        
        for x in range(0, len(nums)):
            
            for index in indicies: 
                
                is_index = False
                
                if abs(x - index) <= k:
                    output.append(x)
                    break
                    
        return sorted(output)
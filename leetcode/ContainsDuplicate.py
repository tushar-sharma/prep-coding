from collections import defaultdict

class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:


        if len(nums) == 1:
            return False

        track = defaultdict(list)

        for num in nums:
            if track.get(num):
                return True
            else:
                track[num] = 1

        return False

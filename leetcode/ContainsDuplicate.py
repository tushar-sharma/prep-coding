class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:

        if len(nums) == 1:
            return False

        track = {}

        for num in nums:
            if num in track:
                return True
            else:
                track[num] = 1

        return False


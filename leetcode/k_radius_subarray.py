"""
Things to remember
1. initialize the array with default values
2. List[int] return type in python
"""
class Solution:
    def getAverages(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        output = [-1] * n

        if k > n:
            return output

        left_sum = 0.0
        for i in range(0, k):
            left_sum += nums[i]

        right_sum = 0.0
        for i in range(k + 1, 2 * k + 1):
            if i < n:
                right_sum += nums[i]

        total_elem = 2 * k + 1

        for i in range(k, n -k ):

            output[i] = int((left_sum + nums[i] + right_sum)  / total_elem)

            left_sum  += nums[i]

            if i - k >= 0:
                left_sum = left_sum - nums[i - k]


            if i + 1 < n :
                right_sum -= nums[i  + 1]

            if i + k + 1 < n :
                right_sum += nums[i + k + 1]

        return output

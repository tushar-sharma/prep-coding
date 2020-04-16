#https://leetcode.com/problems/find-pivot-index/

def pivotIndex(nums):

    sums = 0
    leftSum = 0

    for num in nums:
        sums += num

    for i in xrange(0, len(nums)):
        if(leftSum == sums - nums[i] - leftSum):
            return i

        leftSum += nums[i]

    return -1

print(pivotIndex([1, 7, 3, 6, 5, 6]))

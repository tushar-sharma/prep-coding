from collections import Counter
import heapq

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:

        if k == len(nums):
            return nums

        count = Counter(nums)

        maxHeap = []
        for key, value in count.items():
            heapq.heappush(maxHeap, (-value, key))

        output = []

        while k > 0:
            output.append(heapq.heappop(maxHeap)[1])
            k-=1

        return output

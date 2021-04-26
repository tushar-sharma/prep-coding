from collections import Counter
import heapq

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:

        if k == len(nums):
            return nums

        count = Counter(nums)

        print(count)

        heap = []
        for key, value in count.items():
            heapq.heappush(heap, (value, key))

            if (len(heap) > k):
                heapq.heappop(heap)


        output = []

        while k > 0:
            output.append(heapq.heappop(heap)[1])
            k-=1

        return output

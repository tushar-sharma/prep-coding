import heapq

def heapqDemo():
    """
    Using heap API in python
    """

    ## Min Heap

    nums = [3, 7, 9, 8, 5, 6, 1]

    print("Min heap...")

    print("nums : %s" % nums)

    heapq.heapify(nums)

    print("after heapify, nums: %s" % nums)

    print("min element is %s " %  nums[0])

    print("Extract minimum element %s" % heapq.heappop(nums))
        
    print("nums : %s" % nums)

    print("Extract minimum element %s" % heapq.heappop(nums))

    print("nums : %s" % nums)

    ## Max Heap

    nums = [3, 7, 9, 8, 5, 6, 1]

    print("Max heap...")

    print("nums : %s" % nums)

    heapq._heapify_max(nums)

    print("after heapify, nums: %s" % nums)

    print("max element is %s " %  nums[0])

    print("Extract maxium element %s" % heapq._heappop_max(nums))
        
    print("nums : %s" % nums)

    print("Extract maxium element %s" % heapq._heappop_max(nums))

    print("nums : %s" % nums)


if __name__=="__main__":
    heapqDemo()

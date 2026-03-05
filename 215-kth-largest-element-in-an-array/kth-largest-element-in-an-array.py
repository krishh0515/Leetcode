import random

class Solution:
    def findKthLargest(self, nums, k):
        target = len(nums) - k
        left, right = 0, len(nums) - 1
        
        while True:
            pivot = nums[random.randint(left, right)]
            
            l, r = left, right
            i = left
            
            while i <= r:
                if nums[i] < pivot:
                    nums[l], nums[i] = nums[i], nums[l]
                    l += 1
                    i += 1
                elif nums[i] > pivot:
                    nums[r], nums[i] = nums[i], nums[r]
                    r -= 1
                else:
                    i += 1
            
            if target < l:
                right = l - 1
            elif target > r:
                left = r + 1
            else:
                return pivot
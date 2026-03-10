class Solution:
    def findMaxConsecutiveOnes(self, nums):
        left = 0
        max_len = 0
        
        for right in range(len(nums)):
            if nums[right] == 0:
                left = right + 1
            else:
                max_len = max(max_len, right - left + 1)
        
        return max_len
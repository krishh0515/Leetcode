class Solution:
    def subarraysWithKDistinct(self, nums, k):
        return self.atMost(nums, k) - self.atMost(nums, k - 1)

    def atMost(self, nums, k):
        from collections import defaultdict
        
        left = 0
        count = 0
        freq = defaultdict(int)

        for right in range(len(nums)):
            if freq[nums[right]] == 0:
                k -= 1
            
            freq[nums[right]] += 1

            while k < 0:
                freq[nums[left]] -= 1
                if freq[nums[left]] == 0:
                    k += 1
                left += 1

            count += right - left + 1

        return count
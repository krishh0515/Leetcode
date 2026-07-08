class Solution:
    def rob(self, nums):

        if len(nums) == 1:
            return nums[0]

        return max(self.helper(nums[:-1]), self.helper(nums[1:]))

    def helper(self, nums):

        prev2 = 0
        prev1 = 0

        for money in nums:

            curr = max(prev1, prev2 + money)

            prev2 = prev1
            prev1 = curr

        return prev1
class Solution:
    def splitArraySameAverage(self, nums):
        n = len(nums)
        s = sum(nums)

        possible = False
        for k in range(1, n):
            if (s * k) % n == 0:
                possible = True
                break

        if not possible:
            return False

        dp = [set() for _ in range(n + 1)]
        dp[0].add(0)

        for num in nums:
            for k in range(n // 2, 0, -1):
                for prev in list(dp[k - 1]):
                    dp[k].add(prev + num)

        for k in range(1, n):
            if (s * k) % n == 0:
                target = (s * k) // n
                if target in dp[k]:
                    return True

        return False
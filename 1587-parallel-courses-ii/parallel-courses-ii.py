from functools import lru_cache
from itertools import combinations

class Solution:
    def minNumberOfSemesters(self, n, relations, k):
        pre = [0] * n

        for u, v in relations:
            pre[v - 1] |= 1 << (u - 1)

        @lru_cache(None)
        def dfs(mask):
            if mask == (1 << n) - 1:
                return 0

            can = 0

            for i in range(n):
                if not (mask >> i) & 1 and (pre[i] & mask) == pre[i]:
                    can |= 1 << i

            if can.bit_count() <= k:
                return 1 + dfs(mask | can)

            ans = float('inf')

            bits = [i for i in range(n) if (can >> i) & 1]

            for comb in combinations(bits, k):
                nxt = mask

                for b in comb:
                    nxt |= 1 << b

                ans = min(ans, 1 + dfs(nxt))

            return ans

        return dfs(0)
class Solution:
    def crackSafe(self, n: int, k: int) -> str:

        visited = set()
        ans = []

        start = "0" * (n - 1)

        def dfs(node):
            for i in range(k):
                x = str(i)
                edge = node + x

                if edge not in visited:
                    visited.add(edge)
                    dfs(edge[1:])
                    ans.append(x)

        dfs(start)

        return start + "".join(reversed(ans))
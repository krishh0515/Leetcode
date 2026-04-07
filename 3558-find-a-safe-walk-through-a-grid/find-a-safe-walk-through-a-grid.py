from collections import deque

class Solution:
    def findSafeWalk(self, grid: List[List[int]], health: int) -> bool:
        m, n = len(grid), len(grid[0])

        # min_damage[i][j] = min health lost to reach (i, j)
        min_damage = [[float('inf')] * n for _ in range(m)]
        min_damage[0][0] = grid[0][0]

        dq = deque([(0, 0)])

        while dq:
            r, c = dq.popleft()

            for dr, dc in [(-1,0),(1,0),(0,-1),(0,1)]:
                nr, nc = r + dr, c + dc
                if 0 <= nr < m and 0 <= nc < n:
                    cost = grid[nr][nc]
                    new_damage = min_damage[r][c] + cost
                    if new_damage < min_damage[nr][nc]:
                        min_damage[nr][nc] = new_damage
                        if cost == 0:
                            dq.appendleft((nr, nc))  # free move → front
                        else:
                            dq.append((nr, nc))      # costly move → back

        return min_damage[m-1][n-1] < health
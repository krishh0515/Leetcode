class Solution:
    def spiralMatrixIII(self, rows, cols, rStart, cStart):
        ans = []
        r, c = rStart, cStart
        ans.append([r, c])
        step = 1
        while len(ans) < rows * cols:
            for _ in range(step):
                c += 1
                if 0 <= r < rows and 0 <= c < cols:
                    ans.append([r, c])
            for _ in range(step):
                r += 1
                if 0 <= r < rows and 0 <= c < cols:
                    ans.append([r, c])
            step += 1
            for _ in range(step):
                c -= 1
                if 0 <= r < rows and 0 <= c < cols:
                    ans.append([r, c])
            for _ in range(step):
                r -= 1
                if 0 <= r < rows and 0 <= c < cols:
                    ans.append([r, c])
            step += 1
        return ans
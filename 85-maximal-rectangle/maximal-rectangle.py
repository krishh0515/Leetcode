class Solution:
    def maximalRectangle(self, matrix):
        if not matrix:
            return 0

        rows = len(matrix)
        cols = len(matrix[0])
        heights = [0] * cols
        max_area = 0

        for r in range(rows):
            for c in range(cols):
                if matrix[r][c] == "1":
                    heights[c] += 1
                else:
                    heights[c] = 0

            stack = [-1]

            for i in range(cols + 1):
                current = 0 if i == cols else heights[i]

                while stack[-1] != -1 and heights[stack[-1]] > current:
                    h = heights[stack.pop()]
                    width = i - stack[-1] - 1
                    max_area = max(max_area, h * width)

                stack.append(i)

        return max_area
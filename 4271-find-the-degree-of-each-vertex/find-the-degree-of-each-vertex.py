class Solution(object):
    def findDegrees(self, matrix):
        res = []
        for i in range(len(matrix)):
            res.append(sum(matrix[i]))

        return res
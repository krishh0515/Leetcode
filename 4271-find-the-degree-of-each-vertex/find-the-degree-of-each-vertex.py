class Solution(object):
    def findDegrees(self, matrix):

        # Store the degree of each node
        res = []

        # Traverse each row
        for i in range(len(matrix)):

            # Degree equals the sum of the row
            res.append(sum(matrix[i]))

        return res
class Solution:
    def levelOrderBottom(self, root):

        ans = []

        def dfs(node, level):
            if not node:
                return

            # First time reaching this level
            if level == len(ans):
                ans.append([])

            # Add node to its level
            ans[level].append(node.val)

            # Go deeper
            dfs(node.left, level + 1)
            dfs(node.right, level + 1)

        dfs(root, 0)

        return ans[::-1]
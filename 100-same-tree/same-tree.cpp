class Solution {
public:
    bool isSameTree(TreeNode* p, TreeNode* q) {
        // Both are null
        if (!p && !q) return true;

        // One is null, other is not
        if (!p || !q) return false;

        // Values differ
        if (p->val != q->val) return false;

        // Check left and right subtrees
        return isSameTree(p->left, q->left) &&
               isSameTree(p->right, q->right);
    }
};

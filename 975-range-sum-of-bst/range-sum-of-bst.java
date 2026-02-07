/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root,low,high);
        return sum;

        
    }
    public void helper(TreeNode root, int k1,int k2){
        if(root==null){
            return;
        }
        if(root.val>=k1 && root.val<=k2){
            helper(root.left,k1,k2);
            sum+=root.val;
            helper(root.right,k1,k2);
        }
        else if(root.val>k2){
            helper(root.left,k1,k2);
        }
        else{
            helper(root.right,k1,k2);
        }
    }
}
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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> po=new ArrayList<>();
        traversal(root,po);
        return po;

    }
    public void traversal(TreeNode root,List<Integer>po){
        if(root==null){
            return;
        }
        traversal(root.left,po);
        traversal(root.right,po);
        po.add(root.val);
    }
}
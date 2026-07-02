class Solution {
    public static int heightTree(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftheight = heightTree(node.left);
        int rightheight = heightTree(node.right);
        if(leftheight == -1){
            return -1;
        }
        if(rightheight == -1){
            return -1;
        }
        
        if(Math.abs(leftheight - rightheight) > 1){
            return -1;
        }

        return 1 + Math.max(leftheight,rightheight);

    }
    public boolean isBalanced(TreeNode root) {
        
        return heightTree(root) != -1;
        
    }
}
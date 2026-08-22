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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(!isBalanced(root.left)) return false;
        if(!isBalanced(root.right)) return false;

        int left = 0, right = 0;
        if(root.left != null) left = depth(root.left);
        if(root.right != null) right = depth(root.right);
        return Math.abs(left - right) > 1 ? false : true;
    }

    int depth(TreeNode node){
        if(node == null) return 0;

        int left = 0, right = 0;
        if(node.left != null) left = depth(node.left);
        if(node.right != null) right = depth(node.right);
        return 1 + Math.max(left, right);
    }
}
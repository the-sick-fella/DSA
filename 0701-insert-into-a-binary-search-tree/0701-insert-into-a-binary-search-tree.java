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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        add(root, val);
        return root;
    }

    void add(TreeNode node, int val){
        if(node.val > val){
            if(node.left == null) node.left = new TreeNode(val);
            else add(node.left, val);
        }
        else{
            if(node.right == null) node.right = new TreeNode(val);
            else add(node.right, val);
        }
    }
}
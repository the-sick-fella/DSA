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
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        TreeNode temp = new TreeNode(101);
        f(root, temp);
        root.left = null;
        root.right = temp.right.right;
    }

    TreeNode f(TreeNode node, TreeNode curr) {
        curr.right = new TreeNode(node.val);
        curr = curr.right;
        if (node.left != null)
            curr = f(node.left, curr);
        if (node.right != null)
            curr = f(node.right, curr);
        return curr;
    }
}
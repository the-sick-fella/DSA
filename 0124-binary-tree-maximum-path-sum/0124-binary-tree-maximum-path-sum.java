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
    public int maxPathSum(TreeNode root) {
        int w[] = new int[1];
        w[0] = Integer.MIN_VALUE;
        sum(root, w);
        return w[0];
    }

    int sum(TreeNode node, int w []) {
        int l = 0, r = 0;
        if (node.left != null) {
            l = sum(node.left, w);
            if (l < 0) l = 0;
        }
        if (node.right != null) {
            r = sum(node.right, w);
            if (r < 0) r = 0;
        }
        w[0] = Math.max(w[0], l + r + node.val);
        return node.val + Math.max(l, r);
    }
}
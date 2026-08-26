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
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        int w = sum(root);
        return ans;
    }

    int sum(TreeNode node) {
        int l = 0, r = 0;
        if (node.left != null) {
            l = sum(node.left);
            if (l < 0) l = 0;
        }
        if (node.right != null) {
            r = sum(node.right);
            if (r < 0) r = 0;
        }
        ans = Math.max(ans, l + r + node.val);
        return node.val + Math.max(l, r);
    }
}
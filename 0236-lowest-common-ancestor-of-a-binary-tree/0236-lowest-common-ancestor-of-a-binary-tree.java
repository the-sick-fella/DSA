/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return getLCA(root, p, q);
    }

    TreeNode getLCA(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null) return null;
        if(node == p || node == q) return node;

        TreeNode left = getLCA(node.left, p, q);
        TreeNode right = getLCA(node.right, p, q);
        if(left != null && right != null) return node;
        return left != null ? left : right;
    }
}
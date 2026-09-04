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
    public TreeNode buildTree(int[] pre, int[] in) {
        int n = pre.length;
        return construct(pre, 0, n - 1, in, 0, n - 1);
    }

    TreeNode construct(int[] pre, int p1, int p2, int[] in, int i1, int i2) {
        if (p1 > p2 || i1 > i2) return null;
        TreeNode node = new TreeNode(pre[p1]);
        if (p1 < p2) {
            int idx = getIndex(in, i1, i2, pre[p1]);
            node.left = construct(pre, p1 + 1, p1 + (idx - i1), in, i1, idx - 1);
            node.right = construct(pre, p1 + (idx - i1) + 1, p2, in, idx + 1, i2);
        }
        return node;
    }

    int getIndex(int[] nums, int i1, int i2, int val) {
        for (; i1 <= i2; i1++) {
            if (nums[i1] == val)
                return i1;
        }
        return -1;
    }
}
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
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(in[i], i);
        }
        return construct(pre, 0, n - 1, in, 0, n - 1, map);
    }

    TreeNode construct(int[] pre, int p1, int p2, int[] in, int i1, int i2, Map<Integer, Integer> map) {
        if (p1 > p2 || i1 > i2) return null;
        TreeNode node = new TreeNode(pre[p1]);
        if (p1 < p2) {
            int idx = map.get(pre[p1]);
            int numLeft = idx - i1;
            node.left = construct(pre, p1 + 1, p1 + numLeft, in, i1, idx - 1, map);
            node.right = construct(pre, p1 + numLeft + 1, p2, in, idx + 1, i2, map);
        }
        return node;
    }
}
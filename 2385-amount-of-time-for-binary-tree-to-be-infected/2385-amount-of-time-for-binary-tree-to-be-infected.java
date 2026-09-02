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
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> map = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        TreeNode target = null;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.val == start)
                    target = node;
                if (node.left != null) {
                    q.offer(node.left);
                    map.put(node.left, node);
                }
                if (node.right != null) {
                    q.offer(node.right);
                    map.put(node.right, node);
                }
            }
        }

        q = new LinkedList<>();
        q.offer(target);

        int ans = -1;
        Set<TreeNode> burnt = new HashSet<>();

        while (!q.isEmpty()) {
            ans++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                burnt.add(node);

                if (node != root) {
                    TreeNode parent = map.get(node);
                    if (!burnt.contains(parent)) {
                        q.offer(parent);
                        burnt.add(parent);
                    }
                }
                if (node.left != null && !burnt.contains(node.left)) {
                    burnt.add(node.left);
                    q.offer(node.left);
                }
                if (node.right != null && !burnt.contains(node.right)) {
                    burnt.add(node.right);
                    q.offer(node.right);
                }
            }
        }
        return ans;
    }
}
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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
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

        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        for (int i = 0; i < k; i++) {
            if (q.isEmpty()) break;
            int size = q.size();
            for (int j = 0; j < size; j++) {
                TreeNode node = q.poll();

                if (node != root) {
                    TreeNode parent = map.get(node);
                    if (!visited.contains(parent)) {
                        q.offer(parent);
                        visited.add(parent);
                    }
                }

                if(node.left != null && !visited.contains(node.left)){
                    q.offer(node.left);
                    visited.add(node.left);
                }

                if(node.right != null && !visited.contains(node.right)){
                    q.offer(node.right);
                    visited.add(node.right);
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) list.add(q.poll().val);
        return list;
    }
}
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        getPaths(root, list, new StringBuilder());
        return list;
    }

    void getPaths(TreeNode node, List<String> list, StringBuilder sb) {
        int size = sb.length();
        sb.append(node.val);
        if (node.left == null && node.right == null) {
            list.add(sb.toString());
            sb.setLength(size);
            return;
        }

        sb.append("->");
        if (node.left != null) 
            getPaths(node.left, list, sb);
        
        if (node.right != null)
            getPaths(node.right, list, sb);

        sb.setLength(size);
    }
}
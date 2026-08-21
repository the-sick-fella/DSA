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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            while(node.left != null){
                stack.push(node.left);
                node = node.left;
            }

            node = stack.pop();
            list.add(node.val);

            while(node.right == null){
                if(stack.isEmpty()) return list;
                node = stack.pop();
                list.add(node.val);
            }

            stack.push(node.right);
        }
        return list;
    }
}
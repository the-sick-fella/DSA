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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while(!s1.isEmpty()){
            TreeNode node = s1.peek();
            while(node.left != null || node.right != null){
                if(node.right != null){
                    s1.push(node.right);
                    s2.push(node.right);
                }
                if(node.left != null){
                    s1.push(node.left);
                }
                if(s1.peek() == node.right) s2.pop();
                node = s1.peek();
            }

            while(!s1.isEmpty() && (s2.isEmpty() || s1.peek() != s2.peek())){
                list.add(s1.pop().val);
            }
            if(s1.isEmpty()) return list;
            s2.pop();
        }
        return list;
    }
}
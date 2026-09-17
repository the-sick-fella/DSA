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
    public boolean findTarget(TreeNode root, int k) {
        TreeNode n1 = root, n2 = root;
        Stack<TreeNode> st1 = new Stack<>(), st2 = new Stack<>();

        if(n1 == null || n2 == null) return false;

        while(n1.left != null){
            st1.push(n1);
            n1 = n1.left;
        }
        while(n2.right != null){
            st2.push(n2);
            n2 = n2.right;
        }
        while(n1.val < n2.val){
            if(n1 != n2 && n1.val + n2.val == k) return true;
            if(n1.val + n2.val < k){
                n1 = n1.right;
                if(n1 == null){
                    if(st1.isEmpty()) return false;
                    n1 = st1.pop();
                }
                else{
                    while(n1.left != null){
                        st1.push(n1);
                        n1 = n1.left;
                    }
                }
            }
            else {
                n2 = n2.left;
                if(n2 == null){
                    if(st2.isEmpty()) return false;
                    n2 = st2.pop();
                } else{
                    while(n2.right != null){
                        st2.push(n2);
                        n2 = n2.right;
                    }
                }
            }
        }
        return false;
    }
}
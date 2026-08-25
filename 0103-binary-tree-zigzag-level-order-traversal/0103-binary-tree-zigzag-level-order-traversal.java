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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        f(q, ans);
        return ans;
    }

    void f(Queue<TreeNode> q, List<List<Integer>> ans){
        boolean reverse = false;
        while(!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = q.size();
            for(int i = 0; i<size; i++){
                TreeNode node = q.poll();
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
                temp.add(node.val);
            }
            if(reverse) Collections.reverse(temp);
            ans.add(temp);
            reverse = !reverse;
        }
    }
}
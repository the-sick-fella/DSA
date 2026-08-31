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

class Pair{
    TreeNode node;
    int idx;
    public Pair(TreeNode node, int idx){
        this.node = node;
        this.idx = idx;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 1));

        int ans = 1;

        while(!q.isEmpty()){
            int size = q.size();
            int min = 0, max = 0;

            for(int i = 0; i<size; i++){
                Pair p = q.poll();
                int idx = p.idx;
                TreeNode node = p.node;

                if(node.left != null) q.offer(new Pair(node.left, 2*idx));
                if(node.right != null) q.offer(new Pair(node.right, 2*idx+1));

                if(i == 0) min = idx;
                if(i == size-1) max = idx;
            }

            ans = Math.max(ans, max-min+1);
        }
        return ans;
    }
}
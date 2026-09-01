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
            int lmin = 0;

            for(int i = 0; i<size; i++){
                Pair p = q.poll();
                if(i == 0) lmin = p.idx;
                int idx = p.idx - lmin + 1;
                TreeNode node = p.node;

                if(node.left != null) q.offer(new Pair(node.left, 2*idx-1));
                if(node.right != null) q.offer(new Pair(node.right, 2*idx));

                if(i == 0) min = idx;
                if(i == size-1) max = idx;
            }

            ans = Math.max(ans, max);
        }
        return ans;
    }
}
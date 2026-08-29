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
    int col;
    public Pair(TreeNode node, int col){
        this.node = node;
        this.col = col;
    }
 }

class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        if(root.left != null) q.offer(new Pair(root.left, -1));
        if(root.right != null) q.offer(new Pair(root.right, 1));

        while(!q.isEmpty()){
            int size = q.size();
            // int [] nums = new int[q.size()];
            List<Pair> list = new ArrayList<>();
            for(int i = 0; i<size; i++){
                Pair p = q.poll();
                list.add(p);
                TreeNode node = p.node;
                int col = p.col;

                if(node.left != null) q.offer(new Pair(node.left, col-1));
                if(node.right != null) q.offer(new Pair(node.right, col+1));
            }

            if(!symmetric(list)) return false;
        }

        return true;
    }

    boolean symmetric(List<Pair> list){
        if(list.size() % 2 != 0) return false;
        int i = 0, j = list.size()-1;
        while(i<j){
            Pair p1 = list.get(i++), p2 = list.get(j--);
            if(p1.node.val != p2.node.val || (p1.col + p2.col != 0)) return false;
        }
        return true;
    }
}
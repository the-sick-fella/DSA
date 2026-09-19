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

class Custom{
    int smallest, largest, sum, best;
    boolean valid;

    public Custom(int smallest, int largest, int sum, int best, boolean valid){
        this.smallest = smallest;
        this.largest = largest;
        this.sum = sum;
        this.best = best;
        this.valid = valid;
    }
}

class Solution {
    public int maxSumBST(TreeNode root) {
        Custom c = getSum(root);
        return c.best;
    }

    Custom getSum(TreeNode node){
        Custom curr = new Custom(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 0, true);
        if(node == null) return curr;

        Custom left = getSum(node.left);
        Custom right = getSum(node.right);
        

        curr.smallest = Math.min(node.val, Math.min(left.smallest, right.smallest));
        curr.largest = Math.max(node.val, Math.max(left.largest, right.largest));
        if(validate(node, left, right)){
            curr.sum = left.sum + right.sum + node.val;
            curr.best = Math.max(curr.sum, Math.max(left.best, right. best));
        } else{
            curr.valid = false;
            curr.best = Math.max(left.best, right. best);
        }
        return curr;
    }

    boolean validate(TreeNode node, Custom l, Custom r){
        return l.valid && r.valid && node.val > l.largest && node.val < r.smallest;
    }
}
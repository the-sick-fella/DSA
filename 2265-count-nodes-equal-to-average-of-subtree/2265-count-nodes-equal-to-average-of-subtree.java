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
class Combo{
    int ans, count, sum;
    public Combo(int ans, int count, int sum){
        this.ans = ans;
        this.count = count;
        this.sum = sum;
    }
}

class Solution {
    public int averageOfSubtree(TreeNode root) {
        Combo res = getCombo(root);
        return res.ans;
    }

    Combo getCombo(TreeNode node){
        if(node == null) return new Combo(0,0,0);
        Combo left = getCombo(node.left);
        Combo right = getCombo(node.right);
        int ans = left.ans + right.ans;
        int count = left.count + right.count + 1;
        int sum = left.sum + right.sum + node.val;

        if(sum/count == node.val) ans++;
        return new Combo(ans, count, sum);
    }
}
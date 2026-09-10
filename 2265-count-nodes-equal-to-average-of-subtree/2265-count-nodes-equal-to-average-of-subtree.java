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
        left.ans = left.ans + right.ans;
        left.count = left.count + right.count + 1;
        left.sum = left.sum + right.sum + node.val;

        if(left.sum/left.count == node.val) left.ans++;
        return left;
    }
}
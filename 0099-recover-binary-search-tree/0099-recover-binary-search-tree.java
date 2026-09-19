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
    public void recoverTree(TreeNode root) {
        TreeNode [] arr = new TreeNode[3];
        inorder(root, arr);
        int temp = arr[1].val;
        arr[1].val = arr[2].val;
        arr[2].val = temp;
    }

    void inorder(TreeNode node, TreeNode [] arr){
        if(node.left != null) inorder(node.left, arr);
        if(arr[0] != null && node.val < arr[0].val){
            arr[2] = node;
            if(arr[1] == null) arr[1] = arr[0];
        }
        arr[0] = node;
        if(node.right != null) inorder(node.right, arr);
    }
}
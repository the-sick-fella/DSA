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
    public int kthSmallest(TreeNode root, int k) {
        int nums [] = new int[2];
        getElement(root, k, nums);
        return nums[1];
    }

    void getElement(TreeNode node, int k, int [] nums){
        if(node == null || nums[0] == k) return;

        getElement(node.left, k, nums);
        if(nums[0] < k){
            nums[0]++;
            nums[1] = node.val;

            if(nums[0] < k) getElement(node.right, k, nums);
        }
    }
}
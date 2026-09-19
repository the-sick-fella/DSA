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
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        TreeNode f = null;
        TreeNode s = null;
        int idx1 = -1, idx2 = -1; 
        int i = 1;
        while(i<list.size()){
            int curr = list.get(i).val;
            if(curr < list.get(i-1).val){
                if(idx1 == -1) idx1 = i-1;
                else idx2 = i;
            }
            i++;
        }
        f = list.get(idx1);
        if(idx2 == -1) s = list.get(idx1+1);
        else s = list.get(idx2);

        int temp = f.val;
        f.val = s.val;
        s.val = temp; 
    }

    void inorder(TreeNode node, List<TreeNode> list){
        if(node.left != null) inorder(node.left, list);
        list.add(node);
        if(node.right != null) inorder(node.right, list);
    }
}
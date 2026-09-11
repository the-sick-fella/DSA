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
class Pair {
    TreeNode parent;
    TreeNode target;

    public Pair(TreeNode parent, TreeNode target) {
        this.parent = parent;
        this.target = target;
    }
}

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        Pair p = new Pair(null, null);
        getPair(root, key, p);
        TreeNode parent = p.parent;
        TreeNode target = p.target;
        if (target == null)
            return root;
        TreeNode temp;
        if (parent == null) {
            temp = getLargest(root.left);
            if (temp != null) {
                temp.right = root.right;
                return root.left;
            }
            return root.right;
        }

        temp = getLargest(target.left);
        if (temp != null) {
            temp.right = target.right;

            if (parent.left == target)
                parent.left = target.left;
            else
                parent.right = target.left;
        } else {
            if (parent.left == target)
                parent.left = target.right;
            else
                parent.right = target.right;
        }

        return root;
    }

    void getPair(TreeNode node, int key, Pair p){
        if(node == null) return;

        if(node.val == key){
            p.target = node;
            return;
        }

        if(node.val > key) getPair(node.left, key, p);
        else getPair(node.right, key, p);

        if(p.target != null && p.parent == null) p.parent = node;
    }

    TreeNode getLargest(TreeNode node){
        if(node == null) return null;
        while(node.right != null) node = node.right;
        return node;
    }
}
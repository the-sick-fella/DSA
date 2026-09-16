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
class BSTIterator {
    TreeNode root, node;
    Map<TreeNode, TreeNode> map;

    public BSTIterator(TreeNode root) {
        this.root = root;
        node = new TreeNode(-1);
        map = new HashMap<>();

        while(root.left != null){
            map.put(root.left, root);
            root = root.left;
        }
        node.right = root;
    }
    
    public int next() {
        TreeNode temp = getNext();
        return temp.val;
    }

    TreeNode getNext(){
        TreeNode parent = map.get(node);
        map.remove(node);
        if(node.right == null){
            node = parent;
            return parent;
        }

        node = node.right;
        if(parent != null){
            map.put(node, parent);
        }

        while(node.left != null){
            map.put(node.left, node);
            node = node.left;
        }
        return node;
    }
    
    public boolean hasNext() {
        if(node == null) return false;
        return node.right != null || map.get(node) != null;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
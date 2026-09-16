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
    TreeNode node;
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        node = new TreeNode(-1);
        st = new Stack<>();
        while(root.left != null){
            st.push(root);
            root = root.left;
        }
        node.right = root;
    }
    
    public int next() {
        TreeNode temp = getNext();
        return temp.val;
    }

    TreeNode getNext(){
        node = node.right;
        if(node == null) return node = st.pop();
        while(node.left != null){
            st.push(node);
            node = node.left;
        }
        return node;
    }
    
    public boolean hasNext() {
        if(node == null) return false;
        return node.right != null || !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
 
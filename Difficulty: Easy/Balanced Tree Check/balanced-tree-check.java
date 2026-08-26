/* Structure of binary tree node
class Node {
    int data;
    Node left, right;

    Node(int d)
    {
        data = d;
        left = right = null;
    }
}*/

class Solution {
    public boolean isBalanced(Node root) {
        // code here
        return f(root) == -1 ? false : true;
    }
    
    static int f(Node node){
        int l = 0, r = 0;
        if(node.left != null) l = f(node.left);
        if(node.right != null) r = f(node.right);
        if(l == -1 || r == -1 || Math.abs(l-r) > 1) return -1;
        return 1 + Math.max(l, r);
    }
}
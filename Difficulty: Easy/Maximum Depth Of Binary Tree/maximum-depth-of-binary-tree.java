/*  Binary Tree Node Structure
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    public static int maxDepth(Node root) {
        // code here
        return f(root);
    }
    
    static int f(Node node){
        int l = 0, r = 0;
        if(node.left != null) l = f(node.left);
        if(node.right != null) r = f(node.right);
        return 1 + Math.max(l, r);
    }
}

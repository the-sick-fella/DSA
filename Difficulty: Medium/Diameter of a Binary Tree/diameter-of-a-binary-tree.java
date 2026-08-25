/*Structure of binary tree Node
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
};*/

class Solution {
    public int diameter(Node root) {
        // code here
        int ans [] = new int[1];
        ans[0] = 0;
        f(root, ans);
        return ans[0];
    }
    
    static int f(Node node, int ans[]){
        int l = 0, r= 0;
        if(node.left != null) l = f(node.left, ans);
        if(node.right != null) r = f(node.right, ans);
        ans[0] = Math.max(ans[0], l+r);
        return 1 + Math.max(l, r);
    }
}
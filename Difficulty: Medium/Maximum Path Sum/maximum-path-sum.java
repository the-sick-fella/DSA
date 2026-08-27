/* Structure of binary tree node
class Node{
    int data;
    Node left, right;
    Node(int val){
        data = val;
        left = right = null;
    }
}*/

class Solution {
    int findMaxSum(Node root) {
         int ans [] = new int[1];
         ans[0] = Integer.MIN_VALUE;
         f(root, ans);
         return ans[0];
     }

     static int f(Node node, int ans[]){
         int l = 0, r = 0;
         if(node.left != null) l = Math.max(0, f(node.left, ans));
         if(node.right != null) r = Math.max(0, f(node.right, ans));
         ans[0] = Math.max(ans[0], node.data + l + r);
         return node.data + Math.max(l, r);
     }
 }
/* Node Structure
class Node{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
} */
class Solution {
    public boolean isSumProperty(Node root) {
        //  code here
        if(root.left == null && root.right == null) return true;
        int left = 0, right = 0;
        
        if(root.left != null){
            if(!isSumProperty(root.left)) return false;
            left = root.left.data;
        }
        
        if(root.right != null){
            if(!isSumProperty(root.right)) return false;
            right = root.right.data;
        }
        
        return root.data == left + right;
    }
}
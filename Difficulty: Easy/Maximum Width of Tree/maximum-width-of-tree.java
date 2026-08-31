/* Structure of a Binary Tree
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class Solution {
    public int maxWidth(Node root) {
        //  code here
        Queue<Node> q= new LinkedList<>();
        q.offer(root);
        int ans = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                Node node = q.poll();
                
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            ans = Math.max(ans, size);
        }
        
        return ans;
    }
}
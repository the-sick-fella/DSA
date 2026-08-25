/* Structure of Binary Tree Node
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
    ArrayList<Integer> zigZagTraversal(Node root) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        f(q, list);
        return list;
    }
    
    static void f(Queue<Node> q, ArrayList<Integer> list){
        boolean reverse = false;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new LinkedList<>();
            for(int i = 0; i<size; i++){
                Node node = q.poll();
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
                if(reverse) temp.addFirst(node.data);
                else temp.addLast(node.data);
            }
            for(int num : temp) list.add(num);
            !reverse;
        }
    }
}
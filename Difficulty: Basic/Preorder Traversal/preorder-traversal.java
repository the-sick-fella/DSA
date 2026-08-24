/* Structure of Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}*/

class Solution {
    public ArrayList<Integer> preOrder(Node root) {
        //  code here
        ArrayList<Integer> list = new ArrayList<>();
        if(root ==  null) return list;
        
        Stack<Node> st = new Stack<>();
        st.push(root);
        f(st, list);
        return list;
    }
    
    static void f(Stack<Node> st, ArrayList<Integer> list){
        while(!st.isEmpty()){
            Node node = st.pop();
            list.add(node.data);
            
            if(node.right != null) st.push(node.right);
            if(node.left != null) st.push(node.left);
        }
    }
}
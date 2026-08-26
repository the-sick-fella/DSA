/* Node Structure
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    public ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        list.add(root.data);
        if(root.left != null){
            getLeftBoundary(root.left, list);
            getLeafNodes(root.left, list);
        }
        if(root.right != null){
            getLeafNodes(root.right, list);
            List<Integer> temp = new LinkedList<>();
            getRightBoundary(root.right, temp);
            for(int num : temp) list.add(num);
        }
        return list;
    }
    
    static void getLeftBoundary(Node node, ArrayList<Integer> list){
        while(node.left != null || node.right != null){
            list.add(node.data);
            if(node.left != null) node = node.left;
            else node = node.right;
        }
    }
    
    static void getLeafNodes(Node node, ArrayList<Integer> list){
        if(node.left == null && node.right == null){
            list.add(node.data);
            return;
        }
        
        if(node.left != null) getLeafNodes(node.left, list);
        if(node.right != null) getLeafNodes(node.right, list);
    }
    
    
    static void getRightBoundary(Node node, List<Integer> list){
        while(node.left != null || node.right != null){
            list.addFirst(node.data);
            if(node.right != null) node = node.right;
            else node = node.left;
        }
    }
}
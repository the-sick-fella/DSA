/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        getNodes(map, root, 0, 0);
        for(int col : map.keySet()){
            List<int []> curr = map.get(col);
            Collections.sort(curr, (a,b) ->{
               return Integer.compare(a[0], b[0]); 
            });
            list.add(curr.get(0)[1]);
        }
        return list;
    }
    
    void getNodes(TreeMap<Integer, List<int[]>> map, Node node, int row, int col){
        List<int[]> curr = map.getOrDefault(col, new ArrayList<>());
            int temp [] = new int[2];
            temp[0] = row;
            temp[1] = node.data;
        curr.add(temp);
        map.put(col, curr);
        
        if(node.left != null) getNodes(map, node.left, row+1, col-1);
        if(node.right != null) getNodes(map, node.right, row+1, col+1);
    }
}
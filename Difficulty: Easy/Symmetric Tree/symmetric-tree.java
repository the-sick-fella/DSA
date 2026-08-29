/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
  class Pair{
     Node node;
     int col;
     public Pair(Node node, int col){
         this.node = node;
         this.col = col;
     }
  }

class Solution {
    public boolean isSymmetric(Node root) {
        // code here
         Queue<Pair> q = new LinkedList<>();
         if(root.left != null) q.offer(new Pair(root.left, -1));
         if(root.right != null) q.offer(new Pair(root.right, 1));

         while(!q.isEmpty()){
             int size = q.size();
             List<Pair> list = new ArrayList<>();
             for(int i = 0; i<size; i++){
                 Pair p = q.poll();
                 list.add(p);
                 Node node = p.node;
                 int col = p.col;


                 if(node.left != null) q.offer(new Pair(node.left, col-1));
                 if(node.right != null) q.offer(new Pair(node.right, col+1));
             }


             if(!symmetric(list)) return false;
         }


         return true;
     }


     static boolean symmetric(List<Pair> list){
         if(list.size() % 2 != 0) return false;
         int i = 0, j = list.size()-1;
         while(i<j){
             Pair p1 = list.get(i++), p2 = list.get(j--);
             if(p1.node.data != p2.node.data || (p1.col + p2.col != 0)) return false;
         }
         return true;
     }
 }
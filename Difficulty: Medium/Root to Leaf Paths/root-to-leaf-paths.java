/* Definition for Node
class Node
{
    int data;
    Node left;
    Node right;
    Node(int val)
    {
        this.data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public ArrayList<ArrayList<Integer>> paths(Node root) {
        // code here
         ArrayList<ArrayList<Integer>> list = new ArrayList<>();
         getPaths(root, list, new ArrayList<>());
         return list;
     }

     void getPaths(Node node, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> curr) {
         curr.add(node.data);
         if (node.left == null && node.right == null) {
             list.add(new ArrayList<>(curr));
             curr.remove(curr.size()-1);
             return;
         }

         if (node.left != null) 
             getPaths(node.left, list, curr);

         if (node.right != null)
             getPaths(node.right, list, curr);

         curr.remove(curr.size()-1);
     }
 }
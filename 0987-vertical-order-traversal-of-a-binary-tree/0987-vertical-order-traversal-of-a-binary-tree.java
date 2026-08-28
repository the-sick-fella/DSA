/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> colMap = new TreeMap<>();
        f(root, colMap, 0, 0);
        for(int col : colMap.keySet()){
            TreeMap<Integer, List<Integer>> rowMap = colMap.get(col);
            List<Integer> list = new ArrayList<>();
            for(int row : rowMap.keySet()){
                List<Integer> temp = rowMap.get(row);
                Collections.sort(temp);
                for(int val : temp) list.add(val);
            }
            ans.add(list);
        }
        return ans;
    }

    void f(TreeNode node, TreeMap<Integer, TreeMap<Integer, List<Integer>>> colMap, int row, int col){
        TreeMap<Integer, List<Integer>> rowMap = colMap.getOrDefault(col, new TreeMap<>());
        List<Integer> list = rowMap.getOrDefault(row, new ArrayList<>());

        list.add(node.val);
        rowMap.put(row, list);
        colMap.put(col, rowMap);

        if(node.left != null) f(node.left, colMap, row+1, col-1);
        if(node.right != null) f(node.right, colMap, row+1, col+1);
    }
}
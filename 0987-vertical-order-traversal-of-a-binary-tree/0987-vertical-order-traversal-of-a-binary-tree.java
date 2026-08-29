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
        f(root, colMap);
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

    void f(TreeNode root, TreeMap<Integer, TreeMap<Integer, List<Integer>>> colMap){
        Queue<ND> q = new LinkedList<>();
        ND rootND = new ND(root, 0, 0);
        q.offer(rootND);

        while(!q.isEmpty()){
            ND nd = q.poll();
            TreeNode node = nd.node; 
            int row = nd.row, col = nd.col;

            if(node.left != null) q.offer(new ND(node.left, row+1, col-1));
            if(node.right != null) q.offer(new ND(node.right, row+1, col+1));

            TreeMap<Integer, List<Integer>> curr = colMap.getOrDefault(col, new TreeMap<>());
            List<Integer> list = curr.getOrDefault(row, new ArrayList<>());
            list.add(node.val);
            curr.put(row, list);
            colMap.put(col, curr);
        }
    }
}

class ND{
    int row, col;
    TreeNode node;

    public ND(TreeNode node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
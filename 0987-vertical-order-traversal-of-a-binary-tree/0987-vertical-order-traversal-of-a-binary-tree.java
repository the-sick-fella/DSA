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
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        f(map, root, 0, 0);

        for (int key : map.keySet()) {
            List<int[]> temp = map.get(key);

            // Sort by row (index 0) first, then by value (index 1)
            Collections.sort(temp, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]); // Primary: Row asc
                }
                return Integer.compare(a[1], b[1]); // Secondary: Value asc
            });

            // Extract just the node values for the final result
            List<Integer> colValues = new ArrayList<>();
            for (int[] arr : temp) {
                colValues.add(arr[1]);
            }
            list.add(colValues);
        }

        return list;
    }

    void f(TreeMap<Integer, List<int[]>> map, TreeNode node, int row, int col) {
        List<int[]> curr = map.getOrDefault(col, new ArrayList<>());
        int temp [] = new int[2];
        temp[0] = row;
        temp[1] = node.val;
        curr.add(temp);
        map.put(col, curr);

        if (node.left != null)
            f(map, node.left, row + 1, col - 1);
        if (node.right != null)
            f(map, node.right, row + 1, col + 1);
    }
}
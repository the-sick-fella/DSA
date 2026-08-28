/*
Definition for Node
class Node {
	int data;
	Node left;
	Node right;
	
	Node(int val) {
		data = val;
		left = right = null;
		
	}
}
*/

class Solution {
	public ArrayList<Integer> bottomView(Node root) {
		// code here
		ArrayList<Integer> list = new ArrayList<>();
		int range [] = new int [2];
		HashMap<Integer, int[]> map = new HashMap<>();
		getNodes(map, root, 0, 0, range);
		for (int col = range[0]; col <= range[1]; col++) {
			list.add(map.get(col)[1]);
		}
		return list;
	}
	
	void getNodes(HashMap<Integer, int[]> map, Node node, int row, int col, int[] range) {
		int[] curr = map.get(col);
		
		if (curr == null || curr[0] <= row) {
			map.put(col, new int[] {row, node.data});
		}
		
		range[0] = Math.min(range[0], col);
		range[1] = Math.max(range[1], col);
		
		if (node.left != null)
			getNodes(map, node.left, row + 1, col - 1, range);
		if (node.right != null)
			getNodes(map, node.right, row + 1, col + 1, range);
	}
}

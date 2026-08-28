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
		TreeMap<Integer, int[]> map = new TreeMap<>();
		getNodes(map, root, 0, 0);
		for (int col : map.keySet()) {
			list.add(map.get(col)[1]);
		}
		return list;
	}
	
	void getNodes(TreeMap<Integer, int[]> map, Node node, int row, int col) {
		if (map.get(col) == null || map.get(col)[0] <= row)
			map.put(col, new int[] {row, node.data});
		if (node.left != null)
			getNodes(map, node.left, row + 1, col - 1);
		if (node.right != null)
			getNodes(map, node.right, row + 1, col + 1);
	}
}

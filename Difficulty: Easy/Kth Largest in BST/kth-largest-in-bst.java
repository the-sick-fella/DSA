/* Structure of a Binary Tree Node
class Node {
	public int data;
	public Node left;
	public Node right;

	public Node(int val) {
		data = val;
		left = right = null;
	}
}; */

class Solution {
	public int kthLargest(Node root, int k) {
		int temp[] = new int[2];
		getElement(root, k, temp);
		return temp[1];
	}

	static void getElement(Node node, int k, int [] temp) {
		if (node == null || temp[0] == k) return;
		getElement(node.right, k, temp);
		if (temp[0]<k) {
			temp[0]++;
			temp[1] = node.data;

			if (temp[0]<k) getElement(node.left, k, temp);
		}
	}
}
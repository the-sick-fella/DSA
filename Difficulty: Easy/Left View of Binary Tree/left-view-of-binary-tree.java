/* Structure of Binary Tree Node
class Node {
	int data;
	Node left, right;
	
	Node(int val) {
		this.data = val;
		this.left = this.right = null;
	}
} */
// import java.util.*;
class Solution {
	public ArrayList<Integer> leftView(Node root) {
		// code here
		ArrayList<Integer> ans = new ArrayList<>();
		if (root == null)
			return ans;
		Queue <Node> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			int size = q.size();
			Node node = null;
			for (int i = 1; i <= size; i++) {
				node = q.poll();
				if (i == 1)
					ans.add(node.data);
				if (node.left != null)
					q.offer(node.left);
				if (node.right != null)
					q.offer(node.right);
			}
		}
		
		return ans;
	}
}

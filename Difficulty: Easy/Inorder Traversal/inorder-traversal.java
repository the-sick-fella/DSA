/* Structure of Binary Tree Node
class Node {
	int data;
	Node left, right;
	Node(int item) {
		data = item;
		left = right = null;
	}
} */

class Solution {
	public ArrayList<Integer> inOrder(Node root) {
		// code here
		ArrayList<Integer> l = new ArrayList<>();
		if (root == null) return l;
		Stack<Node> st = new Stack<>();
		st.push(root);
		f(st, l);
		return l;
	}
	
	static void f(Stack<Node> st, ArrayList<Integer> l) {
		Node node = st.peek();
		while (!st.isEmpty()) {
			if (node != null) {
				if (node.left != null) st.push(node.left);
				node = node.left;
			} else{
			    node = st.pop();
			    l.add(node.data);
			    node = node.right;
			    if(node != null) st.push(node);
			}
		}
	}
}

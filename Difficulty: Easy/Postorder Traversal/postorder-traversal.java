/* Structure of Binary Tree Node
class Node {
	int data;
	Node left, right;
	Node(int val) {
		data = val;
		left = right = null;
	}
}
*/

class Solution {
	public ArrayList<Integer> postOrder(Node root) {
		// code here
		ArrayList<Integer> l = new ArrayList<>();
		if (root == null) return l;
		Stack<Node> st = new Stack<>();
		st.push(root);
		
		f(st, l);
		return l;
	}
	
	static void f(Stack<Node> st, ArrayList<Integer> l) {
		Stack<Node> st2 = new Stack<>();
		Node node = st.peek();
		while (!st.isEmpty()) {
			if (node != null) {
				if (node.left != null) st.push(node.left);
				node = node.left;
			} else {
				node = st.peek().right;
				if(node == null || (!st2.isEmpty() && node == st2.peek())){
				    node = st.pop();
				    st2.push(node);
				    l.add(node.data);
				    node = null;
				} else{
				    st.push(node);
				}
			}
		}
	}
}
